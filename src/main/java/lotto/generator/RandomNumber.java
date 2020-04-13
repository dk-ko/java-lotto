package lotto.generator;

import java.util.Random;

public class RandomNumber implements NumberGenerator {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(LOTTO_MAX_NUMBER) + LOTTO_MIN_NUMBER;
    }
}