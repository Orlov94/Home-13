package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryManagerTest {

    ProductManager manager = new ProductManager();


    Book book1 = new Book(101, "brave new world", 500, "aldous leonard huxley");
    Book book2 = new Book(102, "three comrades,", 450, "remarque erich maria");
    Book book3 = new Book(103, "harry potter and the deathly hallows,", 900, "joanne rowling");
    Book book4 = new Book(104, "atlas shrugged,", 1200, "jayn rand");

    Smartphone smartphone1 = new Smartphone(201, "new iphone", 70000, "usa");
    Smartphone smartphone2 = new Smartphone(202, "samsung", 60000, "south korea");
    Smartphone smartphone3 = new Smartphone(203, "honor", 40000, "china");
    Smartphone smartphone4 = new Smartphone(204, "huawei", 35000, "china");

    @Test
    void shouldDeleteId() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        manager.removeId(101);
        manager.removeId(104);
        manager.removeId(202);
        manager.removeId(203);

        Product[] actual = manager.findAll();
        Product[] expected = {book2, book3, smartphone1, smartphone4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDeleteNotId() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        assertThrows(NotFoundException.class, () -> {
            manager.removeId(10);
        });

    }
}