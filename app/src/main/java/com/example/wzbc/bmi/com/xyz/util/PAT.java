package com.example.wzbc.bmi.com.xyz.util;

/**
 * Created by WZBC on 2018/3/29.
 */

public class PAT {
    private double height;
    private double waist;
    private double neck;
    private double hip;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getNeck() {
        return neck;
    }

    public void setNeck(double neck) {
        this.neck = neck;
    }

    public double getHip() {
        return hip;
    }

    public void setHip(double hip) {
        this.hip = hip;
    }

    public PAT(double height, double waist, double neck){
        this.neck=neck;
        this.height=height;
        this.waist=waist;
    }
    public PAT(double height, double waist,double neck, double hip){
        this.height=height;
        this.waist=waist;
        this.neck=neck;
        this.hip=hip;
    }

    public double Man_calculate_fat(){
        double fat_res;
        fat_res=86.01 * Math.log10(waist - neck) - 70.041 * Math.log10(height) + 36.76;
        return fat_res;
    }
    public double Women_calculate_fat(){
        double fat_res;
        fat_res=163.205 * Math.log10(waist + hip - neck) - 97.684 * Math.log10(height) - 78.384;
        return fat_res;
    }

    public String getcalculate_manbfrString(){
        String strbmi_res;
        strbmi_res=String.format("%.2f",Man_calculate_fat());
        return strbmi_res;
    }

    public String getcalculate_womanbfrString(){
        String strbmi_res;
        strbmi_res=String.format("%.2f",Women_calculate_fat());
        return strbmi_res;
    }

}
