package com.zzh.pifashop.domain;

public class Items {
    //酒水饮料的属性
    private int id;
    private String name;
    private double price;

    //空构造方法
    public Items(){}

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Items{"+
                "id="+id+
                "name='"+ name+"\'"+
                "price="+price+
                "}";
    }
}
