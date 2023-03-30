package Model;

import javax.swing.*;

public class Cario extends Character{
    public Cario(){
        setCharacterName("Cario");
        setPhaseOneTexture(new ImageIcon("CarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("CarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("CarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(8);
        setJumpRange(100);
        setSpeed((int)((double)getDefaultSpeed() * 1));
        setReloadDelay(1);  //based on seconds
    }

    public Cario(int currentPhase, int coinCollectRange, int jumpRange, int speed, double reloadDelay){
        setCharacterName("Cario");
        setPhaseOneTexture(new ImageIcon("CarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("CarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("CarioPhaseThree.png"));
        setCurrentPhase(currentPhase);
        setCoinCollectRange(coinCollectRange);
        setJumpRange(jumpRange);
        setSpeed(speed);
        setReloadDelay(reloadDelay);
    }
}
