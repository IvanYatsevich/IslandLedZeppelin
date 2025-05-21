package com.javarush.island.yatsevich.smth;

import com.javarush.island.yatsevich.entity.animals.CreatureTypes;
import com.javarush.island.yatsevich.entity.animals.herbivore.Horse;
import com.javarush.island.yatsevich.entity.animals.predator.Wolf;

public class HerbivoreFabric {
    public Horse createHorse() {
        Horse horse;
        boolean isDead = false;
        final CreatureTypes creatureType = CreatureTypes.HERBIVORE;
        final int weight = 50;
        final int speed = 3;
        final int maxFood = 8;
        final int groupSize = 30;
        final String name = "Horse";
        return new Horse(isDead, creatureType, weight, speed, maxFood, groupSize, name);
    }
}
