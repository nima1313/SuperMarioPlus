package Model.Characters;

import Model.Characters.Hero;

import javax.swing.*;

public class Sario extends Hero {
    public Sario(){
        super();
        setCharacterName("Sario");
        setCurrentPhase(1);
        setCoinCollectCoefficient(1);
        setCharacterJumpSpeed(getJumpConstant());
        setCharacterSpeed((int)((double)getSpeedConstant() * 2));
        setUnlocked(false);
        setReloadDelay(1);  //based on seconds
    }

    public Sario(int coinCollectCoefficient, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        super();
        setUnlocked(unlocked);
        setCharacterName("Sario");
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
                if (getCurrentPhase() == 0) return new ImageIcon("SarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("SarioPhaseTwoRightSeated.png");
                else return new ImageIcon("SarioPhaseThreeRightSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("SarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("SarioPhaseTwoRight.png");
                else return new ImageIcon("SarioPhaseThreeRight.png");
            }
        }
        else {
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("SarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("SarioPhaseTwoLeftSeated.png");
                else return new ImageIcon("SarioPhaseThreeLeftSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("SarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("SarioPhaseTwoLeft.png");
                else return new ImageIcon("SarioPhaseThreeLeft.png");
            }
        }

    }
}
