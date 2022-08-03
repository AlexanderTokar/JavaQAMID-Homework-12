package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Триумфальная арка", 50, "Эрих Мария Ремарк");
    Product book2 = new Book(2, "1984", 55, "Джордж Оруэлл");
    Product smartphone1 = new Smartphone(3, "IPhone13", 50_000, "Apple");
    Product smartphone2 = new Smartphone(4, "Galaxy S22", 55_000, "Samsung");
    Product smartphone3 = new Smartphone(5, "IPhone13", 50_000, "Apple");


    @BeforeEach
    public void shouldAddProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldFindByName () {
        Product[] exp = {book2};
        Product[] act = manager.searchBy("1984");

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void shouldNotFindByName() {
        Product[] exp = {};
        Product[] act = manager.searchBy("Xiaomi");

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void shouldFindByNameOneOfSomeProducts() {
        Product[] exp = {smartphone1, smartphone3};
        Product[] act = manager.searchBy("IPhone13");

        Assertions.assertArrayEquals(exp, act);
    }

}
