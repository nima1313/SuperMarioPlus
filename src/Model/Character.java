package Model;

import javax.swing.*;

public class Character {

    private int defaultSpeed = 40; //edit this when you want to know how much speed is enough //TODO
    private ImageIcon phaseOneTexture;
    private ImageIcon phaseTwoTexture;
    private ImageIcon phaseThreeTexture;
    private int phaseOneHeight = 40;
    private int phaseTwoHeight = 80;
    private int phaseThreeHeight = 80;
    private int phaseOneLength = 40;
    private int phaseTwoLength = 40;
    private int phaseThreeLength = 40;
    private int currentPhase;
    private int upperLeftX,upperLeftY;
    private int jumpRange;
    private int speed;
    private int coinCollectRange;
    private double reloadDelay;
    private String characterName;

    public int getDefaultSpeed() {
        return defaultSpeed;
    }

    public ImageIcon getPhaseOneTexture() {
        return phaseOneTexture;
    }

    public void setPhaseOneTexture(ImageIcon phaseOneTexture) {
        this.phaseOneTexture = phaseOneTexture;
    }

    public ImageIcon getPhaseTwoTexture() {
        return phaseTwoTexture;
    }

    public void setPhaseTwoTexture(ImageIcon phaseTwoTexture) {
        this.phaseTwoTexture = phaseTwoTexture;
    }

    public ImageIcon getPhaseThreeTexture() {
        return phaseThreeTexture;
    }

    public void setPhaseThreeTexture(ImageIcon phaseThreeTexture) {
        this.phaseThreeTexture = phaseThreeTexture;
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

    public int getJumpRange() {
        return jumpRange;
    }

    public void setJumpRange(int jumpRange) {
        this.jumpRange = jumpRange;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCoinCollectRange() {
        return coinCollectRange;
    }

    public void setCoinCollectRange(int coinCollectRange) {
        this.coinCollectRange = coinCollectRange;
    }

    public double getReloadDelay() {
        return reloadDelay;
    }

    public void setReloadDelay(double reloadDelay) {
        this.reloadDelay = reloadDelay;
    }
}
