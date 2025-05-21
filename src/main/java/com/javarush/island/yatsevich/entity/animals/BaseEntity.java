package com.javarush.island.yatsevich.entity.animals;

import java.util.concurrent.atomic.AtomicInteger;


public abstract class BaseEntity  {


    private final int id= idGenerator.incrementAndGet();;
    private static final AtomicInteger idGenerator = new AtomicInteger(0);

    private boolean isDead;

    public BaseEntity(boolean isDead) {
        this.isDead = isDead;
    }

    public int getId() {
        return id;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead (){
        isDead = true;
    }
}
