package br.com.java.product.api.dao;

import br.com.java.product.api.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductDAOTest {
    @Autowired
    ProductDAO productDAO;

    @Test
    public void testSaveProduct() {
        // Given
        productDAO = new ProductDAO();
        Integer price = 100;
        Product p = new Product(productDAO.getSequencialId(), "Teste", "Teste", price, "Teste");

        // When
        productDAO.save(p.getName(), p.getDescription(), price, p.getBrand());

        //Then
        assertThat(productDAO.products.contains(p));
    }

    @Test
    public void testUpdateProduct() {
        // Given
        productDAO = new ProductDAO();
        Product p = new Product(
                        productDAO.getSequencialId(),
                        "Beer",
                        "Beer is one of the oldest and most widely consumed alcoholic drinks in the world",
                        5,
                        "VickysBeer");
        productDAO.products.add(p);

        // When
        String newName = "New Name Test";

        productDAO.update(p.getName(), newName);
        p.setName(newName);

        //Then
        assertThat(productDAO.products.contains(p));
    }

    @Test
    public void testDeleteProduct() {
        // Given
        productDAO = new ProductDAO();
        Product p = new Product(
                productDAO.getSequencialId(),
                "Beer",
                "Beer is one of the oldest and most widely consumed alcoholic drinks in the world",
                5,
                "VickysBeer");
        productDAO.products.add(p);

        // When
        productDAO.delete(p.getName());

        //Then
        assertThat(!productDAO.products.contains(p));
    }

    @Test
    public void testGetAllProducts() {
        // Given
        productDAO = new ProductDAO();
        productDAO.products.add(new Product(
                productDAO.getSequencialId(),
                "Beer",
                "Beer is one of the oldest and most widely consumed alcoholic drinks in the world",
                5,
                "VickysBeer"));
        List<Product> products = productDAO.products;

        // When
        List<Product> allProducts = productDAO.getAll();

        //Then
        assertThat(allProducts.equals(products));
    }

    @Test
    public void testGetProductByName() {
        // Given
        productDAO = new ProductDAO();
        Product p = new Product(
                productDAO.getSequencialId(),
                "Beer",
                "Beer is one of the oldest and most widely consumed alcoholic drinks in the world",
                5,
                "VickysBeer");
        productDAO.products.add(p);

        // When
        Product returned = productDAO.getByName(p.getName());

        //Then
        assertThat(returned.equals(p));
    }

    @Test
    public void testGetProductById() {
        // Given
        productDAO = new ProductDAO();
        Product p = new Product(
                productDAO.getSequencialId(),
                "Beer",
                "Beer is one of the oldest and most widely consumed alcoholic drinks in the world",
                5,
                "VickysBeer");
        productDAO.products.add(p);

        // When
        Product returned = productDAO.getById(p.getId());

        //Then
        assertThat(returned.equals(p));
    }

    @Test
    public void testGetSequencialId() {
        // Given
        productDAO = new ProductDAO();

        // When
        Integer num1 = productDAO.getSequencialId();
        Integer num2 = productDAO.getSequencialId();
        Integer num3 = productDAO.getSequencialId();

        Integer sub = num3 - num2 - num1;

        //Then
        assertThat(sub.equals(3));
    }

}
