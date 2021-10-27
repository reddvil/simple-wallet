package com.wallet;

import java.util.Objects;

public class Coin implements Comparable<Coin>{


    private final double value;
    private final String currency;

    public Coin(double value, String currency) {
        this.value = value ;
        this.currency = currency;
    }

    @Override
    public int compareTo(Coin other) {
        final double value = other.getValue();
        return Double.compare(this.value, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return Double.compare(coin.value, value) == 0 && Objects.equals(currency, coin.currency);
    }


    public String getCurrency() {
        return currency;
    }

    public double getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "Coin{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
