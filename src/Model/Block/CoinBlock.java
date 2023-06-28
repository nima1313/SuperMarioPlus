package Model.Block;

import Model.Block.Block;
import Model.Items.Coin;
import Model.Levels.Level;

import javax.swing.*;
import java.util.ArrayList;

public class CoinBlock extends Block {
    String myItem;
    public CoinBlock(int upperLeftX, int upperLeftY,String item){
        super(upperLeftX,upperLeftY);
        this.myItem = item;
        setType("CoinBlock");
    }

    public void gotHit(Level level){
        if (myItem.equals("Coin")){
            //it still has a coin
            Coin coin = new Coin(getUpperLeftX() + 4,getUpperLeftY()-32);
            ArrayList<Coin> newCoins = level.getCoins();
            newCoins.add(coin);
            level.setCoins(newCoins);
            myItem = "";
        }
        else {
            this.disappear();
        }
    }

    public boolean isCollected() {
        if (myItem.equals(""))return true;
        else return false;
    }

    @Override
    public ImageIcon getTexture(){
        if (!isCollected()) return new ImageIcon("Textures/Blocks/CoinBlock.png");
        else return new ImageIcon("Textures/Blocks/NormalBlock.png");
    }
}
