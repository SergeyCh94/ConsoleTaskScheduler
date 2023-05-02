package enums;

public enum Type implements java.lang.reflect.Type {
    WORK("Рабочая"),
    PERSONAL("Личная");

    String type;

    Type (String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getTypeName() {
        return java.lang.reflect.Type.super.getTypeName();
    }
}






