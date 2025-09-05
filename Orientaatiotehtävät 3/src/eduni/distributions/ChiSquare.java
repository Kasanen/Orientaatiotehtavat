/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import Generator;
import ParameterException;

public class ChiSquare
extends Generator
implements ContinuousGenerator {
    private long deg_freedom;

    public ChiSquare(long l) {
        this.set(l);
    }

    public ChiSquare(long l, long l2) {
        super(l2);
        this.set(l);
    }

    private void set(long l) {
        if (l <= 0L) {
            throw new ParameterException("ChiSquare: The degrees of freedom must be a positive integer.");
        }
        this.deg_freedom = l;
    }

    public double sample() {
        return this.distrib.chisquare(this.deg_freedom);
    }
}
