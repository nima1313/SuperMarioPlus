package Model;

import javax.swing.*;

public class Jario extends Character{
    public Jario(){
        setCharacterName("Jario");
        setPhaseOneTexture(new ImageIcon("JarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("JarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("JarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(4);
        setJumpRange(200);
        setSpeed((int)((double)getDefaultSpeed() * 1));
        setUnlocked(false);
        setReloadDelay(1);  //based on seconds
    }

    public Jario(int coinCollectRange, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        setUnlocked(unlocked);
        setCharacterName("Jario");
        setPhaseOneTexture(new ImageIcon("JarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("JarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("JarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(coinCollectRange);
        setJumpRange(jumpRange);
        setSpeed(speed);
        setReloadDelay(reloadDelay);
    }

}
