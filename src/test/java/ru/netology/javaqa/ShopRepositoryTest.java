package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(15, "холодильник", 50_000);
        Product product2 = new Product(110, "смартфон", 70_000);
        Product product3 = new Product(218, "ноутбук", 120_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(110);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(15, "холодильник", 50_000);
        Product product2 = new Product(110, "смартфон", 70_000);
        Product product3 = new Product(218, "ноутбук", 120_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(150)
        );
    }

}