/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.io.Serializable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
*
* @author epad
*/
public class tableData implements Serializable {

    private String dishName;
    private int Quantity;
    private String Order;
    private double Price;

    public tableData() {
    }

    public tableData(String dishName, int quantity, String order, double price) {
        this.Quantity = quantity;
        this.Order = order;
        this.Price = price;
        this.dishName = dishName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String toString() {
        return getQuantity() + " " + getOrder() + "" + getPrice();
    }
}
