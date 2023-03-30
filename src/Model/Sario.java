package Model;

import javax.swing.*;

public class Sario extends Character{
    public Sario(){
        setCharacterName("Sario");
        setPhaseOneTexture(new ImageIcon("SarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("SarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("SarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(4);
        setJumpRange(100);
        setSpeed((int)((double)getDefaultSpeed() * 2));
        setReloadDelay(1);  //based on seconds
    }

    public Sario(int currentPhase, int coinCollectRange, int jumpRange, int speed, double reloadDelay){
        setCharacterName("Sario");
        setPhaseOneTexture(new ImageIcon("SarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("SarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("SarioPhaseThree.png"));
        setCurrentPhase(currentPhase);
        setCoinCollectRange(coinCollectRange);
        setJumpRange(jumpRange);
        setSpeed(speed);
        setReloadDelay(reloadDelay);
    }
}
