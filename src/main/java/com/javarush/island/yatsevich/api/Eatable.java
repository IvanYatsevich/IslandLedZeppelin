package com.javarush.island.yatsevich.api;

import com.javarush.island.yatsevich.entity.animals.BaseEntity;
import com.javarush.island.yatsevich.entity.animals.CreatureTypes;
import com.javarush.island.yatsevich.entity.map.Cell;

public interface Eatable  {
    void eat(BaseEntity baseEntity,  Cell cell);

    }
