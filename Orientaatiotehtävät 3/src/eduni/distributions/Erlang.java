/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import Generator;
import ParameterException;

public class Erlang
extends Generator
implements ContinuousGenerator {
    private double scale;
    private double shape;

    public Erlang(double d, double d2) {
        this.set(d2, d);
    }

    public Erlang(double d, double d2, long l) {
        super(l);
        this.set(d2, d);
    }

    private void set(double d, double d2) {
        if (d <= 0.0) {
            throw new ParameterException("Erlang: The scale parameter must be greater than 0.");
        }
        this.scale = d;
        this.shape = d2;
    }

    public double sample() {
        return this.distrib.erlang(this.shape, this.scale);
    }
}
