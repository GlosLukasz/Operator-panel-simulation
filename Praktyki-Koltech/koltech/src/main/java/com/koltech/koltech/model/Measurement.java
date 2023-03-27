package com.koltech.koltech.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float A1;
    private float L_L1;
    private float C_C1;
    private float H;
    private float G;
    private String operatorName;
    private boolean compatibilityA1;
    private boolean compatibilityL_L1;
    private boolean compatibilityC_C1;
    private boolean compatibilityH;
    private boolean compatibilityG;
    private LocalDateTime createdOn;

    public Measurement() {
    }

    public Measurement(float a1, float c_C1,float g,float h, float l_L1,  boolean compatibilityA1, boolean compatibilityC_C1,  boolean compatibilityG,boolean compatibilityH,boolean compatibilityL_L1,String operatorName,LocalDateTime createdOn) {
        A1 = a1;
        L_L1 = l_L1;
        C_C1 = c_C1;
        H = h;
        G = g;
        this.operatorName = operatorName;
        this.compatibilityA1 = compatibilityA1;
        this.compatibilityL_L1 = compatibilityL_L1;
        this.compatibilityC_C1 = compatibilityC_C1;
        this.compatibilityH = compatibilityH;
        this.compatibilityG = compatibilityG;
        this.createdOn=createdOn;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public float getA1() {
        return A1;
    }

    public void setA1(float a1) {
        A1 = a1;
    }

    public float getL_L1() {
        return L_L1;
    }

    public void setL_L1(float l_L1) {
        L_L1 = l_L1;
    }

    public float getC_C1() {
        return C_C1;
    }

    public void setC_C1(float c_C1) {
        C_C1 = c_C1;
    }

    public float getH() {
        return H;
    }

    public void setH(float h) {
        H = h;
    }

    public float getG() {
        return G;
    }

    public void setG(float g) {
        G = g;
    }

    public boolean isCompatibilityA1() {
        return compatibilityA1;
    }

    public void setCompatibilityA1(boolean compatibilityA1) {
        this.compatibilityA1 = compatibilityA1;
    }

    public boolean isCompatibilityL_L1() {
        return compatibilityL_L1;
    }

    public void setCompatibilityL_L1(boolean compatibilityL_L1) {
        this.compatibilityL_L1 = compatibilityL_L1;
    }

    public boolean isCompatibilityC_C1() {
        return compatibilityC_C1;
    }

    public void setCompatibilityC_C1(boolean compatibilityC_C1) {
        this.compatibilityC_C1 = compatibilityC_C1;
    }

    public boolean isCompatibilityH() {
        return compatibilityH;
    }

    public void setCompatibilityH(boolean compatibilityH) {
        this.compatibilityH = compatibilityH;
    }

    public boolean isCompatibilityG() {
        return compatibilityG;
    }

    public void setCompatibilityG(boolean compatibilityG) {
        this.compatibilityG = compatibilityG;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
