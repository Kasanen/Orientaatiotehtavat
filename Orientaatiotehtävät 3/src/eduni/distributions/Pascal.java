/*
 * Decompiled with CFR 0.152.
 */


import DiscreteGenerator;
import Generator;
import ParameterException;

public class Pascal
extends Generator
implements DiscreteGenerator {
    private double prob;
    private int successes;

    public Pascal(double d, int n) {
        this.set(d, n);
    }

    public Pascal(double d, int n, long l) {
        super(l);
        this.set(d, n);
    }

    private void set(double d, int n) {
        if (d <= 0.0 || d >= 1.0) {
            throw new ParameterException("Pascal: The probability of success must be between 0 and 1.");
        }
        if (n <= 0) {
            throw new ParameterException("Pascal: The number of successes must be a positive integer.");
        }
        this.prob = d;
        this.successes = n;
    }

    public long sample() {
        return this.distrib.pascal(this.prob, this.successes);
    }
}
