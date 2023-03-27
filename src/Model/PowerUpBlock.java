package Model;

import javax.swing.*;

public class PowerUpBlock extends Block{
    PowerUpBlock(int upperLeftX, int upperLeftY){
        super(upperLeftX,upperLeftY);
        setTexture(new ImageIcon("PowerUpBlock.png"));
    }
}
