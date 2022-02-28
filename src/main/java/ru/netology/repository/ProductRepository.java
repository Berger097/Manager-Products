package ru.netology.repository;

import ru.netology.product.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product product){
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items,0,tmp,0,items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        items = tmp;
    }

    public Product[] findAll(){
        return items;
    }

    public void removeById(int id){
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item:items) {
            if (item.getId() !=id){
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}

