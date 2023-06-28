package Model.Block;

import Model.Block.Block;
import Model.Items.Coin;
import Model.Levels.Level;

import javax.swing.*;
import java.util.ArrayList;

public class CoinBlock extends Block {
    String item;
    public CoinBlock(int upperLeftX, int upperLeftY,String item){
        super(upperLeftX,upperLeftY);
        this.item = item;
        setType("CoinBlock");
    }

    public void gotHit(Level level){
        if (item.equals("Coin")){
            //it still has a coin
            Coin coin = new Coin(getUpperLeftX() + 4,getUpperLeftY()-32);
            ArrayList<Coin> newCoins = level.getCoins();
            newCoins.add(coin);
            level.setCoins(newCoins);
            item = "";
        }
        else {
            this.disappear();
        }
    }

    public boolean isCollected() {
        if (item.equals(""))return true;
        else return false;
    }

    @Override
    public ImageIcon getTexture(){
        if (!isCollected()) return new ImageIcon("Textures/Blocks/CoinBlock.png");
        else return new ImageIcon("Textures/Blocks/NormalBlock.png");
    }
}
