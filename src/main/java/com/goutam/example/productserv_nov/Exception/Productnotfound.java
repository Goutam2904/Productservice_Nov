package com.goutam.example.productserv_nov.Exception;

public class Productnotfound extends Exception{
    private String msg;
    public Productnotfound(String msg){
        this.msg = msg;
    }
}
