/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import Generator;
import ParameterException;

public class Pareto
extends Generator
implements ContinuousGenerator {
    private double shape;
    private double scale;

    public Pareto(double d, double d2) {
        this.set(d2, d);
    }

    public Pareto(double d, double d2, long l) {
        super(l);
        this.set(d2, d);
    }

    private void set(double d, double d2) {
        if (d <= 0.0 || d2 <= 0.0) {
            throw new ParameterException("Pareto: Shape and scale parameters must be greater than 0.");
        }
        this.shape = d;
        this.scale = d2;
    }

    public double sample() {
        return this.distrib.pareto(this.shape, this.scale);
    }
}
