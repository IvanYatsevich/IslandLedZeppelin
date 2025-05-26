package com.javarush.island.yatsevich.entity.factory;

import com.javarush.island.yatsevich.entity.entities.AnimalEntity;
import com.javarush.island.yatsevich.entity.herb.Grass;
import com.javarush.island.yatsevich.entity.herbivore.*;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalCfg;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalName;
import com.javarush.island.yatsevich.entity.predator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AnimalFactory {

    private final Map<AnimalName, Supplier<? extends AnimalEntity>> creators = new HashMap<>();

    public AnimalFactory() {
        creators.put(AnimalName.WOLF, () -> createAnimal(AnimalCfg.WOLF, Wolf::new));
        creators.put(AnimalName.BOA, () -> createAnimal(AnimalCfg.BOA, Boa::new));
        creators.put(AnimalName.FOX, () -> createAnimal(AnimalCfg.FOX, Fox::new));
        creators.put(AnimalName.BEAR, () -> createAnimal(AnimalCfg.BEAR, Bear::new));
        creators.put(AnimalName.EAGLE, () -> createAnimal(AnimalCfg.EAGLE, Eagle::new));
        creators.put(AnimalName.HORSE, () -> createAnimal(AnimalCfg.HORSE, Horse::new));
        creators.put(AnimalName.DEER, () -> createAnimal(AnimalCfg.DEER, Deer::new));
        creators.put(AnimalName.RABBIT, () -> createAnimal(AnimalCfg.RABBIT, Rabbit::new));
        creators.put(AnimalName.MOUSE, () -> createAnimal(AnimalCfg.MOUSE, Mouse::new));
        creators.put(AnimalName.GOAT, () -> createAnimal(AnimalCfg.GOAT, Goat::new));
        creators.put(AnimalName.SHEEP, () -> createAnimal(AnimalCfg.SHEEP, Sheep::new));
        creators.put(AnimalName.BOAR, () -> createAnimal(AnimalCfg.BOAR, Boar::new));
        creators.put(AnimalName.BUFFALO, () -> createAnimal(AnimalCfg.BUFFALO, Buffalo::new));
        creators.put(AnimalName.DUCK, () -> createAnimal(AnimalCfg.DUCK, Duck::new));
        creators.put(AnimalName.BUG, () -> createAnimal(AnimalCfg.BUG, Bug::new));
        creators.put(AnimalName.GRASS, () -> createAnimal(AnimalCfg.GRASS, Grass::new));

    }

    private <T extends AnimalEntity> T createAnimal(AnimalCfg cfg, AnimalConstructor<T> creator) {
        return creator.createAnimal(
                cfg.isDead(),
                cfg.getMaxWeight(),
                cfg.getSpeed(),
                cfg.getMaxFood(),
                cfg.getMaxGroupSize(),
                cfg.getAnimalType(),
                cfg.getAnimalName(),
                cfg.getIcon(),
                cfg.getCurrentWeight()
        );
    }

    public AnimalEntity createAnimal(AnimalName name) {
        Supplier<? extends AnimalEntity> supplier = creators.get(name);
        if (supplier == null) {
            throw new IllegalArgumentException("Unknown animal: " + name);
        }
        return supplier.get();
    }
}
