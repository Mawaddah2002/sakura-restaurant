/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author epad
 */

@Entity
@Table(name = "invoice")
public class invoice implements Serializable {
    @Id
    @Column(name = "orderName")
    private String orderName;

    @Column(name = "price")
    private int price;

    @Column(name = "Quantity")
    private int Quantity;

    public invoice() {
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
}