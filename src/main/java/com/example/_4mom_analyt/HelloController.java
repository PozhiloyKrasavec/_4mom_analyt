package com.example._4mom_analyt;

import com.example._4mom_analyt.model.Client;
import com.example._4mom_analyt.model.DatabaseHandler;
import com.example._4mom_analyt.model.Deal;
import com.example._4mom_analyt.model.Good;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    ArrayList<Client> clients;
    ArrayList <Good> goods;
    ArrayList <Deal> deals;
    @FXML
    BarChart<Double,String> barChart;
    @FXML
    TableView<Good> tableView;
    @FXML
    TableColumn<Good,Integer> idColumn;
    @FXML
    TableColumn<Good,String> nameColumn;
    @FXML
    TableColumn<Good,Integer> priceColumn;
    @FXML
    TableColumn<Good,Integer> rentDaysColumn;
    @FXML
    TableColumn<Good,Integer> profitColumn;
    @FXML
    TableColumn<Good,String> paybackColumn;
    @FXML
    TableColumn<Good,String> clientColumn;
    @FXML
    NumberAxis yAxis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        clients = databaseHandler.getClient();
        goods = databaseHandler.getGoods();
        deals = databaseHandler.getDeals();
        tableView.setItems(FXCollections.observableArrayList(goods));
        idColumn.setCellValueFactory(new PropertyValueFactory<Good,Integer>("id"));
        nameColumn.setCellValueFactory(param -> {
            Good temp = param.getValue();
            return new SimpleStringProperty(temp.getBrand() + " " + temp.getModel());
        });
        priceColumn.setCellValueFactory(param -> {
            Good temp = param.getValue();
            return new SimpleIntegerProperty(temp.getQuantity()* temp.getSellPrice()).asObject();
        });
        rentDaysColumn.setCellValueFactory(param -> {
            Good temp = param.getValue();
            int daysQnt = 0;
            for (Deal deal: deals){
                if (deal.getGoodId() == temp.getId()) daysQnt+=deal.getTime();
            }
            return new SimpleIntegerProperty(daysQnt).asObject();
        });
        profitColumn.setCellValueFactory(param -> {
            Good temp = param.getValue();
            int profit = 0;
            for (Deal deal:deals){
                if (deal.getGoodId() == temp.getId()) profit+=deal.getFinalPrice();
            }
            return new SimpleIntegerProperty(profit).asObject();
        });
        paybackColumn.setCellValueFactory(param -> {
            Good temp = param.getValue();
            double price = temp.getSellPrice()*temp.getQuantity();
            double profit = 0;
            for (Deal deal:deals){
                if (deal.getGoodId() == temp.getId()) profit+=deal.getFinalPrice();
            }
            String res = new DecimalFormat("#0.00").format(price/profit);
            return new SimpleStringProperty( res+ "%");
        });
        clientColumn.setCellValueFactory(param -> {
            Good temp = param.getValue();
            String clientsStr = "";
            for (Deal deal:deals){
                if (deal.getGoodId() == temp.getId()){
                    for (Client client : clients){
                        if (deal.getClientId() == client.getId()){
                            clientsStr = clientsStr + client.getFIO() + "\n";
                        }
                    }
                }
            }
            return new SimpleStringProperty(clientsStr);
        });
    }

    public void showPaybackChart(ActionEvent event) throws InterruptedException {
        XYChart.Series<Double,String> dataSeries = new XYChart.Series<Double,String>();
        for (Good good : goods){
            double price = good.getSellPrice()*good.getQuantity();
            double profit = 0;
            for (Deal deal:deals){
                if (deal.getGoodId() == good.getId()) profit+=deal.getFinalPrice();
            }
            Double res = price/profit;
            String goodName = good.getBrand()+" "+good.getModel();
            XYChart.Data<Double,String> temp = new XYChart.Data<Double,String>(
                    res,goodName);
            dataSeries.getData().add(temp);
        }
        yAxis.setAutoRanging(false);
        yAxis.setUpperBound(100);
        dataSeries.setName("Goods Payback");
        barChart.getData().add(dataSeries);
    }
}