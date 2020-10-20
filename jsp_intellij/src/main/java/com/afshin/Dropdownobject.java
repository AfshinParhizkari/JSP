package com.afshin;

public class Dropdownobject {
    public Dropdownobject() {
    }
    public Dropdownobject(Integer value, String lable) {
        this.value = value;
        this.lable = lable;
    }

    Integer value;
    String lable;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
