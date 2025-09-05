/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import Generator;
import ParameterException;

public class Gamma
extends Generator
implements ContinuousGenerator {
    private double scale;
    private double shape;

    public Gamma(double d, double d2) {
        this.set(d, d2);
    }

    public Gamma(double d, double d2, long l) {
        super(l);
        this.set(d, d2);
    }

    private void set(double d, double d2) {
        if (d <= 0.0 || d2 <= 0.0) {
            throw new ParameterException("Gamma: The scale and shape parameters must be greater than 0.");
        }
        this.scale = d;
        this.shape = d2;
    }

    public double sample() {
        return this.distrib.gamma(this.scale, this.shape);
    }
}
