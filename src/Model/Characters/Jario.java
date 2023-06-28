package Model.Characters;

import Model.Characters.Hero;

import javax.swing.*;

public class Jario extends Hero {
    public Jario(){
        super();
        setCharacterName("Jario");
        setCurrentPhase(1);
        setCoinCollectCoefficient(1);
        setCharacterJumpSpeed((int)(getJumpConstant() * 1.25));
        setCharacterSpeed((int)((double)getSpeedConstant() * 1));
        setUnlocked(false);
        setReloadDelay(1);  //based on seconds
    }

    public Jario(int coinCollectCoefficient, int jumpSpeed, int speed, double reloadDelay,boolean unlocked){
        super();
        setUnlocked(unlocked);
        setCharacterName("Jario");
        setCurrentPhase(1);
        setCoinCollectCoefficient(coinCollectCoefficient);
        setCharacterJumpSpeed(jumpSpeed);
        setCharacterSpeed(speed);
        setReloadDelay(reloadDelay);
    }
    @Override
    public ImageIcon getTexture(){
        if (getDirection().equals("Right")){
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/JarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/JarioPhaseTwoRightSeated.png");
                else return new ImageIcon("Textures/Characters/JarioPhaseThreeRightSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/JarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/JarioPhaseTwoRight.png");
                else return new ImageIcon("Textures/Characters/JarioPhaseThreeRight.png");
            }
        }
        else {
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/JarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/JarioPhaseTwoLeftSeated.png");
                else return new ImageIcon("Textures/Characters/JarioPhaseThreeLeftSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/JarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/JarioPhaseTwoLeft.png");
                else return new ImageIcon("Textures/Characters/JarioPhaseThreeLeft.png");
            }
        }

    }
}
