package com.javarush.island.yatsevich.entity.map;

import com.javarush.island.yatsevich.entity.animals.BaseEntity;
import com.javarush.island.yatsevich.entity.animals.predator.Wolf;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<BaseEntity> population = new ArrayList<BaseEntity>();

    public List<BaseEntity> getPopulation() {
        return this.population;
    }

    public void add(BaseEntity baseEntity ) {
        this.population.add(baseEntity);
    }

    public void remove(BaseEntity baseEntity) {
        population.remove(baseEntity);
    }

  //  public void someAction (){
    //    population.get(0);
     //   if population get random
  //  type of wolf// wolf
  @Override
  public String toString() {
      return "Cell population is " + population + "\n" + "end of population";
  }
    }



