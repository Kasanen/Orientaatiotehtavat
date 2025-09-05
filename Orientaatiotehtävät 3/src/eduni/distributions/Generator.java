/*
 * Decompiled with CFR 0.152.
 */


import Distributions;
import Seedable;

public abstract class Generator
implements Seedable {
    protected Distributions distrib;

    Generator() {
        this.distrib = new Distributions();
    }

    Generator(long l) {
        this.distrib = new Distributions(l);
    }

    public void setSeed(long l) {
        this.distrib.source.setSeed(l);
    }

    public long getSeed() {
        return this.distrib.source.getSeed();
    }

    public void reseed() {
        this.distrib.source.reseed();
    }
}
