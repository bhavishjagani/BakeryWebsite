package com.Bakery.BlueberryBakery.config;

import com.Bakery.BlueberryBakery.model.Product;
import com.Bakery.BlueberryBakery.service.impl.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
    private final ProductService productService;

    public DataLoader(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void loadData() {
        if (productService.findAll().isEmpty()) {
            productService.save(new Product(null, "Blueberry White Choco Chip", "Soft-baked cookie bursting with blueberries and creamy white chocolate.", "Cookies", 3.50, "/images/blueberry_cookie.jpg"));
            productService.save(new Product(null, "Double Chocolate Chunk", "Rich cocoa cookie loaded with chocolate chips.", "Cookies", 3.00, "/images/choco_cookie.jpg"));
            productService.save(new Product(null, "Oatmeal Raisin", "Chewy oatmeal cookie packed with raisins and a hint of cinnamon.", "Cookies", 3.25, "/images/oatmeal_raisin.jpg"));
            productService.save(new Product(null, "Classic Sugar Cookie", "Sweet and soft cookie with a light vanilla flavor and sugar crystals.", "Cookies", 3.00, "/images/sugar_cookie.jpg"));
            productService.save(new Product(null, "White Chocolate Macadamia", "Delicate cookie with crunchy macadamia nuts and creamy white chocolate.", "Cookies", 3.75, "/images/macadamia_cookie.jpg"));

            productService.save(new Product(null, "Blueberry Lemon Drizzle Cake", "A moist lemon sponge with sweet blueberry topping and lemon glaze.", "Cakes", 6.50, "/images/blueberry_lemon_cake.jpg"));
            productService.save(new Product(null, "Classic Red Velvet", "Velvety red sponge layered with cream cheese frosting.", "Cakes", 6.00, "/images/red_velvet.jpg"));
            productService.save(new Product(null, "Chocolate Fudge Cake", "Decadent layers of chocolate sponge and fudge ganache.", "Cakes", 6.50, "/images/chocolate_cake.jpg"));
            productService.save(new Product(null, "Strawberry Shortcake", "Light vanilla sponge with whipped cream and fresh strawberries.", "Cakes", 6.25, "/images/strawberry_shortcake.jpg"));
            productService.save(new Product(null, "Spiced Carrot Cake", "Moist carrot cake with walnuts and a rich cream cheese frosting.", "Cakes", 6.00, "/images/carrot_cake.jpg"));

            productService.save(new Product(null, "Blueberry Danish", "Flaky pastry filled with rich blueberry compote and a sweet glaze.", "Pastries", 4.00, "/images/blueberry_danish.jpg"));
            productService.save(new Product(null, "Cinnamon Roll", "Swirled pastry with cinnamon sugar and cream cheese frosting.", "Pastries", 4.50, "/images/cinnamon_roll.jpg"));
            productService.save(new Product(null, "Butter Croissant", "Flaky and buttery croissant with a golden crust.", "Pastries", 3.75, "/images/croissant.jpg"));
            productService.save(new Product(null, "Apple Turnover", "Puff pastry filled with spiced apple filling and a light glaze.", "Pastries", 4.25, "/images/apple_turnover.jpg"));
            productService.save(new Product(null, "Cheese Danish", "Sweet pastry filled with creamy cheese and a touch of vanilla.", "Pastries", 4.00, "/images/cheese_danish.jpg"));

            productService.save(new Product(null, "Blueberry Banana Bread", "Classic banana bread with juicy blueberries baked inside.", "Breads", 5.00, "/images/blueberry_banana_bread.jpg"));
            productService.save(new Product(null, "Fresh Sourdough Loaf", "Traditional sourdough with a crispy crust and tangy taste.", "Breads", 5.50, "/images/sourdough.jpg"));
            productService.save(new Product(null, "Garlic Herb Bread", "Freshly baked loaf with roasted garlic and Italian herbs.", "Breads", 4.75, "/images/garlic_bread.jpg"));
            productService.save(new Product(null, "Zucchini Walnut Bread", "Moist zucchini bread with crunchy walnuts and warm spices.", "Breads", 5.00, "/images/zucchini_bread.jpg"));
            productService.save(new Product(null, "Old-Fashioned Rye", "Hearty rye loaf with a rich flavor and chewy texture.", "Breads", 5.25, "/images/rye_bread.jpg"));

            productService.save(new Product(null, "Classic Blueberry Muffin", "Moist muffin filled with wild blueberries and a hint of lemon zest.", "Muffins", 3.75, "/images/blueberry_muffin.jpg"));
            productService.save(new Product(null, "Chocolate Chip Muffin", "Golden muffin loaded with melty chocolate chips.", "Muffins", 3.50, "/images/choco_muffin.jpg"));
            productService.save(new Product(null, "Banana Nut Muffin", "Fluffy muffin with mashed bananas and chopped walnuts.", "Muffins", 3.75, "/images/banana_muffin.jpg"));
            productService.save(new Product(null, "Lemon Poppyseed Muffin", "Bright lemon muffin with crunchy poppyseeds and a citrus glaze.", "Muffins", 3.75, "/images/lemon_poppy_muffin.jpg"));
            productService.save(new Product(null, "Sweet Corn Muffin", "Golden corn muffin with a lightly sweet and crumbly texture.", "Muffins", 3.25, "/images/corn_muffin.jpg"));
        }
    }
}