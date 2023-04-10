/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ProductModel;
import java.util.ArrayList;

/**
 *
 * @author Daniela
 */
public class ProductController {
    
    private ArrayList<ProductModel> products;

    public ProductController() {
        products = new ArrayList<>();
        // Llenar el ArrayList con algunos elementos de ejemplo
        products.add(new ProductModel(1, "Arroz", "arros blanco", 10, "porcion", "20/05/2023"));
        products.add(new ProductModel(2, "Arroz", "arros blanco", 10, "porcion", "20/05/2023"));
        products.add(new ProductModel(3, "Arroz", "arros blanco", 10, "porcion", "20/05/2023"));
    
}

    public void addProducts(ProductModel product) {
        products.add(product);
    }

    public void removeProducts(ProductModel product) {
        products.remove(product);
    }

    public ArrayList<ProductModel> getProducts() {
        return products;
    }
}
