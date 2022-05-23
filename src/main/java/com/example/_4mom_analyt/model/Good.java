package com.example._4mom_analyt.model;

public class Good {
    int id;
    String brand;
    String model;
    int quantity;
    int sellPrice;
    int _7daysPrice;
    int _14daysPrice;
    int monthPrice;
    int _2monthPrice;
    int _3monthPrice;

    public Good(int id, String brand, String model, int quantity, int sellPrice, int _7daysPrice, int _14daysPrice, int monthPrice, int _2monthPrice, int _3monthPrice) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
        this._7daysPrice = _7daysPrice;
        this._14daysPrice = _14daysPrice;
        this.monthPrice = monthPrice;
        this._2monthPrice = _2monthPrice;
        this._3monthPrice = _3monthPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int get_7daysPrice() {
        return _7daysPrice;
    }

    public void set_7daysPrice(int _7daysPrice) {
        this._7daysPrice = _7daysPrice;
    }

    public int get_14daysPrice() {
        return _14daysPrice;
    }

    public void set_14daysPrice(int _14daysPrice) {
        this._14daysPrice = _14daysPrice;
    }

    public int getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(int monthPrice) {
        this.monthPrice = monthPrice;
    }

    public int get_2monthPrice() {
        return _2monthPrice;
    }

    public void set_2monthPrice(int _2monthPrice) {
        this._2monthPrice = _2monthPrice;
    }

    public int get_3monthPrice() {
        return _3monthPrice;
    }

    public void set_3monthPrice(int _3monthPrice) {
        this._3monthPrice = _3monthPrice;
    }
}
