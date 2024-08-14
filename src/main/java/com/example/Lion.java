package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    private Feline feline; // Убираем создание экземпляра Feline внутри класса Lion

    // Конструктор принимает экземпляр Feline
    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.feline = this.feline; // Присваиваем переданный экземпляр
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
