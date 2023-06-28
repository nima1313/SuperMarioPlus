package Model.PhysicalObjects;

import java.awt.*;

public class EndWall extends PhysicalObject {

    public EndWall(int upperLeftX, int upperLeftY, int length, int height){
        setUpperLeftX(upperLeftX);
        setUpperLeftY(upperLeftY);
        setLength(length);
        setHeight(height);
    }

    @Override
    public Color getColor() {
        return (Color.RED);
    }

}
