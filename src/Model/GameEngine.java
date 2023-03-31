package Model;
import Controller.Controller;
import View.GameFrame;
import View.TimerPanel;

public class GameEngine implements Runnable {
    private User user;
    private Level level;
    private Controller controller;
    Thread gameThread;
    double totalPassedTime;
    GameFrame gameFrame;

    public GameEngine(User user, Controller controller, GameFrame gameFrame){
        setUser(user);
        setController(controller);
        this.gameFrame = gameFrame;
        gameThread = new Thread(this);
        gameThread.start();
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        totalPassedTime = 0;

        while (true){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            totalPassedTime += (now-lastTime) / 1000000000.0;
            lastTime = now;

            if (delta >= 1){



                delta--;
            }
        }
    }
}
