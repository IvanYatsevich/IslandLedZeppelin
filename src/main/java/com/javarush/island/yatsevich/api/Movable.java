package com.javarush.island.yatsevich.api;

import com.javarush.island.yatsevich.island.IslandMap;

public interface Movable {

    void move(IslandMap map, int currentX, int currentY);
}
