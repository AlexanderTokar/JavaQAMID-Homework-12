package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.*;
import ru.netology.manager.ProductManager;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Триумфальная арка", 50, "Эрих Мария Ремарк");
    Product book2 = new Book(2, "1984", 55 , "Джордж Оруэлл");
    Product smartphone1 = new Smartphone(3, "Iphone 13", 50_000, "Apple");
    Product smartphone2 = new Smartphone(4, "Galaxy S22", 55_000, "Samsung");


    @BeforeEach
    public void shouldAddProduct () {
        manager.add (book1);
        manager.add (book2);
        manager.add (smartphone1);
        manager.add (smartphone2);
    }

    @Test
    public void shouldFindByName () {
        Product [] exp = {smartphone1};
        Product [] act = manager.searchBy("Iphone 13");

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void shouldFindByAuthor () {
        Product [] exp = {book1};
        Product [] act = manager.searchBy("Эрих Мария Ремарк");
    }

    @Test
    public void shouldFindByCost () {
        Product [] exp = {book2};
        Product [] act = manager.searchBy("55");
    }
}
