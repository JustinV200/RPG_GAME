package jav.offroadrpg.Objects;

import java.util.ArrayList;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.texture.Texture;

import jav.offroadrpg.EntityType;

public class objectCreator3000 {
    private String backgroundName;
    private ArrayList<Objects> objects = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();

    public objectCreator3000(String backgroundName) {
        this.backgroundName = backgroundName;
    }

    public void addObject(Objects object) {
        objects.add(object);
    }

    public void populate() {
        for (Objects object : objects) {
            Texture texture = FXGL.getAssetLoader().loadTexture(object.image);
            texture.setFitWidth(object.size[0]);
            texture.setFitHeight(object.size[1]);

            Entity entity = FXGL.entityBuilder()
                    .at(object.position[0], object.position[1])
                    .view(texture)
                    .with(new CollidableComponent(true))
                    .type(EntityType.OBJECT)
                    .buildAndAttach();

            entities.add(entity);
        }
    }

    public void reset() {
        for (Entity entity : entities) {
            entity.removeFromWorld();
        }
        entities.clear();
        objects.clear();
    }
}