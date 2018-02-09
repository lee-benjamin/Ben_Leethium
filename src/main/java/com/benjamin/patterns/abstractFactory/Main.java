package com.benjamin.patterns.abstractFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new GuitarFactory();
        Instrument instrument = factory.createInstrument();
        instrument.play();

        factory = new TriangleFactory();
        instrument = factory.createInstrument();
        instrument.play();
    }
}
