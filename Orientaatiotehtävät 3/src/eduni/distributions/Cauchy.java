/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import Generator;
import ParameterException;

public class Cauchy
extends Generator
implements ContinuousGenerator {
    private double median;
    private double scale;

    public Cauchy(double d, double d2) {
        this.set(d, d2);
    }

    public Cauchy(double d, double d2, long l) {
        super(l);
        this.set(d, d2);
    }

    private void set(double d, double d2) {
        if (d2 <= 0.0) {
            throw new ParameterException("Cauchy: The scale parameter must be greater than 0.");
        }
        this.median = d;
        this.scale = d2;
    }

    public double sample() {
        return this.distrib.cauchy(this.median, this.scale);
    }
}
