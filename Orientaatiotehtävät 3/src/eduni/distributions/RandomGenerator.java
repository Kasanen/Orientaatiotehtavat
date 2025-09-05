/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import SeedGenerator;

public class RandomGenerator
implements ContinuousGenerator {
    private final long a = 742938285L;
    private final long m = Integer.MAX_VALUE;
    private long seed;

    public RandomGenerator() {
        this.reseed();
    }

    public RandomGenerator(long l) {
        this.setSeed(l);
    }

    public double sample() {
        return (double)this.nextLong() / 2.147483647E9;
    }

    public long nextLong() {
        this.seed = 742938285L * this.seed % Integer.MAX_VALUE;
        return this.seed;
    }

    public void setSeed(long l) {
        this.seed = l;
    }

    public long getSeed() {
        return this.seed;
    }

    public void reseed() {
        this.seed = SeedGenerator.getDefaultSeedGenerator().sample();
    }
}
