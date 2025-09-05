/*
 * Decompiled with CFR 0.152.
 */

import ContinuousGenerator;
import Generator;
import ParameterException;

public class Uniform
extends Generator
implements ContinuousGenerator {
    private double min;
    private double max;

    public Uniform(double d, double d2) {
        this.set(d, d2);
    }

    public Uniform(double d, double d2, long l) {
        super(l);
        this.set(d, d2);
    }

    private void set(double d, double d2) {
        if (d2 <= d) {
            throw new ParameterException("Uniform: The maximum must be greater than the minimum.");
        }
        this.min = d;
        this.max = d2;
    }

    public double sample() {
        return this.distrib.uniform(this.min, this.max);
    }
}
