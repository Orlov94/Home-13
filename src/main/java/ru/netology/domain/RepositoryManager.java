package ru.netology.domain;

public class RepositoryManager {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product newProduct) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newProduct;
        products = tmp;
    }


    public void removeId(int removeById) {

        if (products.length != 0) {
            if (findById(removeById) == null) {
                throw new NotFoundException("Element with id: " + removeById + " not found");
            }
            Product[] tmp = new Product[products.length - 1];
            int copy = 0;

            for (int i = 0; i < products.length; i++) {
                if (products[i].getId() != removeById){
                    tmp[copy] = products[i];
                    copy++;
                }

            }
            products = tmp;
        }else {
            System.out.println("The product to remove was not found");
        }
    }

    public Product findById (int searchId){
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == searchId){
                return products[i];
            }

        }
        return null;
    }

}
