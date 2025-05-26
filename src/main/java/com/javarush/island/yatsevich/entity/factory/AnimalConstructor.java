package com.javarush.island.yatsevich.entity.factory;

import com.javarush.island.yatsevich.entity.entities.AnimalEntity;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalName;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalType;

public interface AnimalConstructor <T extends AnimalEntity>{
    T createAnimal(boolean isDead, double maxWeight, int speed,
                   double maxFood, int maxGroupSize,
                   AnimalType animalType, AnimalName animalName, String icon, double currentWeight);
}
