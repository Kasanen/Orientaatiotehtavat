/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import Generator;
import ParameterException;

public class Negexp
extends Generator
implements ContinuousGenerator {
    private double mean;

    public Negexp(double d) {
        this.set(d);
    }

    public Negexp(double d, long l) {
        super(l);
        this.set(d);
    }

    private void set(double d) {
        if (d <= 0.0) {
            throw new ParameterException("Negexp: The mean must be greater than 0.");
        }
        this.mean = d;
    }

    public double sample() {
        return this.distrib.negexp(this.mean);
    }
}
