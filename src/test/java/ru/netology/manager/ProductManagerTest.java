package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "Empire V", 750, "Виктор Пелевин");
    Product product2 = new Book(2, "S.N.U.F.F", 520, "Виктор Пелевин");
    Product product3 = new Book(3, "Чапаев и Пустота", 1500, "Виктор Пелевин");
    Product product4 = new Book(4, "Бэтман Аполло", 700, "Виктор Пелевин");
    Product product5 = new Book(5, "Ананасная вода для прекрасной дамы", 265, "Виктор Пелевин");
    Product product6 = new Book(6, "Generation P", 750, "Виктор Пелевин");

    Product product7 = new Smartphone(7, "Redmi 5Plus", 12990, "Redmi");
    Product product8 = new Smartphone(8, "Xiaomi Mi8T", 16990, "Xiaomi");
    Product product9 = new Smartphone(9, "Lenovo K9", 8990, "Lenovo");
    Product product10 = new Smartphone(10, "Iphone SE 2020", 49990, "Apple");
    Product product11 = new Smartphone(11, "Gnusmas Galaxy Fold", 224990, "Samsung");

    @BeforeEach
    void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
        manager.add(product9);
        manager.add(product10);
        manager.add(product11);
    }

    @Test

    void searchByBrand(){
        Product[]expected = {new Smartphone(9,"Lenovo K9", 8990,"Lenovo")};
        Product[]actual = manager.searchBy("Lenovo");

        assertArrayEquals(expected,actual);
    }

    @Test
    void searchBySmartphoneName(){
        Product[]actual = manager.searchBy("Redmi 5Plus");
        Product[]expected = {new Smartphone(7, "Redmi 5Plus", 12990,"Redmi")};
        assertArrayEquals(expected,actual);
    }

    @Test
    void searchByBookName(){
        Product[]actual = manager.searchBy("Чапаев и Пустота");
        Product[]excepted = {new Book(3, "Чапаев и Пустота", 1500, "Виктор Пелевин")};
        assertArrayEquals(excepted, actual);
    }

    @Test
    void searchByAuthor(){
        Product[]actual =manager.searchBy("Виктор Пелевин");
        Product[]expected = {
                new Book(1, "Empire V", 750, "Виктор Пелевин"),
                new Book(2, "S.N.U.F.F", 520, "Виктор Пелевин"),
                new Book(3, "Чапаев и Пустота", 1500, "Виктор Пелевин"),
                new Book(4, "Бэтман Аполло", 700, "Виктор Пелевин"),
                new Book(5, "Ананасная вода для прекрасной дамы", 265, "Виктор Пелевин"),
                new Book(6, "Generation P", 750, "Виктор Пелевин")};
        assertArrayEquals(expected,actual);
    }

    @Test
    void searchByIncorrectBrand(){
        Product[]actual = manager.searchBy("Самсунг");
        Product[]expected = {};
        assertArrayEquals(expected,actual);
    }

    @Test
    void searchByIncorrectAuthor(){
        Product[]actual = manager.searchBy("Виктор Сорокин");
        Product[]expected = {};
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldRemoveById(){

        repository.removeById(2);
        Product[]actual = repository.findAll();
        Product[]expected = {
                new Book(1, "Empire V", 750, "Виктор Пелевин"),
                new Book(3, "Чапаев и Пустота", 1500, "Виктор Пелевин"),
                new Book(4, "Бэтман Аполло", 700, "Виктор Пелевин"),
                new Book(5, "Ананасная вода для прекрасной дамы", 265, "Виктор Пелевин"),
                new Book(6, "Generation P", 750, "Виктор Пелевин"),
                new Smartphone(7, "Redmi 5Plus", 12990, "Redmi"),
                new Smartphone(8, "Xiaomi Mi8T", 16990, "Xiaomi"),
                new Smartphone(9, "Lenovo K9", 8990, "Lenovo"),
                new Smartphone(10, "Iphone SE 2020", 49990, "Apple"),
                new Smartphone(11, "Gnusmas Galaxy Fold", 224990, "Samsung")
        };
        assertArrayEquals(expected,actual);
    }


}