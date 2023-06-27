package Model.Block;

import javax.swing.*;

public class EmptyBlock extends Block{
    public EmptyBlock(int upperLeftX, int upperLeftY) {
        super(upperLeftX, upperLeftY);
        setTexture(new ImageIcon("Textures/Blocks/EmptyBlock.png"));
        setType("EmptyBlock");
    }
}
