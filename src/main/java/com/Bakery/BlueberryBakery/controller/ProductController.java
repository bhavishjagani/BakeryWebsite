package com.Bakery.BlueberryBakery.controller;
import  com.Bakery.BlueberryBakery.model.Product;
import com.Bakery.BlueberryBakery.service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum PriceRange {
    UNDER3(0,3),
    FROM3TO5(3,5),
    FROM5TO10(5,10);
    final int min, max;
    PriceRange(int min, int max) {this.min=min; this.max=max;}

    public static PriceRange getPriceRange(String range) {
        try {
            return PriceRange.valueOf(range.toUpperCase());
        }
        catch (Exception e) {
            return null;
        }
    }
}

@Controller
@RequestMapping("/getProducts")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProductsByPrice(@RequestParam(value = "price", required = false) String price, Model model) {
        List<Product> products = productService.findAll();

        if (price != null && !price.isEmpty()) {
            products = switch (price) {
                case "under3" -> products.stream()
                        .filter(p -> p.getPrice() < 3)
                        .collect(Collectors.toList());
                case "from3to5" -> products.stream()
                        .filter(p -> p.getPrice() >= 3 && p.getPrice() <= 5)
                        .collect(Collectors.toList());
                case "from5to10" -> products.stream()
                        .filter(p -> p.getPrice() > 5 && p.getPrice() <= 10)
                        .collect(Collectors.toList());
                default -> products;
            };
        }

        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getProductType));

        model.addAttribute("groupedProducts", grouped);
        model.addAttribute("selectedRange", price);
        return "menu";
    }
}