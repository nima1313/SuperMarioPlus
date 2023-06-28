package Model.Block;

import javax.swing.*;
import java.util.Random;

public class MultiCoinBlock extends Block{
    private int coins;
    String myItem;
    public MultiCoinBlock(int upperLeftX, int upperLeftY,String item) {
        super(upperLeftX, upperLeftY);
        Random random = new Random();
        coins = 1 + random.nextInt(5);
        setType("MultiCoinBlock");
    }

    public void gotHit(){
        if (coins != 0){
            coins--;
            if (coins == 0){
                myItem = "";
            }
        }
    }

    public int getCoins() {
        return coins;
    }

    public String getItem() {
        return myItem;
    }

    @Override
    public ImageIcon getTexture(){
        if (coins != 0) return new ImageIcon("Textures/Blocks/MultiCoinBlock.png");
        else return new ImageIcon("Textures/Blocks/EmptyBlock.png");
    }
}
