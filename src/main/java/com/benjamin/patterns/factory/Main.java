package com.benjamin.patterns.factory;

public class Main {
    public static void main(String[] args) {
        boolean criteria = true;
        Instrument instrument = InstrumentFactory.createInstrument(criteria);
        System.out.println("This instrument isPotentiallyAnnoying: " + criteria);
        instrument.play();

        instrument = InstrumentFactory.createInstrument(!criteria);
        System.out.println("This instrument isPotentiallyAnnoying: " + !criteria);
        instrument.play();
    }
}
