package com.benjamin.patterns.builder;

public class Keyboard {
    private String make;
    private String model;
    private String layout;
    private String switchType;

    // optional paramters
    private boolean isCompatibleAT;
    private boolean isCompatiblePS2;

    private Keyboard(KeyboardBuilder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.layout = builder.layout;
        this.switchType = builder.switchType;
        this.isCompatibleAT = builder.isCompatibleAT;
        this.isCompatiblePS2 = builder.isCompatiblePS2;
    }

    @Override
    public String toString() {
        return "Keyboard {\n"
            + "\tmake: " + make + "\n"
            + "\tmodel: " + model + "\n"
            + "\tlayout: " + layout + "\n"
            + "\tswitchType: " + switchType + "\n"
            + "\tisCompatibleAT: " + isCompatibleAT + "\n"
            + "\tisCompatiblePS2: " + isCompatiblePS2 + "\n"
            + "}";
    }

    public static class KeyboardBuilder {
        private String make;
        private String model;
        private String layout;
        private String switchType;

        // optional paramters
        private boolean isCompatibleAT;
        private boolean isCompatiblePS2;

        public KeyboardBuilder(String make, String model, String layout, String switchType) {
            this.make = make;
            this.model = model;
            this.layout = layout;
            this.switchType = switchType;
        }

        public KeyboardBuilder isCompatibleAT(boolean isCompatibleAT) {
            this.isCompatibleAT = isCompatibleAT;
            return this;
        }

        public KeyboardBuilder isCompatiblePS2(boolean isCompatiblePS2) {
            this.isCompatiblePS2 = isCompatiblePS2;
            return this;
        }

        public Keyboard build() {
            return new Keyboard(this);
        }
    }
}
