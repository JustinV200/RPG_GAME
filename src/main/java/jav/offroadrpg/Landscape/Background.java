package jav.offroadrpg.Landscape;

import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.audio.Music;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;

public class Background {
    final private int[] size;
    private String image;
    private String music;
    private GameSettings settings;
    private Music currentMusic;
    private String identifier;


    public Background(int[] size, String image, String music, GameSettings settings, String identifier) {
        this.size = size;
        this.image = image;
        this.settings = settings;
        this.music = music;
        this.identifier = identifier;
        setSettings();
    }

    private void setSettings() {
        this.settings.setWidth(this.size[0]);
        this.settings.setHeight(this.size[1]);
        this.settings.setTitle("Simple FXGL Game");
        this.settings.setVersion("0.1");
    }

    public void playMusic() {
        if (currentMusic != null) {
            FXGL.getAudioPlayer().stopMusic(currentMusic);
        }
        currentMusic = FXGL.getAssetLoader().loadMusic(this.music);
        FXGL.getAudioPlayer().loopMusic(currentMusic);
    }

    public void changeSong(String value) {
        this.music = value;
        playMusic();
    }

    public void setImage(String image) {
        this.image = image;
        updateBackground();
    }

    public void generateBackground() {
        updateBackground();
    }

    public int[] getSize() {
        return this.size;
    }

    private void updateBackground() {
        Texture texture = FXGL.getAssetLoader().loadTexture(this.image);
        texture.setScaleX(4.5); // Scale the image
        texture.setScaleY(4.5); // Scale the image

        FXGL.entityBuilder()
                .view(texture)
                .buildAndAttach();
    }
    public String getIdentifier() {
        return this.identifier;
    }
    public void setIdentifier(String value) {
        this.identifier = value;
    }

}