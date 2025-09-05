/*
 * Decompiled with CFR 0.152.
 */


import DiscreteGenerator;
import Generator;
import ParameterException;

public class Poisson
extends Generator
implements DiscreteGenerator {
    private double mean;

    public Poisson(double d) {
        this.set(d);
    }

    public Poisson(double d, long l) {
        super(l);
        this.set(d);
    }

    private void set(double d) {
        if (d <= 0.0) {
            throw new ParameterException("Poisson: The mean must be greater than 0.");
        }
        this.mean = d;
    }

    public long sample() {
        return this.distrib.poisson(this.mean);
    }
}
