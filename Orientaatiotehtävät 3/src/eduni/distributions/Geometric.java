/*
 * Decompiled with CFR 0.152.
 */


import DiscreteGenerator;
import Generator;
import ParameterException;

public class Geometric
extends Generator
implements DiscreteGenerator {
    private double prob;

    public Geometric(double d) {
        this.set(d);
    }

    public Geometric(double d, long l) {
        super(l);
        this.set(d);
    }

    private void set(double d) {
        if (d <= 0.0 || d >= 1.0) {
            throw new ParameterException("Geometric: The probability of success must be between 0 and 1.");
        }
        this.prob = d;
    }

    public long sample() {
        return this.distrib.geometric(this.prob);
    }
}
