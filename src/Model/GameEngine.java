package Model;
import Controller.Controller;

public class GameEngine {
    private User user;
    private Level level;
    private Controller controller;

    public GameEngine(User user, Level level, Controller controller){
        setUser(user);
        setLevel(level);
        setController(controller);
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
}
