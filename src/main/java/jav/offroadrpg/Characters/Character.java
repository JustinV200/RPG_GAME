package jav.offroadrpg.Characters;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;

public class Character {
    protected String name;
    protected int START_health;
    protected int health;
    protected int speed;
    protected int[] position = new int[2];
    protected String image;
    protected Entity theguy = null;

    public Character(String name, int health, int speed, String image, int[] position) {
        this.position = position;
        this.name = name;
        this.health = health;
        this.START_health = health;
        this.speed = speed;
        this.image = image;
    }

    public void createEntity() {
        Texture texture = FXGL.getAssetLoader().loadTexture(this.image);
        texture.setScaleX(0.25); // Scale down the image to 50% of its original width
        texture.setScaleY(0.25); // Scale down the image to 50% of its original height
        this.theguy = FXGL.entityBuilder()
                .at(position[0], position[1])
                .view(texture)
                .buildAndAttach();
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Entity getEntity() {
        return this.theguy;
    }
    public String getImage() {
        return this.image;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int value) {
        this.health += value;
    }

    public void heal() {
        this.health = this.START_health;
    }
}