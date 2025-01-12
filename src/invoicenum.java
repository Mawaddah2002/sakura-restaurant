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
@Table(name = "invoicenum")
public class invoicenum implements Serializable {
    @Id
    @Column(name = "invoceNumber")
    private int invoceNumber;
    @Column(name = "totalPrice")
    private double totalPrice;

    public invoicenum() {
        // Default constructor
    }

    public invoicenum(int invoceNumber, double totalPrice) {
        this.invoceNumber = invoceNumber;
        this.totalPrice = totalPrice;
    }

    // Getter and Setter methods for attributes
    public int getInvoceNumber() {
        return invoceNumber;
    }

    public void setInvoceNumber(int invoceNumber) {
        this.invoceNumber = invoceNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}