package pl.kamilj.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.kamilj.webstore.domain.Product;
import pl.kamilj.webstore.exeption.NoProductsFoundInSelectedCategoryException;
import pl.kamilj.webstore.exeption.ProductNotFoundException;
import pl.kamilj.webstore.service.ProductService;
import pl.kamilj.webstore.validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductValidator productValidator;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping(value = "/product/{id}")
    public String getProductById(@PathVariable("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(@PathVariable("category") String category, Model model){
       List<Product> products = productService.getProductsByCategory(category);
       if(products == null || products.isEmpty()){
           throw new NoProductsFoundInSelectedCategoryException();
       }
       model.addAttribute("products", products);
       return "products";
    }

    @RequestMapping("/{category}/{price}")
    public String filterProducts(@PathVariable("category") String productCategory,
                                 @RequestParam("manufacturer") String manufacturer,
                                 @MatrixVariable(pathVar = "price") Map<String, List<String>> filterParams,
                                 Model model) {
        Set<Product> commonProducts = new HashSet<>();

        List<Product> productsByCategory = productService.getProductsByCategory(productCategory);
        List<Product> productsByManufacturer = productService.getProductsByManufacturer(manufacturer);

        Set<Product> productsByPrice = productService.getProductsByPriceFilter(filterParams);

        for (Product productOfSelectedCategory : productsByCategory) {
            for (Product productOfSelectedManufacturer : productsByManufacturer) {
                for (Product productWithSelectedPrice : productsByPrice) {
                    if (productWithSelectedPrice.equals(productOfSelectedCategory) &&
                            productWithSelectedPrice.equals(productOfSelectedManufacturer)) {
                        commonProducts.add(productWithSelectedPrice);
                    }
                }
            }
        }
        model.addAttribute("products", commonProducts);

        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(
            @ModelAttribute("newProduct") @Valid Product newProduct,
            BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()){
            return "addProduct";
        }

        String[] suppressedFildes = result.getSuppressedFields();
        if (suppressedFildes.length > 0) {
            throw new RuntimeException("Attempt to bind illegal fields "
                    + StringUtils.arrayToCommaDelimitedString(suppressedFildes));
        }
        MultipartFile productImage = newProduct.getProductImage();
        MultipartFile productInfo = newProduct.getProductInfo();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDirectory + "resources\\images\\"
                        + newProduct.getProductId() + ".jpg"));
            } catch (Exception e) {
                throw new RuntimeException("Failure to save product image", e);
            }
        }
        if (productInfo != null && !productInfo.isEmpty()) {
            try {
                productInfo.transferTo(new File(rootDirectory + "resources\\pdf\\"
                        + newProduct.getProductId() + ".pdf"));
            } catch (Exception e) {
                throw new RuntimeException("Failure to save product information", e);
            }
        }
        productService.addProduct(newProduct);
        return "redirect:/products";
    }

    @RequestMapping("/invalidPromoCode")
    public String invalidPromoCode(){
        return "invalidPromoCode";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setDisallowedFields("unitsInOrder", "discontinued");
        binder.setValidator(productValidator);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception){
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId",exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
        mav.setViewName("productNotFound");

        return mav;
    }
}