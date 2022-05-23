package com.example._4mom_analyt.model;

public class Client {
    int id;
    String FIO;
    String platform;
    String address;
    String telephone;

    public Client(int id, String FIO, String platform, String address, String telephone) {
        this.id = id;
        this.FIO = FIO;
        this.platform = platform;
        this.address = address;
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
