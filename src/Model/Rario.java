package Model;

import javax.swing.*;

public class Rario extends Hero{
    public Rario(){
        super();
        setCharacterName("Rario");
        setPhaseOneTexture(new ImageIcon("RarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("RarioPhaseTwo.png"));
        setPhaseThreeTexture(new ImageIcon("RarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(4);
        setCharacterJumpSpeed(getJumpConstant());
        setCharacterSpeed((int)((double)getSpeedConstant() * 1));
        setUnlocked(false);
        setReloadDelay(0.5);  //based on seconds
    }

    public Rario(int coinCollectRange, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        super();
        setCharacterName("Rario");
        setUnlocked(unlocked);
        setPhaseOneTexture(new ImageIcon("RarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("RarioPhaseTwo.png"));
        setPhaseThreeTexture(new ImageIcon("RarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(coinCollectRange);
        setCharacterJumpSpeed(jumpRange);
        setCharacterSpeed(speed);
        setReloadDelay(reloadDelay);
    }
}
