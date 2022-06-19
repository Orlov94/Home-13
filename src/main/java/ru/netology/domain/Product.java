package ru.netology.domain;

import lombok.Data;


@Data
public class Product {

    protected int id;
    protected String name;
    protected int cost;

    public boolean matches (String search){
        if (this.getName().contains(search)){
            return true;
        }else {
            return false;
        }
    }

}