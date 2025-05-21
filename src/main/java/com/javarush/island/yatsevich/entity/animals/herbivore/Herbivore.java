package com.javarush.island.yatsevich.entity.animals.herbivore;

import com.javarush.island.yatsevich.api.Eatable;
import com.javarush.island.yatsevich.api.Movable;
import com.javarush.island.yatsevich.api.Reproducible;
import com.javarush.island.yatsevich.entity.animals.BaseEntity;
import com.javarush.island.yatsevich.entity.animals.CreatureTypes;
import com.javarush.island.yatsevich.entity.map.Cell;

public class Herbivore extends BaseEntity implements Eatable, Movable, Reproducible {
    private CreatureTypes creatureTypes;

    public Herbivore(boolean isDead, CreatureTypes creatureTypes) {
        super(isDead);
        this.creatureTypes = creatureTypes;
    }

    @Override
    public void eat(BaseEntity baseEntity, Cell cell) {

    }

    @Override
    public void move() {

    }

    @Override
    public BaseEntity reproduce() {
        return null;
    }
}
