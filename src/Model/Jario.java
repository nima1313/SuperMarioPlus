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
        setReloadDelay(1);  //based on seconds
    }

    public Jario(int currentPhase, int coinCollectRange, int jumpRange, int speed, double reloadDelay){
        setCharacterName("Jario");
        setPhaseOneTexture(new ImageIcon("JarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("JarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("JarioPhaseThree.png"));
        setCurrentPhase(currentPhase);
        setCoinCollectRange(coinCollectRange);
        setJumpRange(jumpRange);
        setSpeed(speed);
        setReloadDelay(reloadDelay);
    }

}
