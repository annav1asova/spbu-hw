package spbu.sem3.hw2.task1;

import java.util.Random;

public class TrueRandomGenerator implements RandomGenerator {
    Random r;
    public TrueRandomGenerator() {
        r = new Random();
    }
    @Override
    public int generate(int max) {
        return r.nextInt(max);
    }
}
