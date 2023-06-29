package Model.Characters;

import Model.Characters.Hero;

import javax.swing.*;

public class Mario extends Hero {
    public Mario(){
        super();
        setCharacterName("Mario");
        setCurrentPhase(0);
        setCoinCollectCoefficient(1);
        setCharacterJumpSpeed(getJumpConstant());
        setCharacterSpeed((int)((double)getSpeedConstant() * 1.25));
        setUnlocked(true);
        setReloadDelay(3);  //based on seconds
    }

    public Mario(int coinCollectCoefficient, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        super();
        setCharacterName("Mario");
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
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/MarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/MarioPhaseTwoRightSeated.png");
                else return new ImageIcon("Textures/Characters/MarioPhaseThreeRightSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/MarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/MarioPhaseTwoRight.png");
                else return new ImageIcon("Textures/Characters/MarioPhaseThreeRight.png");
            }
        }
        else {
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/MarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/MarioPhaseTwoLeftSeated.png");
                else return new ImageIcon("Textures/Characters/MarioPhaseThreeLeftSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/MarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/MarioPhaseTwoLeft.png");
                else return new ImageIcon("Textures/Characters/MarioPhaseThreeLeft.png");
            }
        }

    }
}
