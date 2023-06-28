package Model.Characters;

import javax.swing.*;

public class Cario extends Hero {
    public Cario(){
        super();
        setCharacterName("Cario");
        setCurrentPhase(1);
        setCoinCollectCoefficient(2);
        setCharacterJumpSpeed(getJumpConstant());
        setCharacterSpeed((int)((double)getSpeedConstant() * 1));
        setUnlocked(false);
        setReloadDelay(1);  //based on seconds
    }

    public Cario(int coinCollectCoefficient, int jumpRange, int speed, double reloadDelay,boolean unlocked){
        super();
        setUnlocked(unlocked);
        setCharacterName("Cario");
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
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/CarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/CarioPhaseTwoRightSeated.png");
                else return new ImageIcon("Textures/Characters/CarioPhaseThreeRightSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/CarioPhaseOneRight.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/CarioPhaseTwoRight.png");
                else return new ImageIcon("Textures/Characters/CarioPhaseThreeRight.png");
            }
        }
        else {
            if (isSeating()) {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/CarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/CarioPhaseTwoLeftSeated.png");
                else return new ImageIcon("Textures/Characters/CarioPhaseThreeLeftSeated.png");
            }
            else {
                if (getCurrentPhase() == 0) return new ImageIcon("Textures/Characters/CarioPhaseOneLeft.png");
                else if (getCurrentPhase() == 1) return new ImageIcon("Textures/Characters/CarioPhaseTwoLeft.png");
                else return new ImageIcon("Textures/Characters/CarioPhaseThreeLeft.png");
            }
        }

    }
}
