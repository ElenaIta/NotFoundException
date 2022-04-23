package ru.netology.Manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Domain.Book;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager();

    Product first = new Book(1, "Angels and Demons", 2000, "Dan Brown");
    Product second = new Book(2, "Faust", 1500, "Goethe");
    Product third = new Smartphone(3, "3210", 11000, "Nokia");
    Product fourth = new Smartphone(4, "Gold", 23000, "Samsung");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    public void add() {
        Product[] expected = new Product[] {first, second, third, fourth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByNameBook() {
        Product[] expected = {second};
        Product[] actual = manager.searchBy("Faust");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNoName() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("WOW");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBymanufacturer() {
        Product[] expected = {fourth};
        Product[] actual = manager.searchBy("Gold");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Goethe");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTrue() {
        manager.searchBy("Angels and Demons");
        assertTrue(manager.matches(first, "Angels and Demons"));
    }

    @Test
    public void matchesFalse() {
        manager.searchBy("WOW");
        assertTrue(manager.matches(first, "Angels and Demons"));
    }

}