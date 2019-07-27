package com.hmlin5.demo;

import java.util.Date;

/**
 * @Author ：linhaomiao
 * @Date ：2019-04-12
 * @Desc ：
 */
public class User {

    /**
     * v_phone : 15812345678
     * v_sex :
     * wife : {"age":"18"}
     * v_birthday : 1900-01-01
     * v_email : abc@163.com
     * v_name : 张xxx
     */
    private String v_phone;
    private String v_sex;
    private String wife;
    private Date v_birthday;
    private String v_email;
    private String v_name;

    public void setV_phone(String v_phone) {
        this.v_phone = v_phone;
    }

    public void setV_sex(String v_sex) {
        this.v_sex = v_sex;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public void setV_birthday(Date v_birthday) {
        this.v_birthday = v_birthday;
    }

    public void setV_email(String v_email) {
        this.v_email = v_email;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getV_phone() {
        return v_phone;
    }

    public String getV_sex() {
        return v_sex;
    }

    public String getWife() {
        return wife;
    }

    public Date getV_birthday() {
        return v_birthday;
    }

    public String getV_email() {
        return v_email;
    }

    public String getV_name() {
        return v_name;
    }
}
