package com.benjamin.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class DenimCollection implements Cloneable {
    private List<String> collection;

    public DenimCollection() {
        collection = new ArrayList<String>();
    }

    public DenimCollection(List<String> collection) {
        this.collection = collection;
    }

    public void loadData() {
        // read from db
        collection.add("LVC 66");
        collection.add("TCB 50");
        collection.add("Eternal 811");
        collection.add("Resolute 710");
        collection.add("Denime 66");
        collection.add("Hinoya x Warehouse 1003HXX");
        collection.add("Sugarcane 1947");
        collection.add("Studio D'Artisan 103");
        collection.add("Fullcount 1105");
    }

    public List<String> getCollection() {
        return collection;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<String>();
        for (String s : collection) {
            temp.add(s);
        }
        return new DenimCollection(temp);
    }
}

