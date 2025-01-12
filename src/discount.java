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
@Table(name = "discount")
public class discount implements Serializable {
    @Id
    @Column(name = "StudentID")
    private String StudentID;

    @Column(name = "DiscountAmount")
    private double DiscountAmount;

    public discount() {
    }

    public discount(String StudentID, double DiscountAmount) {
        this.StudentID = StudentID;
        this.DiscountAmount = DiscountAmount;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public double getDiscountAmount() {
        return DiscountAmount;
    }

    public void setDiscountAmount(double DiscountAmount) {
        this.DiscountAmount = DiscountAmount;
    }
}
    
