package Controller;

import Model.Block.*;
import Model.Enemies.Flower;
import Model.Enemies.Goomba;
import Model.Enemies.Koopa;
import Model.Enemies.Spiny;
import Model.Items.Coin;
import Model.Items.MagicalFlower;
import Model.Items.MagicalMushroom;
import Model.Items.MagicalStar;
import Model.Levels.Level;
import Model.PhysicalObjects.EndWall;
import Model.PhysicalObjects.Floor;
import Model.Pipes.Pipe;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LevelConstructor
{
    public static String location = "AP_Project/src/Config/Game.json";
    public static Level construct(int _level, int _section) throws FileNotFoundException
    {
        _level--;
        _section--; //making level and section not 0 based
        long hearts;
        long marioState;
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(location))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject data = (JSONObject) obj;
            hearts = (long) data.get("hearts");
            marioState = (long) data.get("marioState");
            JSONArray levels = (JSONArray) data.get("levels");
            JSONObject sectionsData = (JSONObject) levels.get(_level);
            JSONArray sections = (JSONArray) sectionsData.get("sections");
            JSONObject currentSection = (JSONObject) sections.get(_section);
            long length = (long) currentSection.get("length");
            long time = (long) currentSection.get("time");
            JSONArray blocks = (JSONArray) currentSection.get("blocks");
            JSONArray enemies = (JSONArray) currentSection.get("enemies");
            JSONArray pipes = (JSONArray) currentSection.get("pipes");
            JSONArray items = (JSONArray) currentSection.get("items");
            JSONArray physicalObjects = (JSONArray) currentSection.get("physicalObjects");
            JSONObject spawnPipe = (JSONObject) currentSection.get("spawnPipe");
            Level newLevel = new Level(_level,_section);

            //Blocks//

            ArrayList<CoinBlock> coinBlocks = new ArrayList<>();
            ArrayList<EmptyBlock> emptyBlocks = new ArrayList<>();
            ArrayList<GiftBlock> giftBlocks = new ArrayList<>();
            ArrayList<MultiCoinBlock> multiCoinBlocks = new ArrayList<>();
            ArrayList<NormalBlock> normalBlocks = new ArrayList<>();

            for (Object block : blocks){
                JSONObject ourBlock = (JSONObject) block;
                String type = (String) ourBlock.get("type");
                long upperLeftX = (long)ourBlock.get("x");
                long upperLeftY = (long)ourBlock.get("y");
                if (type.equals("CoinBlock")){
                    String myItem = (String) ourBlock.get("item");
                    CoinBlock myCoinBlock = new CoinBlock((int)upperLeftX,(int)upperLeftY,myItem);
                    coinBlocks.add(myCoinBlock);
                } else if (type.equals("EmptyBlock")) {
                    emptyBlocks.add(new EmptyBlock((int)upperLeftX,(int)upperLeftY));
                } else if (type.equals("GiftBlock")) {
                    String item = (String) ourBlock.get("item");
                    giftBlocks.add(new GiftBlock((int)upperLeftX,(int)upperLeftY,item));
                } else if (type.equals("NormalBlock")) {
                    normalBlocks.add(new NormalBlock((int)upperLeftX,(int)upperLeftY));
                }
                else {
                    String myItem = (String) ourBlock.get("item");
                    MultiCoinBlock myMultiCoinBlock = new MultiCoinBlock((int)upperLeftX,(int)upperLeftY,myItem);
                    multiCoinBlocks.add(myMultiCoinBlock);
                }
            }

            //Enemies//
            ArrayList<Flower> flowers = new ArrayList<>();
            ArrayList<Goomba> goombas = new ArrayList<>();
            ArrayList<Koopa> koopas = new ArrayList<>();
            ArrayList<Spiny> spinies = new ArrayList<>();
            for (Object enemy : enemies){
                JSONObject ourEnemy = (JSONObject)enemy;
                String type = (String) ourEnemy.get("type");
                long upperLeftX = (long)ourEnemy.get("x");
                long upperLeftY = (long)ourEnemy.get("y");
                if (type.equals("Flower")){
                    flowers.add(new Flower((int)upperLeftX,(int)upperLeftY));
                } else if (type.equals("Goomba")) {
                    goombas.add(new Goomba((int)upperLeftX,(int)upperLeftY));
                } else if (type.equals("Koopa")) {
                    koopas.add(new Koopa((int) upperLeftX,(int) upperLeftY));
                }
                else {
                    spinies.add(new Spiny((int)upperLeftX,(int)upperLeftY));
                }
            }


            //Pipes//
            ArrayList<Pipe> levelPipes = new ArrayList<>();
            for (Object pipe : pipes){
                JSONObject ourPipe = (JSONObject)pipe;
                String type = (String)ourPipe.get("type");
                long upperLeftX = (long)ourPipe.get("x");
                long upperLeftY = (long)ourPipe.get("y");
                if (type.equals("Simple")){
                    levelPipes.add(new Pipe((int)upperLeftX,(int)upperLeftY,type));
                } else if (type.equals("WithFlower")) {
                    levelPipes.add(new Pipe((int)upperLeftX,(int)upperLeftY,type));
                }
                //TODO : hidden section
            }

            //Items//
            ArrayList<Coin> coins = new ArrayList<>();
            ArrayList<MagicalFlower> magicalFlowers = new ArrayList<>();
            ArrayList<MagicalMushroom> magicalMushrooms = new ArrayList<>();
            ArrayList<MagicalStar> magicalStars = new ArrayList<>();
            for (Object item : items){
                JSONObject ourItem = (JSONObject)item;
                String type = (String)ourItem.get("type");
                long upperLeftX = (long)ourItem.get("x");
                long upperLeftY = (long)ourItem.get("y");
                if (type.equals("Coin")){
                    coins.add(new Coin((int)upperLeftX,(int)upperLeftY));
                } else if (type.equals("MagicalFlower")) {
                    magicalFlowers.add(new MagicalFlower((int)upperLeftX,(int)upperLeftY));
                } else if (type.equals("MagicalMushroom")) {
                    magicalMushrooms.add(new MagicalMushroom((int)upperLeftX,(int)upperLeftY));
                }
                else {
                    magicalStars.add(new MagicalStar((int) upperLeftX,(int)upperLeftY));
                }
            }

            //PhysicalObjects//

            ArrayList<Floor> floors = new ArrayList<>();
            EndWall endWalls = null;
            for (Object physicalObject : physicalObjects){
                JSONObject ourPO = (JSONObject)physicalObject;
                String type = (String)ourPO.get("type");
                long upperLeftX = (long)ourPO.get("x");
                long upperLeftY = (long)ourPO.get("y");
                long ourPOLength = (long) ourPO.get("length");
                long ourPOHeight = (long) ourPO.get("height");
                if (type.equals("EndWall")){
                    endWalls = (new EndWall((int)upperLeftX,(int) upperLeftY,(int)ourPOLength,(int)ourPOHeight));
                } else if (type.equals("Floor")) {
                    floors.add(new Floor((int)upperLeftX,(int) upperLeftY,(int)ourPOLength,(int)ourPOHeight));
                }
            }


            newLevel.setEmptyBlocks(emptyBlocks);
            newLevel.setGiftBlocks(giftBlocks);
            newLevel.setMultiCoinBlocks(multiCoinBlocks);
            newLevel.setCoinBlocks(coinBlocks);
            newLevel.setNormalBlocks(normalBlocks);
            newLevel.setFlowers(flowers);
            newLevel.setKoopas(koopas);
            newLevel.setGoombas(goombas);
            newLevel.setSpinies(spinies);
            newLevel.setCoins(coins);
            newLevel.setPipes(levelPipes);
            newLevel.setMagicalFlowers(magicalFlowers);
            newLevel.setMagicalMushrooms(magicalMushrooms);
            newLevel.setMagicalStars(magicalStars);
            newLevel.setFloors(floors);
            newLevel.setEndWalls(endWalls);
            newLevel.setLevelNumber(_level + 1);
            newLevel.setSectionNumber(_section + 1);
            newLevel.setLength((int) length);
            newLevel.setTime((int) time);
            newLevel.setHearts((int)hearts);
            newLevel.setMarioState((int) marioState);
            return newLevel;
        }
        catch (IOException | ParseException e)
        {
            e.printStackTrace();
            return null;
        }

    }

    public static int numberOfSections( int _level){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(location)) {
            Object obj = jsonParser.parse(reader);
            JSONObject data = (JSONObject) obj;
            JSONArray levels = (JSONArray) data.get("levels");
            JSONArray sections = (JSONArray) levels.get(_level);
            return sections.size();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}