package model;

import utils.Utils;

public class Product {
    private static int count = 1;

    private int id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.id = count;
        this.name = name;
        this.price = price;
        Product.count += 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Id: " + this.getId() +
                "\nNome: " + this.getName() +
                "\nPreço " + Utils.doubleToString(this.getPrice());
    }
}
