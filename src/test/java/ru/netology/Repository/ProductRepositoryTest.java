package ru.netology.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Domain.Book;
import ru.netology.Domain.NotFoundException;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();


    Product first = new Book(1, "Angels and Demons", 2000, "Dan Brown");
    Product second = new Book(2, "Faust", 1500, "Goethe");
    Product third = new Smartphone(3, "3210", 11000, "Nokia");
    Product fourth = new Smartphone(4, "Gold", 23000, "Samsung");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    public void shouldRemoveById() {

        repository.removeById(4);
        Product[] expected = {first, second, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdException() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(8);
        });
    }


    @Test
    public void shouldSaveAll() {

        Product[] expected = {first, second, third, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindAll() {

        repository.findAll();
        Product[] expected = {first, second, third, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {

        repository.findById(2);
        Product[] expected = {second};
        Product[] actual = {second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdNull() {
        repository.findById(5);
        Product[] expected = null;
        Product[] actual = null;
        assertArrayEquals(expected, actual);
    }

}