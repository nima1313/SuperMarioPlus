package Model.Characters;

import Model.Characters.Hero;

import javax.swing.*;

public class Rario extends Hero {
    public Rario(){
        super();
        setCharacterName("Rario");
        setCurrentPhase(0);
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
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/RarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/RarioPhaseTwoRightSeated.png");
                else return new ImageIcon("Textures/Characters/RarioPhaseThreeRightSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/RarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/RarioPhaseTwoRight.png");
                else return new ImageIcon("Textures/Characters/RarioPhaseThreeRight.png");
            }
        }
        else {
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/RarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/RarioPhaseTwoLeftSeated.png");
                else return new ImageIcon("Textures/Characters/RarioPhaseThreeLeftSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/RarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/RarioPhaseTwoLeft.png");
                else return new ImageIcon("Textures/Characters/RarioPhaseThreeLeft.png");
            }
        }

    }
}
