package pl.kamilj.webstore.domain.repository.impl;

import org.springframework.stereotype.Repository;
import pl.kamilj.webstore.domain.Product;
import pl.kamilj.webstore.domain.repository.ProductRepository;
import pl.kamilj.webstore.exeption.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<>();

    public InMemoryProductRepository() {
        Product apple = new Product("P1", "Apple", new BigDecimal(2));
        apple.setDescription("Granny Smith, Royal Gala, Golden Delicious and Pink Lady are just a few of the thousands of different kinds of apple that are grown around the world! You can make dried apple rings at home - ask an adult to help you take out the core, thinly slice the apple and bake the rings in the oven at a low heat.");
        apple.setManufacturer("Polskie Sady");
        apple.setCategory("Fruits");
        apple.setUnitsInStock(100);

        Product banana = new Product("P2", "Banana", new BigDecimal(4));
        banana.setDescription("Bananas make a nutritious snack! They are a great source of energy and contain lots of vitamins and minerals, especially potassium, which is important to help cells, nerves and muscles in your body to work properly and it helps to lower blood pressure.");
        banana.setManufacturer("Chiquita");
        banana.setCategory("Fruits");
        banana.setUnitsInStock(120);

        Product blackGrape = new Product("P3", "Grape", new BigDecimal(8));
        blackGrape.setDescription("Grapes grow in bunches on vines. On the inside, they are sweet, juicy and jelly-like. Green grapes are also called white grapes and are dried to make sultanas. Purple ones can be called black grapes and are dried to make raisins. There are red grapes too - red grape juice tastes totally delicious!");
        blackGrape.setManufacturer("Hortex");
        blackGrape.setCategory("Fruits");
        blackGrape.setUnitsInStock(75);

        Product carrot = new Product("P4", "Carrot", new BigDecimal(1));
        carrot.setDescription("Carrots grow underground and they can be used in all sorts of dishes - from casseroles to cakes. Raw carrots are great to crunch on and they make a healthy juice, too. They contain lots of beta-carotene - this helps us keep our eyes and skin healthy.");
        carrot.setManufacturer("Nudie");
        carrot.setCategory("Vegetables");
        carrot.setUnitsInStock(100);

        Product apricot = new Product("P5", "Apricot", new BigDecimal(6));
        apricot.setDescription("Apricots can be eaten fresh or dried - both are packed with vitamins! Fresh apricots have a soft and slightly furry skin. They make a good lunchbox snack. Apricots are also high in beta-carotene - this helps us keep our eyes and skin healthy.");
        apricot.setManufacturer("Chiquita");
        apricot.setCategory("Fruits");
        apricot.setUnitsInStock(150);

        Product avocado = new Product("P6", "Avocado", new BigDecimal(12));
        avocado.setDescription("It is sometimes called an avocado pear. Avocado is often mistaken for a vegetable because we eat it like a salad vegetable, but it is actually a fruit. Avocados are at their best when they are ripe and very easy to prepare. They can simply be cut in half with the stone removed and eaten with a little salad dressing or chopped into a salad.");
        avocado.setManufacturer("Nudie");
        avocado.setCategory("Fruits");
        avocado.setUnitsInStock(60);

        Product broccoli = new Product("P7", "Broccoli", new BigDecimal(5));
        broccoli.setDescription("Broccoli is closely related to cabbage - and it's another one of those 'greens' we're always being told to eat up. The part of a broccoli plant we normally eat is the lovely flowerhead - the flowers are usually green but sometimes purple. Steamed broccoli is tasty in a salad or stir-fry.");
        broccoli.setManufacturer("Hortex");
        broccoli.setCategory("Vegetables");
        broccoli.setUnitsInStock(80);

        Product cherry = new Product("P8", "Cherry", new BigDecimal(4));
        cherry.setDescription("Cherries are stone fruits - just like their friends the apricots. A cherry tree can carry on producing fruit for 100 years! Cherries grow from stalks in pairs. Ahhh! Sweet ones like the Bing cherry are nicest on their own or in a fruit salad. Sour ones like Morello cherries are tastier cooked.");
        cherry.setManufacturer("Nudie");
        cherry.setCategory("Fruits");
        cherry.setUnitsInStock(240);

        Product garlic = new Product("P9", "Garlic", new BigDecimal(5));
        garlic.setDescription("Did you know garlic can help keep mosquitoes away?! And yes, garlic can make your breath smell a bit... garlicky! We eat all different parts of plants and garlic is the bulb. Open it up and you'll see lots of segments - or cloves - with a papery covering. You only need to use one or two of these to add loads of extra flavour to a food.");
        garlic.setManufacturer("Granny's Secret");
        garlic.setCategory("Vegetables");
        garlic.setUnitsInStock(140);

        Product lemon = new Product("P10", "Lemon", new BigDecimal(2));
        lemon.setDescription("Lemons were used on ships of famous explorers – the vitamin C stopped sailors from getting a disease called scurvy. You can squeeze out the juice and mix it with water to make a zingy drink.");
        lemon.setManufacturer("Hortex");
        lemon.setCategory("Fruits");
        lemon.setUnitsInStock(110);

        Product watermelon = new Product("P11", "Watermelon", new BigDecimal(10));
        watermelon.setDescription("A watermelon is a type of edible fruit. They are 92% water. About six percent of a watermelon is sugar. This makes them very sweet. There are many different types of watermelon. Some have a green rind on the outside and a red-pink flesh on the inside, with black seeds.");
        watermelon.setManufacturer("Hortex");
        watermelon.setCategory("Fruits");
        watermelon.setUnitsInStock(45);

        Product pepper = new Product("P12", "Pepper", new BigDecimal(5));
        pepper.setDescription("Peppers can be red, yellow, green or orange - some are even white or purple! If you don't like the way one colour tastes, you might like another. The green ones are less sweet - red peppers are actually ripened green peppers.");
        pepper.setManufacturer("Granny's Secret");
        pepper.setCategory("Vegetables");
        pepper.setUnitsInStock(70);

        listOfProducts.add(apple);
        listOfProducts.add(banana);
        listOfProducts.add(blackGrape);
        listOfProducts.add(carrot);
        listOfProducts.add(apricot);
        listOfProducts.add(avocado);
        listOfProducts.add(broccoli);
        listOfProducts.add(cherry);
        listOfProducts.add(garlic);
        listOfProducts.add(lemon);
        listOfProducts.add(watermelon);
        listOfProducts.add(pepper);
    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductById(String productId) {
        Product productById = null;
        for (Product product : listOfProducts) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                productById = product;
                break;
            }
        }
        if (productById == null) {
            throw new ProductNotFoundException(productId);
        }
        return productById;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : listOfProducts) {
            if (category.equalsIgnoreCase(product.getCategory())) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<>();
        for (Product product : listOfProducts) {
            if (manufacturer.equalsIgnoreCase(product.getManufacturer())) {
                productsByManufacturer.add(product);
            }
        }
        return productsByManufacturer;
    }

    @Override
    public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByPriceFilter = new HashSet<>();

        Set<String> criterias = filterParams.keySet();

        if (criterias.contains("low") && criterias.contains("high")) {
            BigDecimal low = new BigDecimal(filterParams.get("low").get(0));
            BigDecimal high = new BigDecimal(filterParams.get("high").get(0));

            for (Product product : listOfProducts) {
                int resultLow = low.compareTo(product.getUnitPrice());
                int resultHigh = high.compareTo(product.getUnitPrice());
                if (resultLow <= 0 && resultHigh >= 0) {
                    productsByPriceFilter.add(product);
                }
            }
        }
        return productsByPriceFilter;
    }

    @Override
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }
}
