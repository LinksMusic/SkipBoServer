package com.example.skipboserver.datatypes.enums;

public enum Value {
    JOKER(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12);

    private final int value;
    Value(final int newValue){
        value = newValue;
    }
    public int getValue() { return value; }
}
