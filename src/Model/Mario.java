package Model;

import javax.swing.*;

public class Mario extends Hero{
    public Mario(){
        super();
        setCharacterName("Mario");
        setPhaseOneTexture(new ImageIcon("MarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("MarioPhaseTwo.png"));
        setPhaseThreeTexture(new ImageIcon("MarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(5);
        setCharacterJumpSpeed(getJumpConstant());
        setCharacterSpeed((int)((double)getSpeedConstant() * 1.25));
        setUnlocked(true);
        setReloadDelay(0.8);  //based on seconds
    }

    public Mario(int coinCollectRange, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        super();
        setCharacterName("Mario");
        setUnlocked(unlocked);
        setPhaseOneTexture(new ImageIcon("MarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("MarioPhaseTwo.png"));
        setPhaseThreeTexture(new ImageIcon("MarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(coinCollectRange);
        setCharacterJumpSpeed(jumpRange);
        setCharacterSpeed(speed);
        setReloadDelay(reloadDelay);
    }
}
