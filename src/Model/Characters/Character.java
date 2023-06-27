package Model.Characters;

import javax.swing.*;

public class Character {

    boolean unlocked;

    private int gravity;
    protected final int speedConstant = 4; //edit this when you want to know how much speed is enough
    //this is the speed only for the x access;
    protected final int jumpConstant = 16;
    private int characterSpeed;
    private int characterJumpSpeed;

    private boolean isSeating = false;
    private String direction = "Right";
    private int phaseOneHeight = 40;
    private int phaseTwoHeight = 80;
    private int phaseThreeHeight = 80;
    private int phaseOneLength = 40;
    private int phaseTwoLength = 40;
    private int phaseThreeLength = 40;
    private int length;
    private int height;
    private int currentPhase = 0;
    private int upperLeftX=500,upperLeftY=0;
    private int currentSpeed_x = 0;
    private int currentSpeed_y = 0;
    private int coinCollectCoefficient;
    private double reloadDelay;
    private String characterName;


    public int getLength() {
        if (getCurrentPhase() == 0) return getPhaseOneLength();
        else if (getCurrentPhase() == 1) return getPhaseTwoLength();
        else return getPhaseThreeLength();
    }

    public int getHeight() {
        if (getCurrentPhase() == 0) return getPhaseOneHeight();
        else if (getCurrentPhase() == 1) return getPhaseTwoHeight();
        else return getPhaseThreeHeight();
    }

    public ImageIcon getTexture() {
        return null;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }


    protected int getSpeedConstant() {
        return speedConstant;
    }


    public int getPhaseOneHeight() {
        return phaseOneHeight;
    }

    public void setPhaseOneHeight(int phaseOneHeight) {
        this.phaseOneHeight = phaseOneHeight;
    }

    public int getPhaseTwoHeight() {
        return phaseTwoHeight;
    }

    public void setPhaseTwoHeight(int phaseTwoHeight) {
        this.phaseTwoHeight = phaseTwoHeight;
    }

    public int getPhaseThreeHeight() {
        return phaseThreeHeight;
    }

    public void setPhaseThreeHeight(int phaseThreeHeight) {
        this.phaseThreeHeight = phaseThreeHeight;
    }

    public int getPhaseOneLength() {
        return phaseOneLength;
    }

    public void setPhaseOneLength(int phaseOneLength) {
        this.phaseOneLength = phaseOneLength;
    }

    public int getPhaseTwoLength() {
        return phaseTwoLength;
    }

    public void setPhaseTwoLength(int phaseTwoLength) {
        this.phaseTwoLength = phaseTwoLength;
    }

    public int getPhaseThreeLength() {
        return phaseThreeLength;
    }

    public void setPhaseThreeLength(int phaseThreeLength) {
        this.phaseThreeLength = phaseThreeLength;
    }

    public int getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(int currentPhase) {
        this.currentPhase = currentPhase;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getUpperLeftX() {
        return upperLeftX;
    }

    public void setUpperLeftX(int upperLeftX) {
        this.upperLeftX = upperLeftX;
    }

    public int getUpperLeftY() {
        return upperLeftY;
    }

    public void setUpperLeftY(int upperLeftY) {
        this.upperLeftY = upperLeftY;
    }

    public int getJumpConstant() {
        return jumpConstant;
    }

    public int getCharacterSpeed() {
        return characterSpeed;
    }

    public void setCharacterSpeed(int characterSpeed) {
        this.characterSpeed = characterSpeed;
    }

    public int getCharacterJumpSpeed() {
        return characterJumpSpeed;
    }

    public void setCharacterJumpSpeed(int characterJumpSpeed) {
        this.characterJumpSpeed = characterJumpSpeed;
    }

    public int getCurrentSpeed_x() {
        return currentSpeed_x;
    }

    public void setCurrentSpeed_x(int currentSpeed_x) {
        this.currentSpeed_x = currentSpeed_x;
    }

    public int getCurrentSpeed_y() {
        return currentSpeed_y;
    }

    public void setCurrentSpeed_y(int currentSpeed_y) {
        this.currentSpeed_y = currentSpeed_y;
    }

    public int getCoinCollectCoefficient() {
        return coinCollectCoefficient;
    }

    public void setCoinCollectCoefficient(int coinCollectCoefficient) {
        this.coinCollectCoefficient = coinCollectCoefficient;
    }

    public double getReloadDelay() {
        return reloadDelay;
    }

    public void setReloadDelay(double reloadDelay) {
        this.reloadDelay = reloadDelay;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public boolean isSeating() {
        return isSeating;
    }

    public void setSeating(boolean seating) {
        isSeating = seating;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
