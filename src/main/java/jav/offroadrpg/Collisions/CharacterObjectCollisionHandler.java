package jav.offroadrpg.Collisions;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;

import jav.offroadrpg.EntityType;

public class CharacterObjectCollisionHandler extends CollisionHandler {

    public CharacterObjectCollisionHandler() {
        super(EntityType.CHARACTER, EntityType.OBJECT);
    }

    @Override
    protected void onCollisionBegin(Entity characterEntity, Entity objectEntity) {
        // Print a statement when a collision is detected
        System.out.println("Collision detected between character and object");
    }
}