package enums;

public enum Type{
    WORK("Рабочая"),
    PERSONAL("Личная");

    String type;

    Type (String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}






