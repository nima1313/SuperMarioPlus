package Model;

import javax.swing.*;
import java.util.ArrayList;

public class Jario extends Hero{
    public Jario(){
        super();
        setCharacterName("Jario");
        setPhaseOneTexture(new ImageIcon("JarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("JarioPhaseTwo.png"));
        setPhaseThreeTexture(new ImageIcon("JarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectCoefficient(1);
        setCharacterJumpSpeed((int)(getJumpConstant() * 1.25));
        setCharacterSpeed((int)((double)getSpeedConstant() * 1));
        setUnlocked(false);
        setReloadDelay(1);  //based on seconds
    }

    public Jario(int coinCollectCoefficient, int jumpSpeed, int speed, double reloadDelay,boolean unlocked){
        super();
        setUnlocked(unlocked);
        setCharacterName("Jario");
        setPhaseOneTexture(new ImageIcon("JarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("JarioPhaseTwo.png"));
        setPhaseThreeTexture(new ImageIcon("JarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectCoefficient(coinCollectCoefficient);
        setCharacterJumpSpeed(jumpSpeed);
        setCharacterSpeed(speed);
        setReloadDelay(reloadDelay);
    }

}
