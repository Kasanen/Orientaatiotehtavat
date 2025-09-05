/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import Generator;
import ParameterException;

public class Logistic
extends Generator
implements ContinuousGenerator {
    private double location;
    private double scale;

    public Logistic(double d, double d2) {
        this.set(d, d2);
    }

    public Logistic(double d, double d2, long l) {
        super(l);
        this.set(d, d2);
    }

    private void set(double d, double d2) {
        if (d2 <= 0.0) {
            throw new ParameterException("Logistic: The scale parameter must be greater than 0.");
        }
        this.location = d;
        this.scale = d2;
    }

    public double sample() {
        return this.distrib.logistic(this.location, this.scale);
    }
}
