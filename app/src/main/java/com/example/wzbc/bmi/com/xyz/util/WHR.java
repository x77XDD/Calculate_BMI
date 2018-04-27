package com.example.wzbc.bmi.com.xyz.util;

/**
 * Created by WZBC on 2018/3/29.
 */

public class WHR {
    private double height;
    private double waist;
    public WHR(double height, double waist){
        this.height=height;
        this.waist=waist;
    }

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

    private double calculate_whr(){
        double whr_res;
        whr_res=waist/height;
        return whr_res;
    }

    private  double calculate_idear(){
        double idear_res;
        idear_res=height*0.47;
        return idear_res;
    }

    public String getcalculate_whrString(){
        String strbmi_res;
        strbmi_res=String.format("%.2f",calculate_whr());
        return strbmi_res;
    }

    public String getcalculate_idearString(){
        String strbmi_res;
        strbmi_res= Integer.toString((int)Math.rint(calculate_idear()));
        return strbmi_res;
    }


}
