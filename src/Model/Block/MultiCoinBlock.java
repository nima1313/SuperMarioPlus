package Model.Block;

import javax.swing.*;
import java.util.Random;

public class MultiCoinBlock extends Block{
    private Random random = new Random();
    private int coins = 1 + random.nextInt(5);
    public MultiCoinBlock(int upperLeftX, int upperLeftY) {
        super(upperLeftX, upperLeftY);
        setTexture(new ImageIcon("Textures/Blocks/MultiCoinBlock.png"));
        setType("MultiCoinBlock");
    }

    public void gotHit(){
        if (coins != 0){
            coins--;
            //TODO : make the character score go up by one coin and one score
            if (coins == 0){
                setTexture(new ImageIcon("Textures/Blocks/EmptyBlock.png"));
            }
        }
    }
}
