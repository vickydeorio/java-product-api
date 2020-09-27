package br.com.java.product.api.service;

import br.com.java.product.api.config.ReadApplicationProperties;
import br.com.java.product.api.dao.ProductDAO;
import br.com.java.product.api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.Collator;
import java.util.*;

@Service
public class ProductService {
    @Autowired
    ProductDAO manipulateDAO;
    @Autowired
    ReadApplicationProperties properties = new ReadApplicationProperties();

    public List<Product> getProductOrderedByName(){
        List<Product> orderedProducts = new ArrayList<>();
        orderedProducts.addAll(manipulateDAO.getAll());

        Collator collator = Collator.getInstance(new Locale(properties.getLanguage(),properties.getCountry()));
        if (!orderedProducts.isEmpty()) {
            orderedProducts.sort((p1, p2) -> collator.compare(p1.getName(), p2.getName()));
        }

        return orderedProducts;
    }

    public void addProduct(String name, String desc, Integer price, String brand){

        manipulateDAO.save(name, desc, price, brand);
    }

    public void deleteProduct(String name){

        manipulateDAO.delete(name);
    }

    public Product updateProduct(String name, String newName){

        return manipulateDAO.update(name, newName);
    }

    public List<Product> getProducts(){

        return manipulateDAO.getAll();
    }

    public Product getProductByName(String name){

        return manipulateDAO.getByName(name);
    }

    public Product getProductById(Integer id){

        return manipulateDAO.getById(id);
    }
}
