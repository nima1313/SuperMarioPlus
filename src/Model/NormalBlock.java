package Model;

import javax.swing.*;

public class NormalBlock extends Block{
    NormalBlock(int upperLeftX, int upperLeftY){
        super(upperLeftX,upperLeftY);
        setTexture(new ImageIcon("NormalBlock.png"));
    }
}