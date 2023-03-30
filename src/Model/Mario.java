package Model;

import javax.swing.*;

public class Mario extends Character{
    public Mario(){
        setCharacterName("Mario");
        setPhaseOneTexture(new ImageIcon("MarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("MarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("MarioPhaseThree.png"));
        setCurrentPhase(1);
        setCoinCollectRange(5);
        setJumpRange(125);
        setSpeed((int)((double)getDefaultSpeed() * 1.25));
        setReloadDelay(0.8);  //based on seconds
    }

    public Mario(int currentPhase, int coinCollectRange, int jumpRange, int speed, double reloadDelay){
        setCharacterName("Mario");
        setPhaseOneTexture(new ImageIcon("MarioPhaseOne.png"));
        setPhaseTwoTexture(new ImageIcon("MarioPhaseTwo.png"));
        setPhaseOneTexture(new ImageIcon("MarioPhaseThree.png"));
        setCurrentPhase(currentPhase);
        setCoinCollectRange(coinCollectRange);
        setJumpRange(jumpRange);
        setSpeed(speed);
        setReloadDelay(reloadDelay);
    }
}
