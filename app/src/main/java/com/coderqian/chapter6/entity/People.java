package com.coderqian.chapter6.entity;

/**
 * @author qianliqing
 * @since 2018-10-30 下午3:36
 * mail: qianlq0824@gmail.com
 */
public class People {

    public int ID = -1;
    public String Name;
    public int Age;
    public double Height;

    public People() {
    }

    public People(String name, int age, double height) {
        this.Name = name;
        this.Age = age;
        this.Height = height;
    }

    public String toString() {
        String result = "";
        result += "ID: " + this.ID + ",";
        result += "姓名: " + this.Name + ",";
        result += "年龄: " + this.Age + ",";
        result += "身高: " + this.Height + ",";
        return result;
    }
}
