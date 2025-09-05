/*
 * Decompiled with CFR 0.152.
 */


import ContinuousGenerator;
import RandomGenerator;

public class Distributions {
    ContinuousGenerator source;

    public Distributions() {
        this.source = new RandomGenerator();
    }

    public Distributions(long l) {
        this.source = new RandomGenerator(l);
    }

    public Distributions(ContinuousGenerator continuousGenerator) {
        this.source = continuousGenerator;
    }

    long bernoulli(double d) {
        return this.source.sample() <= d ? 1L : 0L;
    }

    long binomial(double d, int n) {
        long l = 0L;
        int n2 = 0;
        while (n2 < n) {
            l += this.bernoulli(d);
            ++n2;
        }
        return l;
    }

    long geometric(double d) {
        return (long)Math.ceil(Math.log(this.source.sample()) / Math.log(1.0 - d));
    }

    long pascal(double d, int n) {
        long l = 0L;
        int n2 = 0;
        while (n2 < n) {
            l += this.geometric(d);
            ++n2;
        }
        return l;
    }

    long poisson(double d) {
        long l = -1L;
        double d2 = Math.exp(-d);
        double d3 = 1.0;
        do {
            ++l;
        } while (d2 < (d3 *= this.source.sample()));
        return l;
    }

    private double power(double d) {
        return Math.pow(this.source.sample(), 1.0 / d);
    }

    double beta(double d, double d2) {
        double d3;
        double d4;
        if (d == 1.0) {
            return 1.0 - this.power(d2);
        }
        if (d2 == 1.0) {
            return this.power(d);
        }
        if (d > 1.0 || d2 > 1.0) {
            double d5;
            double d6;
            double d7;
            double d8;
            double d9;
            double d10;
            double d11;
            double d12 = d + d2;
            double d13 = Math.min(d, d2);
            double d14 = d13 <= 1.0 ? 1.0 / d13 : Math.sqrt((d12 - 2.0) / (2.0 * d * d2 - d12));
            double d15 = d + 1.0 / d2;
            do {
                d8 = this.source.sample();
                d6 = this.source.sample();
                d5 = this.source.sample();
            } while ((d11 = d12 * Math.log(d12 / (d14 + (d10 = d12 * Math.exp(d9 = d14 * Math.log(d8 / (1.0 - d8)))))) + d15 * d9 - Math.log(4.0)) < (d7 = Math.log(d8 * d6 * d5)));
            return d10 / (d14 + d10);
        }
        while ((d4 = this.power(d)) + (d3 = this.power(d2)) > 1.0) {
        }
        return d4 / (d4 + d3);
    }

    double betaprime(double d, double d2) {
        return 1.0 / this.beta(d, d2) - 1.0;
    }

    double cauchy(double d, double d2) {
        return d + d2 / Math.tan(Math.PI * this.source.sample());
    }

    double chisquare(long l) {
        double d = 0.0;
        long l2 = 0L;
        while (l2 < l) {
            d += this.normal2(0.0, 1.0);
            ++l2;
        }
        return d;
    }

    double erlang(double d, double d2) {
        double d3 = 1.0;
        int n = 0;
        while ((double)n < d2) {
            d3 *= this.source.sample();
            ++n;
        }
        return -d * Math.log(d3);
    }

    double f(long l, long l2) {
        return this.chisquare(l) / (double)l / (this.chisquare(l2) / (double)l2);
    }

    double gamma(double d, double d2) {
        if (d2 == Math.floor(d2)) {
            double d3 = 1.0;
            long l = 0L;
            while ((double)l < d2) {
                d3 *= this.source.sample();
                ++l;
            }
            return -d * Math.log(d3);
        }
        if (d2 < 1.0) {
            return d * this.beta(d2, 1.0 - d2) * this.negexp(1.0);
        }
        double d4 = Math.floor(d2);
        return this.gamma(d, d4) + this.gamma(d, d2 - d4);
    }

    double invgamma(double d, double d2) {
        return 1.0 / this.gamma(d, d2);
    }

    double logistic(double d, double d2) {
        return d - d2 * Math.log(1.0 / this.source.sample() - 1.0);
    }

    double lognormal(double d, double d2) {
        return this.lognormal2(d, Math.sqrt(d2));
    }

    double lognormal2(double d, double d2) {
        return Math.exp(d + d2 * this.normal2(0.0, 1.0));
    }

    double negexp(double d) {
        return -d * Math.log(this.source.sample());
    }

    double normal(double d, double d2) {
        return this.normal2(d, Math.sqrt(d2));
    }

    double normal2(double d, double d2) {
        double d3 = this.source.sample();
        double d4 = this.source.sample();
        return d + d2 * Math.cos(Math.PI * 2 * d3) * Math.sqrt(-2.0 * Math.log(d4));
    }

    double pareto(double d, double d2) {
        return d / Math.pow(this.source.sample(), 1.0 / d2);
    }

    double tstudent(long l) {
        return this.normal2(0.0, 1.0) / Math.sqrt(this.chisquare(l) / (double)l);
    }

    double uniform(double d, double d2) {
        return (d2 - d) * this.source.sample() + d;
    }

    double weibull(double d, double d2) {
        return d * Math.pow(Math.log(this.source.sample()), 1.0 / d2);
    }
}
