package com.benjamin.patterns.abstractFactory;

public interface Factory {
    Instrument createInstrument();
}

class GuitarFactory implements Factory {
    public Guitar createInstrument() {
        return new Guitar();
    }
}

class TriangleFactory implements Factory {
    public Triangle createInstrument() {
        return new Triangle();
    }
}
