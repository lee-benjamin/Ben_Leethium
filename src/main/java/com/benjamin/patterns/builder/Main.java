package com.benjamin.patterns.builder;

public class Main {
    public static void main(String[] args) {
        Keyboard keeb = new Keyboard.KeyboardBuilder("Apple", "Extended Keyboard II", "ANSI" , "Alps Salmon")
                                .isCompatibleAT(false)
                                .isCompatiblePS2(false)
                                .build();
        System.out.println(keeb);
    }
}
