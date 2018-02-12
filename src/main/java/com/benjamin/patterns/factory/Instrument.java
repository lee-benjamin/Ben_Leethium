package com.benjamin.patterns.factory;

public abstract class Instrument {
    public abstract void play();
}

class Guitar extends Instrument {
    @Override
    public void play() {
        System.out.println("The Guitar says: Strumming along happily...");
    }
}

class Triangle extends Instrument {
    @Override
    public void play() {
        System.out.println("The Triangle says: DINGDINGDINGDINGDINGDINGDINGDINGDINGDING");
    }
}

