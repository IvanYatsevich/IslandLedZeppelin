package com.javarush.island.yatsevich.utils.random;

import java.util.concurrent.ThreadLocalRandom;


    public class Rnd {

        private Rnd() {
        }

        public static int random(int min, int max) {
            if (min >= max) {
                return min;
            }
            return ThreadLocalRandom.current().nextInt(min, max);
        }

        public static double random(double min, double max) {
            if (min >= max) {
                return min;
            }
            return ThreadLocalRandom.current().nextDouble(min, max);
        }

    }

