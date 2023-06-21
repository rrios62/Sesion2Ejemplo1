package org.bedu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private Database db;

    @BeforeEach
    public void setup() {
        db = new Database();
    }

    @Test
    @DisplayName("The Database can insert data")
    void insert() {
        db.insert(new Product(1, "Coca Cola"));
        db.insert(new Product(2, "Gansito"));
    }

    @Test
    @DisplayName("The size of an empty database is 0")
    void size() {
        assertEquals(db.size(), 0);
    }

    @Test
    @DisplayName("Search by id")
    void getById() {
        db.insert(new Product(1, "Coca Cola"));
        db.insert(new Product(2, "Submarino"));
        db.insert(new Product(3, "Chetos"));
        db.insert(new Product(4, "Mordisko"));

        Product p = db.getById(3);
        assertEquals(p.getId(), 3);
        assertEquals(p.getName(), "Chetos");

    }

    @Test
    @DisplayName("Database can be cleared")
    public void clear() {
        db.insert(new Product(1, "Coca Cola 3lt"));
        db.insert(new Product(2, "Gansito"));
        db.insert(new Product(3, "Mordisko"));
        db.insert(new Product(4, "Sabritas 30g"));

        assertEquals(db.size(), 4);

        db.clear();

        assertEquals(db.size(), 0);
    }
    @Test
    @DisplayName("Test for delete product")
    public void delete(){
        db.insert(new Product(1, "Coca Cola 3lt"));
        db.insert(new Product(2, "Gansito"));
        db.insert(new Product(3, "Mordisko"));
        db.insert(new Product(4, "Sabritas 30g"));
        db.deleteById(3);
        assertEquals(db.size(), 3);
    }
@Test
    @DisplayName("Test to update product")
    public void updateProduct() {
    db.insert(new Product(1, "Coca Cola 3lt"));
    db.insert(new Product(2, "Gansito"));
    db.insert(new Product(3, "Mordisko"));
    db.insert(new Product(4, "Sabritas 30g"));
    db.updateProductNameById(2, "Submarino");
    Product p = db.getById(2);
    assertEquals(p.getId(), 2);
    assertEquals(p.getName(), "Submarino");

}
}