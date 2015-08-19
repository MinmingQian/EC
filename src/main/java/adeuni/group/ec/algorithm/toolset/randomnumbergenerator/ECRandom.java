package adeuni.group.ec.algorithm.toolset.randomnumbergenerator;

import java.util.Random;

/**
 * Created by qianminming on 17/08/15.
 */
public class ECRandom {
    private static final class RandomNumberGeneratorHolder {
        static final Random randomNumberGenerator = new Random();
    }

    public static int nextInt() {
        return RandomNumberGeneratorHolder.randomNumberGenerator.nextInt();
    }


    public static double nextGaussian() {
        return RandomNumberGeneratorHolder.randomNumberGenerator.nextGaussian();
    }

    public static double nextDouble() {
        return RandomNumberGeneratorHolder.randomNumberGenerator.nextDouble();
    }
}
