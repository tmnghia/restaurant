package com.example.models;

public class Drink extends Product {

    public enum Type {
        SOFT_WATER, ALCOHOL;

        @Override
        public String toString() {
            switch (this.ordinal()) {
            case 0:
                return "Soft water";
            case 1:
                return "Alcohol";
            default:
                return "";
            }
        }
    }

    private Type type;

    public Drink(String name, String description, double price, Type type) {
        super(name, description, price);
        setType(type);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 18;
        int result = super.hashCode();
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Drink other = (Drink) obj;
        if (type != other.type)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
        "Type: " + type + "\n";
    }
}
