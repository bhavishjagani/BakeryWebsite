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
            productService.save(new Product("Blueberry White Choco Chip", "Soft-baked cookie bursting with blueberries and creamy white chocolate.", "Cookies", 2.50, "/images/blueberry-cookie.jpg"));
            productService.save(new Product("Double Chocolate Chunk", "Rich cocoa cookie with a crunchy taste loaded with chocolate chips.", "Cookies", 2.00, "/images/choco-cookie.jpg"));
            productService.save(new Product("Oatmeal Raisin", "Chewy oatmeal cookie packed with raisins and a hint of cinnamon.", "Cookies", 2.25, "/images/oatmeal_raisin.jpg"));
            productService.save(new Product("Classic Sugar Cookie", "Sweet and soft cookie with a light vanilla flavor and sugar crystals.", "Cookies", 2.00, "/images/sugar_cookie.jpg"));
            productService.save(new Product("White Chocolate Macadamia", "Delicate cookie with crunchy macadamia nuts and creamy white chocolate.", "Cookies", 3.00, "/images/macadamia_cookie.jpg"));

            productService.save(new Product("Blueberry Lemon Drizzle Cake", "A moist lemon sponge  with sweet blueberry topping and lemon glaze.", "Cakes", 6.50, "/images/blueberry_lemon_cake.jpg"));
            productService.save(new Product("Classic Red Velvet", "Velvety red sponge layered with a rich and sweet cream cheese frosting.", "Cakes", 6.00, "/images/red_velvet.jpg"));
            productService.save(new Product("Chocolate Fudge Cake", "Decadent layers of chocolate sponge and fudge ganache topped with pecans.", "Cakes", 6.50, "/images/chocolate_cake.jpg"));
            productService.save(new Product("Strawberry Shortcake", "Light vanilla sponge with whipped cream and fresh strawberries.", "Cakes", 6.25, "/images/strawberry_shortcake.jpg"));
            productService.save(new Product("Spiced Carrot Cake", "Moist carrot cake with walnuts and a rich cream cheese frosting.", "Cakes", 6.00, "/images/carrot_cake.jpg"));

            productService.save(new Product("Blueberry Danish", "Flaky pastry filled with rich blueberry compote and a sweet glaze.", "Pastries", 4.00, "/images/blueberry_danish.jpg"));
            productService.save(new Product("Cinnamon Roll", "Swirled pastry with cinnamon sugar and cream cheese frosting.", "Pastries", 4.50, "/images/cinnamon_roll.jpg"));
            productService.save(new Product("Butter Croissant", "Flaky and buttery croissant with a golden crust and many soft and chewy layers.", "Pastries", 3.75, "/images/croissant.jpg"));
            productService.save(new Product("Apple Turnover", "Puff pastry filled with spiced apple filling and a light glaze all over.", "Pastries", 5.25, "/images/apple_turnover.jpg"));
            productService.save(new Product("Cheese Danish", "Sweet pastry filled with creamy cheese and a touch of vanilla extract.", "Pastries", 5.00, "/images/cheese_danish.jpg"));

            productService.save(new Product("Blueberry Banana Bread", "Classic banana bread with juicy blueberries and crunchy walnuts baked inside.", "Breads", 5.00, "/images/blueberry_banana_bread.jpg"));
            productService.save(new Product("Fresh Sourdough Loaf", "Traditional sourdough with a very crispy crust and tangy taste.", "Breads", 5.50, "/images/sourdough.jpg"));
            productService.save(new Product("Garlic Herb Bread", "Freshly baked loaf with roasted garlic, Italian herbs, and parmesan cheese.", "Breads", 4.75, "/images/garlic_bread.jpg"));
            productService.save(new Product("Zucchini Walnut Bread", "Moist zucchini bread with crunchy walnuts and warm spices.", "Breads", 5.70, "/images/zucchini_bread.jpg"));
            productService.save(new Product("Old-Fashioned Rye", "Hearty and tangy rye loaf with a dark and rich flavor and chewy texture.", "Breads", 5.25, "/images/rye_bread.jpg"));

            productService.save(new Product("Classic Blueberry Muffin", "Moist muffin filled with wild blueberries and a hint of lemon zest.", "Muffins", 3.75, "/images/classic-blueberry-muffin.jpg"));
            productService.save(new Product("Chocolate Chip Muffin", "Golden muffin loaded with melty chocolate chips and a crispy brown top.", "Muffins", 3.50, "/images/chocolate-chip-muffin.jpg"));
            productService.save(new Product("Banana Nut Muffin", "Fluffy and light muffin with mashed bananas and chopped walnuts.", "Muffins", 3.75, "/images/banana-nut-muffin.jpg"));
            productService.save(new Product("Lemon Poppyseed Muffin", "Bright lemon muffin with crunchy poppyseeds and a citrus glaze.", "Muffins", 3.75, "/images/lemon-poppy-seed-muffin.jpg"));
            productService.save(new Product("Sweet Corn Muffin", "Golden corn muffin with a lightly sweet and crumbly texture.", "Muffins", 3.25, "/images/sweet-corn-muffin.jpg"));
        }
    }
}