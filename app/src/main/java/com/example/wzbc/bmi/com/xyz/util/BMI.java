package com.example.wzbc.bmi.com.xyz.util;

import android.widget.EditText;

import com.example.wzbc.bmi.R;

/**
 * Created by WZBC on 2018/3/12.
 */

public class BMI {
    /**
     * @param height 身高
     * @param weight 体重
     */

    public static final int METRIC_SYSTEM=0;
    public static final int IMPERIAL_SYSTEM=1;
    private int system=0;

    private double height;
    private double weight;
    public BMI(double height, double weight){
        this.height=height;
        this.weight=weight;
    }

    public int getSystem() {
        return system;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BMI(int system){
        this.system=system;
    }


    public BMI(double height, double weight,int system){
        this.height=height;
        this.weight=weight;
        this.system=system;
    }

    /**
     * 计算BMI值
     * @return Double类型的BMI值
     */
    public double getBmiValue(){
         if(system==METRIC_SYSTEM){
             return bmiOfMetric();
         }
         else{
             return bmiOfImperial();
         }
    }

    private double bmiOfMetric(){
        double bmi_res;
        bmi_res=weight/(height/100)/(height/100);
        return bmi_res;
    }

    private double bmiOfImperial(){
        double bmi_res;
        bmi_res=(weight*0.45)/(height/0.39/100)/(height/0.39/100);
        return bmi_res;
    }

    /**
     * 计算BMI值并格式化
     * @return 格式化的String类型的BMI值
     */
    public String getBmiValueOfString(){
        String strbmi_res;
        strbmi_res=String.format("%.2f",getBmiValue());
        return strbmi_res;
    }
    /**
     * 获取针对BMI的建议
     * @return 以int表示的针对BMI值的建议
     */
    public int getBmiAdvice(){
        if(getBmiValue()<20){
            return 0;
        }else if(getBmiValue()>=20 && getBmiValue()<=25){
            return 1;
        }else {
            return 2;
        }
    }
}
