package org.bedu;

import java.util.LinkedList;
import java.util.List;

public class Database {
    private List<Product> db;

    public Database(){
        db=new LinkedList<>();
    }

    public void insert(Product data) {
        db.add(data);
    }

    public int size() {
        return db.size();
    }

    public Product getById(long id) {
        for (Product product : db) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public void deleteById(long id) {
        Product productToRemove = null;
        for (Product product : db) {
            if (product.getId() == id) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            db.remove(productToRemove);
        }
    }

    public void updateProductNameById(long id, String newName) {
        for (Product product : db) {
            if (product.getId() == id) {
                product.setName(newName);
                break;
            }
        }
    }
    public void clear() {
        db.clear();
    }


}
