package com.javarush.island.yatsevich.entity.herbivore;

import com.javarush.island.yatsevich.entity.entities.AnimalEntity;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalName;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalType;

public class Mouse extends AnimalEntity {
    public Mouse(boolean isDead, double maxWeight, int speed, double maxFood, int maxGroupSize, AnimalType animalType, AnimalName animalName, String icon, double currentWeight) {
        super(isDead, maxWeight, speed, maxFood, maxGroupSize, animalType, animalName, icon, currentWeight);
    }
}
