package ru.netology.Manager;

import ru.netology.Domain.Product;
import ru.netology.Repository.ProductRepository;

public class ProductManager {


    private ProductRepository repository = new ProductRepository();

    // // добавление элементов
    public void add(Product product) {
        repository.save(product);
    }

    public  Product[] getAll() {
        return repository.findAll();
    }

    //  возвращает массив найденных товаров
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}
