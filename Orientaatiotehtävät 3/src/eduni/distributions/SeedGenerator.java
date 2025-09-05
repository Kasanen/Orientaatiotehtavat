/*
 * Decompiled with CFR 0.152.
 */


import DiscreteGenerator;
import RandomGenerator;

public class SeedGenerator
implements DiscreteGenerator {
    private static long root = 4851L;
    private int spacing;
    private boolean not_sampled = true;
    private RandomGenerator source;
    private static SeedGenerator defaut = new SeedGenerator();

    public SeedGenerator() {
        this(root, 100000);
    }

    public SeedGenerator(long l, int n) {
        this.source = new RandomGenerator(l);
        this.spacing = n;
    }

    public void setSeed(long l) {
        this.source.setSeed(l);
        this.not_sampled = true;
    }

    public long getSeed() {
        return this.source.getSeed();
    }

    public void reseed() {
        this.source.reseed();
        this.not_sampled = true;
    }

    public long sample() {
        if (this.not_sampled) {
            this.not_sampled = false;
        } else {
            int n = 0;
            while (n < this.spacing) {
                this.source.nextLong();
                ++n;
            }
        }
        return this.getSeed();
    }

    static SeedGenerator getDefaultSeedGenerator() {
        return defaut;
    }

    static void setDefaultSeedGenerator(long l, int n) {
        defaut = new SeedGenerator(l, n);
    }
}
