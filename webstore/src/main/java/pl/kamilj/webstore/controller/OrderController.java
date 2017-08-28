package pl.kamilj.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kamilj.webstore.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/P2/2")
    public String process() {
        orderService.processOrder("P2", 2);
        return "redirect:/products";
    }
}
