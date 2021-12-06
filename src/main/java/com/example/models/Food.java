package com.example.models;

public class Food extends Product {

    public enum Type {
        BREAKFAST, LUNCH, DINNER;

        @Override
        public String toString() {
            switch (this.ordinal()) {
            case 0:
                return "Breakfast";
            case 1:
                return "Lunch";
            case 2:
                return "Dinner";
            default:
                return "";
            }
        }
    }

    private Type type;

    public Food(String name, String description, double price, Type type) {
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
    public String toString() {
        return super.toString() + "\n" +
        "Type: " + type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result;
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
        Food other = (Food) obj;
        if (this.hashCode() != other.hashCode())
            return false;
        return true;
    }
}
