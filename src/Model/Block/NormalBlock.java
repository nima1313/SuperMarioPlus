package Model.Block;

import Model.Block.Block;

import javax.swing.*;

public class NormalBlock extends Block {
    public NormalBlock(int upperLeftX, int upperLeftY){
        super(upperLeftX,upperLeftY);
        setTexture(new ImageIcon("Textures/Blocks/NormalBlock.png"));
        setType("NormalBlock");
    }
    public void gotHit(){
        this.disappear();
        //TODO:add one point
    }
}