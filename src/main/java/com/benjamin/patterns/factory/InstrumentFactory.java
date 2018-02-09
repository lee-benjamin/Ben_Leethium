package com.benjamin.patterns.factory;

public class InstrumentFactory {

    public static Instrument createInstrument(boolean isPotentiallyAnnoying) {
       if (isPotentiallyAnnoying) {
           return new Triangle();
       }
       return new Guitar();
    }
}

