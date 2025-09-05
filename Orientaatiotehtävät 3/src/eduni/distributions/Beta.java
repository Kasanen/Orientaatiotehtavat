/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import Generator;
import ParameterException;

public class Beta
extends Generator
implements ContinuousGenerator {
    protected double shape_a;
    protected double shape_b;

    public Beta(double d, double d2) {
        this.set(d, d2);
    }

    public Beta(double d, double d2, long l) {
        super(l);
        this.set(d, d2);
    }

    private void set(double d, double d2) {
        if (d <= 0.0 || d2 <= 0.0) {
            throw new ParameterException("Beta: The shape parameters must be greater than 0.");
        }
        this.shape_a = d;
        this.shape_b = d2;
    }

    public double sample() {
        return this.distrib.beta(this.shape_a, this.shape_b);
    }
}
