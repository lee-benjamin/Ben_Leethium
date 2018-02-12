package com.benjamin.patterns.prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        DenimCollection collection = new DenimCollection();
        collection.loadData();

        DenimCollection clone = (DenimCollection) collection.clone();
        clone.getCollection().add("Plebeian mall jeans");

        System.out.println(collection.getCollection());
        System.out.println(clone.getCollection());
    }
}
