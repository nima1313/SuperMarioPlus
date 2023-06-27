package Model.Characters;

import Model.Characters.Hero;

import javax.swing.*;

public class Rario extends Hero {
    public Rario(){
        super();
        setCharacterName("Rario");
        setCurrentPhase(1);
        setCoinCollectCoefficient(1);
        setCharacterJumpSpeed(getJumpConstant());
        setCharacterSpeed((int)((double)getSpeedConstant() * 1));
        setUnlocked(false);
        setReloadDelay(0.5);  //based on seconds
    }

    public Rario(int coinCollectCoefficient, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        super();
        setCharacterName("Rario");
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
                if (getCurrentPhase() == 0) return new ImageIcon("RarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("RarioPhaseTwoRightSeated.png");
                else return new ImageIcon("RarioPhaseThreeRightSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("RarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("RarioPhaseTwoRight.png");
                else return new ImageIcon("RarioPhaseThreeRight.png");
            }
        }
        else {
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("RarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("RarioPhaseTwoLeftSeated.png");
                else return new ImageIcon("RarioPhaseThreeLeftSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("RarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("RarioPhaseTwoLeft.png");
                else return new ImageIcon("RarioPhaseThreeLeft.png");
            }
        }

    }
}
