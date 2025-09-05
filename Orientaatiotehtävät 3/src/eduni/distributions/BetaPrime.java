/*
 * Decompiled with CFR 0.152.
 */


import Beta;

public class BetaPrime
extends Beta {
    public BetaPrime(double d, double d2) {
        super(d, d2);
    }

    public BetaPrime(double d, double d2, long l) {
        super(d, d2, l);
    }

    public double sample() {
        return this.distrib.betaprime(this.shape_a, this.shape_b);
    }
}
