package com.example.skipboserver.datatypes;

import com.example.skipboserver.datatypes.enums.Color;
import com.example.skipboserver.datatypes.enums.Value;

public class Card {
    private Value value;
    private Color color;
    public Card(Value value,Color color){
        this.value = value;
        this.color = color;
    }


    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
