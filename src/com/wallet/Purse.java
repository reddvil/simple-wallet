package com.wallet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Purse {
    private int capacity;
    List<Coin> coins=new ArrayList<Coin>();

    public Purse(int capacity){
        this.capacity = capacity;
    }

    public int count() {
        return (this.coins.size());
    }

    public int getBalance(String currency){
        int current = 0;
        for (int i = 0; i < coins.size(); i++) {
            if(coins.get(i).getCurrency() == currency){
                current += coins.get(i).getValue();
            }
        }
        return current;
    }

    public boolean isFull(){
        return this.capacity == this.coins.size();
    }

    public int getCapacity() {
        return capacity;
    }


    public boolean insert(Coin coin){
        boolean isFull = isFull();
        if (coin.getValue() > 0 && !isFull){
            this.coins.add(coin);
            Collections.sort(coins);
            System.out.println("true");
            return true;
        }
        return false;
    }


    public Coin[] widthraw(double amount, String currency){
        int listSize = coins.size();
        for (int i = 0; i < listSize; i++) {
            if (amount == coins.get(i).getValue() && currency == coins.get(i).getCurrency()) {
                coins.remove(i);
                System.out.println(coins.get(i));
            }
        }
//       tu ver ipova shesabisi kupiura shevarchiot kombinaciebi 2 pointer algoritmit
        int pointerOne = 0;
        int pointerTwo = listSize - 1;

        while (pointerOne < pointerTwo) {
            int sum = (int) (coins.get(pointerOne).getValue() +  coins.get(pointerTwo).getValue());
            if (sum == amount) {
                coins.remove(pointerTwo);
                coins.remove(pointerOne);
//              gadaviyvane listi rom davabruno coin ebis Array(pirobis tanaxmad)
                Coin[] itemsArray = new Coin[listSize];
                itemsArray = coins.toArray(itemsArray);
                return itemsArray;

            } else if (sum < amount) {
                pointerOne++;
            } else {
                pointerTwo--;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Purse{" +
                "capacity=" + capacity +
                ", coins=" + coins +
                '}';
    }

}
