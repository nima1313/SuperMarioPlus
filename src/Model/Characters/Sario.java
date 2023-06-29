package Model.Characters;

import Model.Characters.Hero;

import javax.swing.*;

public class Sario extends Hero {
    public Sario(){
        super();
        setCharacterName("Sario");
        setCurrentPhase(0);
        setCoinCollectCoefficient(1);
        setCharacterJumpSpeed(getJumpConstant());
        setCharacterSpeed((int)((double)getSpeedConstant() * 2));
        setUnlocked(false);
        setReloadDelay(3);  //based on seconds
    }

    public Sario(int coinCollectCoefficient, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        super();
        setUnlocked(unlocked);
        setCharacterName("Sario");
        setCurrentPhase(0);
        setCoinCollectCoefficient(coinCollectCoefficient);
        setCharacterJumpSpeed(jumpRange);
        setCharacterSpeed(speed);
        setReloadDelay(reloadDelay);
    }
    @Override
    public ImageIcon getTexture(){
        if (getDirection().equals("Right")){
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/SarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/SarioPhaseTwoRightSeated.png");
                else return new ImageIcon("Textures/Characters/SarioPhaseThreeRightSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/SarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/SarioPhaseTwoRight.png");
                else return new ImageIcon("Textures/Characters/SarioPhaseThreeRight.png");
            }
        }
        else {
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/SarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/SarioPhaseTwoLeftSeated.png");
                else return new ImageIcon("Textures/Characters/SarioPhaseThreeLeftSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/SarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/SarioPhaseTwoLeft.png");
                else return new ImageIcon("Textures/Characters/SarioPhaseThreeLeft.png");
            }
        }

    }
}
