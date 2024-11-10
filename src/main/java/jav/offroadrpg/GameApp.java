package jav.offroadrpg;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.UserAction;

import jav.offroadrpg.Characters.Player;
import jav.offroadrpg.Collisions.CharacterObjectCollisionHandler;
import jav.offroadrpg.Landscape.Background;
import jav.offroadrpg.Objects.Objects;
import jav.offroadrpg.Objects.objectCreator3000;
import javafx.scene.input.KeyCode;

public class GameApp extends GameApplication {

    private Player player;
    private Background background;

    @Override
    protected void initSettings(GameSettings settings) {
        background = new Background(new int[]{1600, 1200}, "Backgrounds/Intro_village.jpg","testingSong.mp3",settings, "test");
    }

    @Override
    protected void initGame() {
        //generate the background and play the appropriate music
        background.generateBackground();
        background.playMusic();

        //Initialize the objects
        objectCreator3000 creator = new objectCreator3000(background.getIdentifier());
        add_objectsTest(creator);
        creator.populate();


       // player = new Player("Hero", 100, 5, "Characters/Knight.png", new int[]{background.getSize()[0]/2, background.getSize()[1]/2});
       player = new Player("Hero", 100, 5, "Characters/Knight.png", new int[]{600, 400});
        player.createEntity();

        // Bind the camera to the player entity
        FXGL.getGameScene().getViewport().bindToEntity(player.getEntity(), 600, 400);

        //Object-Character Collision Handler
        FXGL.getPhysicsWorld().addCollisionHandler(new CharacterObjectCollisionHandler());

    }


    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                player.moveRight();
                //System.out.println("Player Location: " + player.getEntity().getPosition());
            }
        }, KeyCode.D);

        FXGL.getInput().addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.moveLeft();
            }
        }, KeyCode.A);

        FXGL.getInput().addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                player.moveUp();
            }
        }, KeyCode.W);

        FXGL.getInput().addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                player.moveDown();
            }
        }, KeyCode.S);
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Add objects to the objectCreator3000, methods to populate the objects
    
    private void add_objectsTest(objectCreator3000 creator) {
        creator.addObject(new Objects("tree", new int[]{100, 100}, new int[]{100, 100}, "Objects/tree.png"));
        creator.addObject(new Objects("tree2", new int[]{300, 300}, new int[]{700, 800}, "Objects/tree.png"));
        creator.addObject(new Objects("tree3", new int[]{100, 100}, new int[]{600, 1200}, "Objects/tree.png"));
        creator.addObject(new Objects("tree4", new int[]{500, 10}, new int[]{950, 230}, "Objects/tree.png"));
        creator.addObject(new Objects("tree5", new int[]{50, 50}, new int[]{1200, 100}, "Objects/tree.png"));
    }
}