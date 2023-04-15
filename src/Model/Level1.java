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
        floors[0].add(new Floor(-200,0,200,600));
        floors[0].add(new Floor(0,400,1000,200));
        floors[0].add(new Floor(1000,400,1000,200));
        floors[0].add(new Floor(2000,400,400,200));
        floors[0].add(new Floor(2600,400,400,200));
        floors[0].add(new Floor(3000,400,1000,200));
        floors[0].add(new Floor(3400,300,200,100));

        floors[1].add(new Floor(-200,0,200,600));
        floors[1].add(new Floor(0,400,650,600));
        floors[1].add(new Floor(2000,400,1000,600));
        floors[1].add(new Floor(3000,400,480,600));
        floors[1].add(new Floor(3520,400,480,600));
        setFloors(floors);
        ArrayList<NormalBlock>[] normalBlocks = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            normalBlocks[i] = new ArrayList<NormalBlock>();
        }
        normalBlocks[0].add(new NormalBlock(2500 - 20,300));
        normalBlocks[0].add(new NormalBlock(500 - (20),300));
        normalBlocks[0].add(new NormalBlock(500 + (20),300));

        normalBlocks[1].add(new NormalBlock(750,300));
        normalBlocks[1].add(new NormalBlock(850,200));
        normalBlocks[1].add(new NormalBlock(950,100));
        normalBlocks[1].add(new NormalBlock(1100,400));
        normalBlocks[1].add(new NormalBlock(1300,400));
        normalBlocks[1].add(new NormalBlock(1500,400));
        normalBlocks[1].add(new NormalBlock(1700,250));
        normalBlocks[1].add(new NormalBlock(1900,300));
        normalBlocks[1].add(new NormalBlock(2500 - 20,300));

        normalBlocks[1].add(new NormalBlock(3480 - 40,400-40));
        normalBlocks[1].add(new NormalBlock(3480 - 80,400-40));
        normalBlocks[1].add(new NormalBlock(3480 - 40,400-80));

        normalBlocks[1].add(new NormalBlock(3480 + 40,400-40));
        normalBlocks[1].add(new NormalBlock(3480 + 80,400-40));
        normalBlocks[1].add(new NormalBlock(3480 + 40,400 - 80));

        setNormalBlocks(normalBlocks);
        ArrayList<PowerUpBlock>[] powerUpBlocks = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            powerUpBlocks[i] = new ArrayList<PowerUpBlock>();
        }
        powerUpBlocks[0].add(new PowerUpBlock(800,300));
        powerUpBlocks[1].add(new PowerUpBlock(100,300));
        setPowerUpBlocks(powerUpBlocks);
        ArrayList<CoinBlock>[] coinBlocks = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            coinBlocks[i] = new ArrayList<CoinBlock>();
        }
        coinBlocks[0].add(new CoinBlock(500 - (20+40),300));
        coinBlocks[0].add(new CoinBlock(500 + (20+40),300));
        coinBlocks[1].add(new CoinBlock(2500 - (20+40),300));
        coinBlocks[1].add(new CoinBlock(2500 + (20),300));
        setCoinBlocks(coinBlocks);
        ArrayList<Pipe>[] pipes = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            pipes[i] = new ArrayList<Pipe>();
        }
        pipes[0].add(new Pipe(1000 + 300,300));
        pipes[0].add(new Pipe(1000 + 450,300));
        pipes[0].add(new Pipe(1000 + 600,300));
        pipes[0].add(new Pipe(3400 + 100-30,200));

        pipes[1].add(new Pipe(1100 - 10 ,300));
        pipes[1].add(new Pipe(1300 - 10 ,300));
        pipes[1].add(new Pipe(1500 - 10 ,300));

        setPipes(pipes);

        ArrayList<Flower>[] flowers = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            flowers[i] = new ArrayList<Flower>();
        }
        flowers[0].add(new Flower(1000 + 300 + 10, 300 - 60 + 80));
        flowers[0].add(new Flower(1000 + 600 + 10, 300 - 60 + 80));
        flowers[0].add(new Flower(3400 + 100-30 + 10, 200 - 60 + 80));


        flowers[1].add(new Flower(1300, 300 - 60 + 80));
        flowers[1].add(new Flower(1500, 300 - 60 + 80));


        setFlowers(flowers);

        ArrayList<Coin>[] coins = new ArrayList[getNumberOfSections()];
        for (int i = 0; i < getNumberOfSections(); i++) {
            coins[i] = new ArrayList<Coin>();
        }
        coins[0].add(new Coin(500 - 150, 400 - 32));
        coins[0].add(new Coin(500 + 150, 400 - 32));
        coins[0].add(new Coin(2500 - 16, 300 - 32));
        coins[0].add(new Coin(2400 -32, 400 - 32));
        coins[0].add(new Coin(2600 , 400 - 32));
        coins[0].add(new Coin(3100 -32, 400 - 32));
        coins[0].add(new Coin(3200 -32, 400 - 32));
        coins[0].add(new Coin(3300 -32, 400 - 32));

        coins[1].add(new Coin(1700+4, 250 - 32));
        coins[1].add(new Coin(1900+4, 300 - 32));
        coins[1].add(new Coin(3480 - 80, 400 - 40 - 32));
        coins[1].add(new Coin(3480 + 80, 400 - 40 - 32));
        setCoins(coins);

        EndWall[] endWalls = new EndWall[2];
        endWalls[0] = new EndWall(4000,0,1000,1000);
        endWalls[1] = new EndWall(4000,0,1000,1000);
        setEndWalls(endWalls);

        int[] sectiosTime = new int[getNumberOfSections()];
        sectiosTime[0] = 45;
        sectiosTime[1] = 45;
        setSectiosTime(sectiosTime);

    }

}
