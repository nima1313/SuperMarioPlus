package Model.Block;

import javax.swing.*;
import java.util.Random;

public class MultiCoinBlock extends Block{
    private Random random = new Random();
    private int coins = 1 + random.nextInt(5);
    public MultiCoinBlock(int upperLeftX, int upperLeftY) {
        super(upperLeftX, upperLeftY);
        setType("MultiCoinBlock");
    }

    public void gotHit(){
        if (coins != 0){
            coins--;
            //TODO : make the character score go up by one coin and one score
        }
    }

    public int getCoins() {
        return coins;
    }
    @Override
    public ImageIcon getTexture(){
        if (coins != 0) return new ImageIcon("Textures/Blocks/MultiCoinBlock.png");
        else return new ImageIcon("Textures/Blocks/EmptyBlock.png");
    }
}
