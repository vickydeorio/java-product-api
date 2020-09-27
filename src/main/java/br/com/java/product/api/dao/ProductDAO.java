package br.com.java.product.api.dao;

import br.com.java.product.api.model.Product;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ProductDAO {
    List<Product> products = new ArrayList<>();
    private Integer sequencialId = 0;

    @PostConstruct
    public void init(){
        //Mocked Values
        products.add(new Product(
                getSequencialId(),
                "Beer",
                "Beer is one of the oldest and most widely consumed alcoholic drinks in the world",
                5,
                "VickysBeer"));

        products.add(new Product(
                getSequencialId(),
                "AAWater",
                "Mineral water",
                3,
                "VickysWater"));

        products.add(new Product(
                getSequencialId(),
                "White Wine",
                "Sauvignon Blanc",
                70,
                "VickysWhiteWine"));
    }

    public void save(String name, String desc, Integer price, String brand){

        if(getByName(name) != null) throw new IllegalArgumentException();

        products.add(new Product(getSequencialId(), name, desc, price, brand));
    }

    public Product update(String name, String newName){
        Product p = getByName(name);
        p.setName(newName);

        return p;
    }

    public void delete(String name){
        Product p = getByName(name);

        products.remove(p);
    }

    public List<Product> getAll(){

        return products;
    }

    public Product getByName(String name){
        for (Product p: products){
            if(p.getName().equals(name)) return p;
        }

        return null;
    }

    public Product getById(Integer id){
        for (Product p: products){
            if(p.getId().equals(id)) return p;
        }

        return null;
    }

    public Integer getSequencialId() {
        this.sequencialId = sequencialId + 1;

        return sequencialId;
    }
}
