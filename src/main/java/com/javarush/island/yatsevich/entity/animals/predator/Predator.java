package com.javarush.island.yatsevich.entity.animals.predator;

import com.javarush.island.yatsevich.api.Eatable;
import com.javarush.island.yatsevich.api.Movable;
import com.javarush.island.yatsevich.api.Reproducible;
import com.javarush.island.yatsevich.entity.animals.BaseEntity;
import com.javarush.island.yatsevich.entity.animals.CreatureTypes;
import com.javarush.island.yatsevich.entity.animals.herbivore.Herbivore;
import com.javarush.island.yatsevich.entity.map.Cell;

public class Predator extends BaseEntity implements Eatable, Movable, Reproducible {
    private CreatureTypes creatureTypes;

    public Predator(boolean isDead,  CreatureTypes creatureTypes) {
        super(isDead);
        this.creatureTypes = creatureTypes;
    }

    @Override
    public void eat(BaseEntity prey,  Cell cell) {
        if (prey instanceof Herbivore) {
            prey.setDead();
            System.out.println(prey + "posle smerti");
            cell.remove(prey);
        }
           }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void move() {

    }

    @Override
    public BaseEntity reproduce() {
        return null;
    }


}

