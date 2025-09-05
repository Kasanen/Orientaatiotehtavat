/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import Generator;
import ParameterException;

public class FDistribution
extends Generator
implements ContinuousGenerator {
    private long num_deg_freedom;
    private long den_deg_freedom;

    public FDistribution(long l, long l2) {
        this.set(l, l2);
    }

    public FDistribution(long l, long l2, long l3) {
        super(l3);
        this.set(l, l2);
    }

    private void set(long l, long l2) {
        if (l <= 0L || l2 <= 0L) {
            throw new ParameterException("FDistribution: The degrees of freedom must be positive integers.");
        }
        this.num_deg_freedom = l;
        this.den_deg_freedom = l2;
    }

    public double sample() {
        return this.distrib.f(this.num_deg_freedom, this.den_deg_freedom);
    }
}
