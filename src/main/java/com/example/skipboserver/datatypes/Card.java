package com.example.skipboserver.datatypes;

public class Card {
    private Value value;
    private Color color;
    private boolean visible;
    public Card(Value value,Color color,boolean visible){
        this.value = value;
        this.color = color;
        this.visible = visible;
    }


    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
