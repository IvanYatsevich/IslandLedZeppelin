package com.javarush.island.yatsevich.smth;

import com.javarush.island.yatsevich.entity.animals.BaseEntity;
import com.javarush.island.yatsevich.entity.animals.herbivore.Herbivore;
import com.javarush.island.yatsevich.entity.animals.herbivore.Horse;
import com.javarush.island.yatsevich.entity.animals.predator.Predator;
import com.javarush.island.yatsevich.entity.animals.predator.Wolf;
import com.javarush.island.yatsevich.entity.map.Cell;

import java.util.ArrayList;

public class TestRunner {
    public static PredatorFabric predatorFabric = new PredatorFabric();
    public static HerbivoreFabric herbivoreFabric = new HerbivoreFabric();
    public static void main(String[] args) {
        Cell cell = new Cell();


            cell.add(predatorFabric.createWolf());
            cell.add(herbivoreFabric.createHorse());

            //System.out.println(cell);

            //wolf.eat(horse,  cell);
        Predator entity = (Predator) cell.getPopulation().get(0);
        Herbivore herbivore = (Herbivore) cell.getPopulation().get(1);
        entity.eat(herbivore, cell);

            System.out.println(cell.getPopulation());




    }
}
