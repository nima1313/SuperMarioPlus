package Model.Block;

import Model.Items.Coin;
import Model.Items.MagicalFlower;
import Model.Items.MagicalMushroom;
import Model.Items.MagicalStar;
import Model.Levels.Level;

import javax.swing.*;
import java.util.ArrayList;

public class GiftBlock extends Block{

    private String itemName;

    public GiftBlock(int upperLeftX, int upperLeftY, String item) {
        super(upperLeftX, upperLeftY);
        setItemName(item);
    }

    public String getItemName() {
        return itemName;
    }

    public void gotHit(Level level){
        if (!getItemName().equals("")){
            //it still has a coin
            if (getItemName().equals("Coin")) {
                Coin coin = new Coin(getUpperLeftX() + 4, getUpperLeftY() - 32);
                ArrayList<Coin> newCoins = level.getCoins();
                newCoins.add(coin);
                newCoins.add(coin);
                level.setCoins(newCoins);
            } else if (getItemName().equals("MagicalFlower")) {
                MagicalFlower magicalFlower = new MagicalFlower(getUpperLeftX() + 4, getUpperLeftY() - 32);
                ArrayList<MagicalFlower> newMagicalFlower = level.getMagicalFlowers();
                newMagicalFlower.add(magicalFlower);
                level.setMagicalFlowers(newMagicalFlower);
            }
            else if (getItemName().equals("MagicalStar")) {
                MagicalStar magicalStar = new MagicalStar(getUpperLeftX() + 4, getUpperLeftY() - 32);
                ArrayList<MagicalStar> newMagicalStar = level.getMagicalStars();
                newMagicalStar.add(magicalStar);
                level.setMagicalStars(newMagicalStar);
            }
            else {
                MagicalMushroom magicalMushroom = new MagicalMushroom(getUpperLeftX() + 4, getUpperLeftY() - 32);
                ArrayList<MagicalMushroom> newMagicalMushroom = level.getMagicalMushrooms();
                newMagicalMushroom.add(magicalMushroom);
                level.setMagicalMushrooms(newMagicalMushroom);
            }
            setItemName("");
        }

    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public ImageIcon getTexture(){
        if (getItemName().equals("")) return new ImageIcon("Textures/Blocks/EmptyBlock.png");
        else return new ImageIcon("Textures/Blocks/GiftBlock.png");
    }
}
