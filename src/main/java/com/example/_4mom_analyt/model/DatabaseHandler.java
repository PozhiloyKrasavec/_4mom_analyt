package com.example._4mom_analyt.model;


import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","123456");
        return dbConnection;
    }
    public ArrayList<Good> getGoods(){
        ArrayList<Good> goods = new ArrayList<>();
        ResultSet resultSet = null;
        String select = "SELECT * FROM goods";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String brand = resultSet.getString(2);
                String model = resultSet.getString(3);
                int quantity = resultSet.getInt(4);
                int  sellPrice = resultSet.getInt(5);
                int _7daysPrice = resultSet.getInt(6);
                int _14DaysPrice = resultSet.getInt(7);
                int monthPrice = resultSet.getInt(8);
                int _2monthPrice = resultSet.getInt(9);
                int _3monthPrice = resultSet.getInt(10);
                goods.add(new Good(id, brand, model, quantity,
                        sellPrice, _7daysPrice, _14DaysPrice,
                        monthPrice, _2monthPrice, _3monthPrice));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return goods;
    }
    public ArrayList<Client> getClient(){
        ArrayList<Client> clients = new ArrayList<>();
        ResultSet  resultSet = null;
        String select = "SELECT * FROM clients";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String FIO = resultSet.getString(2);
                String platform = resultSet.getString(3);
                String address = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                clients.add(new Client(id,FIO, platform,address,telephone));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clients;
    }
    public ArrayList<Deal> getDeals(){
        ArrayList<Deal> deals = new ArrayList<>();
        ResultSet resultSet = null;
        String select = "SELECT * FROM deals";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int clientId = resultSet.getInt(2);
                int goodId = resultSet.getInt(3);
                int time = resultSet.getInt(4);
                int delivery = resultSet.getInt(5);
                int FinalPrice = resultSet.getInt(6);
                int Deposit = resultSet.getInt(7);
                Date GiveDate = resultSet.getDate(8);
                Date ReceiveDate = resultSet.getDate(9);
                Boolean docs = resultSet.getBoolean(10);
                String contractNum = resultSet.getString(11);
                deals.add(new Deal(id,clientId,goodId,time,delivery,FinalPrice,Deposit,
                        GiveDate,ReceiveDate,docs,contractNum));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deals;
    }
    public void writeDeal(Deal deal) {
        String insert = "INSERT INTO deals " +
                "(idDeals,clients_idclients," +
                "Goods_idGoods,Time,Delivery" +
                ",FinalPrice,Deposit,GiveDate," +
                "ReceiveDate,Docs,ContractNum)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1,deal.getId());
            preparedStatement.setInt(2,deal.getClientId());
            preparedStatement.setInt(3,deal.getGoodId());
            preparedStatement.setInt(4,deal.getTime());
            preparedStatement.setInt(5,deal.getDelivery());
            preparedStatement.setInt(6,deal.getFinalPrice());
            preparedStatement.setInt(7,deal.getDeposit());
            preparedStatement.setDate(8,new Date(deal.getGiveDate().getTime()));
            preparedStatement.setDate(9,new Date(deal.getReceiveDate().getTime()));
            preparedStatement.setBoolean(10,deal.isDocs());
            preparedStatement.setString(11, deal.getContractNum());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writeGood(Good good){
        String insert = "INSERT INTO goods (idGoods,Brand,Model," +
                "Quantity,SellPrice,7daysPrice," +
                "14daysPrice,MonthPrice,2MonthPrice,3MonthPrice)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1,good.getId());
            preparedStatement.setString(2,good.getBrand());
            preparedStatement.setString(3,good.getModel());
            preparedStatement.setInt(4,good.getQuantity());
            preparedStatement.setInt(5,good.getSellPrice());
            preparedStatement.setInt(6,good.get_7daysPrice());
            preparedStatement.setInt(7,good.get_14daysPrice());
            preparedStatement.setInt(8,good.getMonthPrice());
            preparedStatement.setInt(9,good.get_2monthPrice());
            preparedStatement.setInt(10,good.get_3monthPrice());


            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writeClient(Client client){
        String insert = "INSERT INTO clients" +
                "(idclients,FIO,platform,address,telephone)" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1,client.getId());
            preparedStatement.setString(2, client.getFIO());
            preparedStatement.setString(3, client.getPlatform());
            preparedStatement.setString(4, client.getAddress());
            preparedStatement.setString(5, client.getTelephone());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void updateClient(Client client){
        String update = "UPDATE clients " +
                "SET FIO = ?," +
                "platform = ?," +
                "address = ?," +
                "telephone = ?" +
                " WHERE idclients = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, client.getFIO());
            preparedStatement.setString(2, client.getPlatform());
            preparedStatement.setString(3, client.getAddress());
            preparedStatement.setString(4, client.getTelephone());
            preparedStatement.setInt(5,client.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateDeal(Deal deal){
        String update = "UPDATE deals " +
                "SET clients_idclients = ?," +
                "Goods_idGoods = ?," +
                "Time = ?," +
                "Delivery = ?," +
                "FinalPrice = ?," +
                "Deposit = ?," +
                "GiveDate = ?," +
                "ReceiveDate = ?," +
                "Docs = ?," +
                "ContractNum = ?" +
                " WHERE idDeals = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setInt(1, deal.getClientId());
            preparedStatement.setInt(2, deal.getGoodId());
            preparedStatement.setInt(3, deal.getTime());
            preparedStatement.setInt(4,deal.getDelivery());
            preparedStatement.setInt(5,deal.getFinalPrice());
            preparedStatement.setInt(6,deal.getDeposit());
            preparedStatement.setDate(7,new Date(deal.getGiveDate().getTime()));
            preparedStatement.setDate(8,new Date(deal.getReceiveDate().getTime()));
            preparedStatement.setBoolean(9, deal.isDocs());
            preparedStatement.setString(10,deal.getContractNum());
            preparedStatement.setInt(11,deal.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateGoods(Good good){
        String update = "UPDATE goods " +
                "SET Brand = ?," +
                "Model = ?," +
                "Quantity = ?," +
                "SellPrice = ?," +
                "7daysPrice = ?," +
                "14daysPrice = ?," +
                "MonthPrice = ?," +
                "2monthPrice = ?," +
                "3monthPrice = ?" +
                " WHERE idGoods = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, good.getBrand());
            preparedStatement.setString(2, good.getModel());
            preparedStatement.setInt(3, good.getQuantity());
            preparedStatement.setInt(4,good.getSellPrice());
            preparedStatement.setInt(5,good.get_7daysPrice());
            preparedStatement.setInt(6,good.get_14daysPrice());
            preparedStatement.setInt(7,good.getMonthPrice());
            preparedStatement.setInt(8,good.get_2monthPrice());
            preparedStatement.setInt(9,good.get_3monthPrice());
            preparedStatement.setInt(10,good.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
