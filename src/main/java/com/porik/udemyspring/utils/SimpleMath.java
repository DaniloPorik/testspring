package com.porik.udemyspring.utils;

public class SimpleMath {

    public Double sum(Double fNumber, Double sNumber) {
        return fNumber + sNumber;
    }

    public Double sub(Double fNumber, Double sNumber) {
        return fNumber - sNumber;
    }

    public Double multi(Double fNumber, Double sNumber) {
        return fNumber * sNumber;
    }

    public Double div(Double fNumber, Double sNumber) {
        return fNumber / sNumber;
    }

    public Double mean(Double fNumber, Double sNumber) {
        return (fNumber + sNumber) / 2;
    }

    public Double sqrt(Double fNumber) {
        return (Double) Math.sqrt(fNumber);
    }

}
