package Model.Characters;

import Model.Characters.Hero;

import javax.swing.*;

public class Mario extends Hero {
    public Mario(){
        super();
        setCharacterName("Mario");
        setCurrentPhase(1);
        setCoinCollectCoefficient(1);
        setCharacterJumpSpeed(getJumpConstant());
        setCharacterSpeed((int)((double)getSpeedConstant() * 1.25));
        setUnlocked(true);
        setReloadDelay(0.8);  //based on seconds
    }

    public Mario(int coinCollectCoefficient, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        super();
        setCharacterName("Mario");
        setUnlocked(unlocked);
        setCurrentPhase(1);
        setCoinCollectCoefficient(coinCollectCoefficient);
        setCharacterJumpSpeed(jumpRange);
        setCharacterSpeed(speed);
        setReloadDelay(reloadDelay);
    }
    @Override
    public ImageIcon getTexture(){
        if (getDirection().equals("Right")){
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("MarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("MarioPhaseTwoRightSeated.png");
                else return new ImageIcon("MarioPhaseThreeRightSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("MarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("MarioPhaseTwoRight.png");
                else return new ImageIcon("MarioPhaseThreeRight.png");
            }
        }
        else {
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("MarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("MarioPhaseTwoLeftSeated.png");
                else return new ImageIcon("MarioPhaseThreeLeftSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("MarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("MarioPhaseTwoLeft.png");
                else return new ImageIcon("MarioPhaseThreeLeft.png");
            }
        }

    }
}
