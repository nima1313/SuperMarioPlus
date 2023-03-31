package Model;

import java.util.ArrayList;

public class Level1 extends Level{
    public Level1(int currentSection) {
        setLevelNumber(1);
        setNumberOfSections(2);
        setCharacterInitialX(300);
        setCharacterInitialY(400);
        setCurrentSection(currentSection);
        ArrayList<Floor>[] floors = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            floors[i] = new ArrayList<Floor>();
        }
        floors[getCurrentSection()].add(new Floor(-200,400,1200,200));
        setFloors(floors);
        ArrayList<NormalBlock>[] normalBlocks = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            normalBlocks[i] = new ArrayList<NormalBlock>();
        }
        normalBlocks[getCurrentSection()].add(new NormalBlock(300,300));
        setNormalBlocks(normalBlocks);
        ArrayList<PowerUpBlock>[] powerUpBlocks = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            powerUpBlocks[i] = new ArrayList<PowerUpBlock>();
        }
        powerUpBlocks[getCurrentSection()].add(new PowerUpBlock(380,300));
        setPowerUpBlocks(powerUpBlocks);
        ArrayList<CoinBlock>[] coinBlocks = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            coinBlocks[i] = new ArrayList<CoinBlock>();
        }
        coinBlocks[getCurrentSection()].add(new CoinBlock(340,300));
        setCoinBlocks(coinBlocks);
        ArrayList<Pipe>[] pipes = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            pipes[i] = new ArrayList<Pipe>();
        }
        pipes[getCurrentSection()].add(new Pipe(500,300));
        setPipes(pipes);

        ArrayList<Flower>[] flowers = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            flowers[i] = new ArrayList<Flower>();
        }
        flowers[getCurrentSection()].add(new Flower(500 + 10, 300 - 60 + 80));
        setFlowers(flowers);

        ArrayList<Coin>[] coins = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            coins[i] = new ArrayList<Coin>();
        }
        coins[getCurrentSection()].add(new Coin(600, 400 - 32));
        setCoins(coins);

        EndWall[] endWalls = new EndWall[2];
        endWalls[0] = new EndWall(1000,0,1000,1000);
        endWalls[1] = new EndWall(1000,0,1000,1000);
        setEndWalls(endWalls);
        setRemainingTime(100);

    }

}
