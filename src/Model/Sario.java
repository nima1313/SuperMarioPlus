package Model;

import javax.swing.*;

public class Sario extends Hero{
    public Sario(){
        super();
        setCharacterName("Sario");
        setPhaseOneTexture(new ImageIcon("SarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("SarioPhaseTwo.png"));
        setPhaseThreeTexture(new ImageIcon("SarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(4);
        setCharacterJumpSpeed(getJumpConstant());
        setCharacterSpeed((int)((double)getSpeedConstant() * 2));
        setUnlocked(false);
        setReloadDelay(1);  //based on seconds
    }

    public Sario(int coinCollectRange, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        super();
        setUnlocked(unlocked);
        setCharacterName("Sario");
        setPhaseOneTexture(new ImageIcon("SarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("SarioPhaseTwo.png"));
        setPhaseThreeTexture(new ImageIcon("SarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(coinCollectRange);
        setCharacterJumpSpeed(jumpRange);
        setCharacterSpeed(speed);
        setReloadDelay(reloadDelay);
    }
}
