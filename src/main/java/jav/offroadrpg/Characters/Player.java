package jav.offroadrpg.Characters;

//import com.almasb.fxgl.entity.Entity;

public class Player extends Character {
    public Player(String name, int health, int speed, String image, int[] position) {
        super(name, health, speed, image, position);
    }

    public void moveRight() {
        this.theguy.translateX(this.speed);
    }

    public void moveLeft() {
        this.theguy.translateX(-this.speed);
    }

    public void moveUp() {
        this.theguy.translateY(-this.speed);
    }

    public void moveDown() {
        this.theguy.translateY(this.speed);
    }
}