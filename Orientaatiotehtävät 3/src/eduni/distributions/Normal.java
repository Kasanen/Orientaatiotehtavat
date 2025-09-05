/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import Generator;
import ParameterException;

public class Normal
extends Generator
implements ContinuousGenerator {
    protected double mean;
    protected double std_dev;

    public Normal(double d, double d2) {
        this.set(d, d2);
    }

    public Normal(double d, double d2, long l) {
        super(l);
        this.set(d, d2);
    }

    private void set(double d, double d2) {
        if (d2 <= 0.0) {
            throw new ParameterException("Normal: The variance must be greater than 0.");
        }
        this.mean = d;
        this.std_dev = Math.sqrt(d2);
    }

    public double sample() {
        return this.distrib.normal2(this.mean, this.std_dev);
    }
}
