package br.com.java.product.api.controller;

import br.com.java.product.api.exception.BadRequestException;
import br.com.java.product.api.exception.ProductNotFoundException;
import br.com.java.product.api.model.Product;
import br.com.java.product.api.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService = new ProductService();

    @ApiOperation(value = "Returns a list of products")
    @ApiResponse(code = 200, message = "List returned successfully")
    @GetMapping(value = "/products", produces = "application/json")
    public @ResponseBody
    List<Product> getAllProducts() {

        return productService.getProducts();
    }

    @ApiOperation(value = "Returns a list of products ordered by Name")
    @ApiResponse(code = 200, message = "List sorted by name successfully")
    @GetMapping(value = "/productsOrdered", produces = "application/json")
    public @ResponseBody
    List<Product> getProductsOrdered() {

        return productService.getProductOrderedByName();
    }

    @ApiOperation(value = "Returns a Product by Name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product found by Name successfully"),
            @ApiResponse(code = 404, message = "Ops! Product not found.")
    })
    @RequestMapping(value = "/product/name", method = RequestMethod.POST, consumes = "text/html", produces = "application/json")
    public @ResponseBody
    Product getProductByName(@RequestBody String name){
        Product p = productService.getProductByName(name);

        if(p != null){
            return p;
        }else{
            throw new ProductNotFoundException();
        }
    }

    @ApiOperation(value = "Returns a Product by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product found by ID successfully"),
            @ApiResponse(code = 404, message = "Ops! Product not found.")
    })
    @RequestMapping(value = "/product/id", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    Product getProductById(@RequestBody Integer id){
        Product p = productService.getProductById(id);

        if(p != null){
            return p;
        }else{
            throw new ProductNotFoundException();
        }
    }

    @ApiOperation(value = "Add a new product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product added successfully"),
            @ApiResponse(code = 400, message = "Bad request: Not a valid value")
    })
    @PutMapping(value = "/product/add")
    public @ResponseBody void saveProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Integer price,
            @RequestParam String brand) {
        try{
            productService.addProduct(name, description, price, brand);

        }catch (Exception e){
            throw new BadRequestException();
        }
    }

    @ApiOperation(value = "Delete a product by name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product deleted successfully"),
            @ApiResponse(code = 400, message = "Bad request: Not a existing name"),
            @ApiResponse(code = 500, message = "Ops! Something went wrong. Product not deleted.")
    })
    @DeleteMapping(value = "/product/delete")
    public @ResponseBody
    void deleteProduct(@RequestParam String name) {
        try{
            productService.deleteProduct(name);

        }catch (Exception e){
            throw new BadRequestException();
        }
    }

    @ApiOperation(value = "Update a product's name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product renamed successfully"),
            @ApiResponse(code = 400, message = "Bad request: Not a existing product"),
            @ApiResponse(code = 500, message = "Ops! Something went wrong. Product not renamed.")
    })
    @PatchMapping(value = "/product/update")
    public @ResponseBody
    Product updateProduct(
            @RequestParam String name,
            @RequestParam String newName) {
        try{
            return productService.updateProduct(name, newName);

        }catch (Exception e){
            throw new BadRequestException();
        }
    }

}
