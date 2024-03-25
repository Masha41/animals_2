package data;

public enum ColorData {
    WHITE("Белый");


    private String name;

    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;

    }

    public String next() {
        return null;
    }
}

