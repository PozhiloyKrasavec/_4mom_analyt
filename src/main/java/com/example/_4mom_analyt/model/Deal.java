package com.example._4mom_analyt.model;

import java.util.Date;

public class Deal {
    int id;
    int clientId;
    int goodId;
    int time;
    int delivery;
    int finalPrice;
    int deposit;
    Date giveDate;
    Date receiveDate;
    boolean docs;
    String contractNum;

    public Deal(int id, int clientId, int goodId, int time, int delivery, int finalPrice, int deposit, Date giveDate, Date receiveDate, boolean docs, String contractNum) {
        this.id = id;
        this.clientId = clientId;
        this.goodId = goodId;
        this.time = time;
        this.delivery = delivery;
        this.finalPrice = finalPrice;
        this.deposit = deposit;
        this.giveDate = giveDate;
        this.receiveDate = receiveDate;
        this.docs = docs;
        this.contractNum = contractNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public Date getGiveDate() {
        return giveDate;
    }

    public void setGiveDate(Date giveDate) {
        this.giveDate = giveDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public boolean isDocs() {
        return docs;
    }

    public void setDocs(boolean docs) {
        this.docs = docs;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }
}
