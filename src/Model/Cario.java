package Model;

import javax.swing.*;

public class Cario extends Hero{
    public Cario(){
        super();
        setCharacterName("Cario");
        setPhaseOneTexture(new ImageIcon("CarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("CarioPhaseTwo.png"));
        setPhaseThreeTexture(new ImageIcon("CarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectCoefficient(2);
        setCharacterJumpSpeed(getJumpConstant());
        setCharacterSpeed((int)((double)getSpeedConstant() * 1));
        setUnlocked(false);
        setReloadDelay(1);  //based on seconds
    }

    public Cario(int coinCollectCoefficient, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        super();
        setUnlocked(unlocked);
        setCharacterName("Cario");
        setPhaseOneTexture(new ImageIcon("CarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("CarioPhaseTwo.png"));
        setPhaseThreeTexture(new ImageIcon("CarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectCoefficient(coinCollectCoefficient);
        setCharacterJumpSpeed(jumpRange);
        setCharacterSpeed(speed);
        setReloadDelay(reloadDelay);
    }
}
