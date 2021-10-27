package com.wallet;

public class Main {

    public static void main(String[] args) {

        Coin hundred = new Coin(100, "GEL");
        Coin fifty = new Coin(50, "GEL");

        Purse purse = new Purse(20);
        purse.insert(hundred);
        purse.insert(fifty);
        System.out.println(purse.toString());
        System.out.println(purse.getBalance("GEL"));
        purse.widthraw(150,"GEL");
        System.out.println(purse.getBalance("GEL"));

//        System.out.println(fifty.toString());

    }
}
