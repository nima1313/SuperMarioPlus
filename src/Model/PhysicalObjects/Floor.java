package Model.PhysicalObjects;

import java.awt.*;

public class Floor extends PhysicalObject {


    public Floor(int upperLeftX, int upperLeftY, int length, int height) {
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setLength(length);
        setHeight(height);
    }

    @Override
    public Color getColor() {
        return new Color(144, 222, 167);
    }
}