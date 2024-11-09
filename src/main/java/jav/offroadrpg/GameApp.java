package jav.offroadrpg;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.UserAction;

import jav.offroadrpg.Characters.Player;
import jav.offroadrpg.Landscape.Background;
import javafx.scene.input.KeyCode;

public class GameApp extends GameApplication {

    private Player player;
    private Background background;

    @Override
    protected void initSettings(GameSettings settings) {
        background = new Background(new int[]{1600, 1200}, "Backgrounds/Intro_village.jpg","testingSong.mp3",settings);
    }

    @Override
    protected void initGame() {
        background.generateBackground();
        background.playMusic();
       // player = new Player("Hero", 100, 5, "Characters/Knight.png", new int[]{background.getSize()[0]/2, background.getSize()[1]/2});
       player = new Player("Hero", 100, 5, "Characters/Knight.png", new int[]{600, 400});
        player.createEntity();

        // Bind the camera to the player entity
        FXGL.getGameScene().getViewport().bindToEntity(player.getEntity(), 600, 400);
    }

    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                player.moveRight();
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
}