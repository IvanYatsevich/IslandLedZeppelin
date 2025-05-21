package com.javarush.island.yatsevich.smth;

import com.javarush.island.yatsevich.entity.animals.CreatureTypes;
import com.javarush.island.yatsevich.entity.animals.predator.Wolf;

public class PredatorFabric {


    public Wolf createWolf() {
        boolean isDead = false;
        final CreatureTypes creatureType = CreatureTypes.PREDATOR;
        final int weight = 50;
        final int speed = 3;
        final int maxFood = 8;
        final int groupSize = 30;
        final String name = "Wolf";
        return new Wolf(isDead, creatureType, weight, speed, maxFood, groupSize, name);
    }
}
