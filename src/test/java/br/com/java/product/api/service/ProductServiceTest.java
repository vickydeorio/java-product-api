package br.com.java.product.api.service;

import br.com.java.product.api.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Test
    public void testGetProductOrderedByName(){
        //Given
        List<Product> orderedProducts = new ArrayList<>();
        orderedProducts.add(new Product(
                2,
                "AAWater",
                "Mineral water",
                3,
                "VickysWater"));

        orderedProducts.add(new Product(
                1,
                "Beer",
                "Beer is one of the oldest and most widely consumed alcoholic drinks in the world",
                5,
                "VickysBeer"));

        orderedProducts.add(new Product(
                3,
                "White Wine",
                "Sauvignon Blanc",
                70,
                "VickysWhiteWine"));

        //When
        List<Product> products = productService.getProductOrderedByName();

        //Then
        assertThat(products.equals(orderedProducts));
    }

}
