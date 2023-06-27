package Model.Block;

import Model.Block.Block;
import Model.Items.Coin;
import Model.Levels.Level;

import javax.swing.*;
import java.util.ArrayList;

public class CoinBlock extends Block {
    boolean collected = false;
    public CoinBlock(int upperLeftX, int upperLeftY){
        super(upperLeftX,upperLeftY);
        setType("CoinBlock");
    }

    public void gotHit(Level level){
        if (collected == false){
            //it still has a coin
            Coin coin = new Coin(getUpperLeftX() + 4,getUpperLeftY()-32);
            ArrayList<Coin> newCoins = level.getCoins();
            newCoins.add(coin);
            level.setCoins(newCoins);
            collected = true;
        }
        else {
            this.disappear();
        }
    }

    public boolean isCollected() {
        return collected;
    }

    @Override
    public ImageIcon getTexture(){
        if (!collected) return new ImageIcon("Textures/Blocks/CoinBlock.png");
        else return new ImageIcon("Textures/Blocks/NormalBlock.png");
    }
    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
