package Model;

import javax.swing.*;

public class Rario extends Character{
    public Rario(){
        setCharacterName("Rario");
        setPhaseOneTexture(new ImageIcon("RarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("RarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("RarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(4);
        setJumpRange(100);
        setSpeed((int)((double)getDefaultSpeed() * 1));
        setReloadDelay(0.5);  //based on seconds
    }

    public Rario(int currentPhase, int coinCollectRange, int jumpRange, int speed, double reloadDelay){
        setCharacterName("Rario");
        setPhaseOneTexture(new ImageIcon("RarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("RarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("RarioPhaseThree.png"));
        setCurrentPhase(currentPhase);
        setCoinCollectRange(coinCollectRange);
        setJumpRange(jumpRange);
        setSpeed(speed);
        setReloadDelay(reloadDelay);
    }
}
