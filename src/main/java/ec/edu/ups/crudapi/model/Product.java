package ec.edu.ups.crudapi.model;

import java.time.LocalDate;

public class Product {

    private long id;
    private String name;
    private float price;
    private LocalDate date;
    private int antiquity;

    public Product() {
    }

    public Product(long id, String name, float price, LocalDate date, int antiquity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.antiquity = antiquity;
    }

    public Product(String name, float price, LocalDate date, int antiquity) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.antiquity = antiquity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAntiquity() {
        return antiquity;
    }

    public void setAntiquity(int antiquity) {
        this.antiquity = antiquity;
    }
}
