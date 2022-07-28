package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product book1 = new Book(1, "Триумфальная арка", 50, "Эрих Мария Ремарк");
    Product book2 = new Book(2, "1984", 55, "Джордж Оруэлл");
    Product smartphone1 = new Smartphone(3, "Iphone 13", 50_000, "Apple");
    Product smartphone2 = new Smartphone(4, "Galaxy S22", 55_000, "Samsung");

    @Test
    public void shouldSaveProducts () {
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);

        Product [] exp = {book1,book2,smartphone1,smartphone2};
        Product [] act = repository.getProducts();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void shouldRemoveById () {
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.removeById(4);

        Product [] exp = {book1,book2,smartphone1};
        Product [] act = repository.getProducts();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void shouldFindAllProducts () {
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);

        Product[] exp = {book1, book2, smartphone1, smartphone2};
        Product[] act = repository.getProducts();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void shouldRemoveByIdWithExceptions() {
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);

        Assertions.assertThrows(NotFoundExceptions.class, () -> {
            repository.removeById(5);
        });
    }
}
