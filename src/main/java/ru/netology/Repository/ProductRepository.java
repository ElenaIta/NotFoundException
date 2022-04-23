package ru.netology.Repository;

import ru.netology.Domain.NotFoundException;
import ru.netology.Domain.Product;

public class ProductRepository {

    private Product[] products = new Product[0];

    // сохранить элементы
    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    // найти все элементы
    public Product[] findAll() {
        return products;
    }

    // найти по id
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // удалить по id
    public Product removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(id);
        }

        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;

            }
        }
        products = tmp;
        return null;
    }
}
