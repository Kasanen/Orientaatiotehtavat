/*
 * Decompiled with CFR 0.152.
 */


import Normal;

public class LogNormal
extends Normal {
    public LogNormal(double d, double d2) {
        super(d, d2);
    }

    public LogNormal(double d, double d2, long l) {
        super(d, d2, l);
    }

    public double sample() {
        return this.distrib.lognormal2(this.mean, this.std_dev);
    }
}
