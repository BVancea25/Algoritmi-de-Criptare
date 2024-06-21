import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DiscreteLogarithm {

    private BigInteger base;
    private BigInteger modulo;
    private BigInteger target;

    public DiscreteLogarithm(){}
    public BigInteger discreteLog() {
        BigInteger m = sqrt(modulo).add(BigInteger.ONE);
        Map<BigInteger, BigInteger> babySteps = new HashMap<>();

        // Computing baby steps
        BigInteger babyStep = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(m) < 0; i = i.add(BigInteger.ONE)) {
            babySteps.put(babyStep, i);
            babyStep = babyStep.multiply(base).mod(modulo);
        }

        // Computing giant steps
        BigInteger giantStep = target;
        BigInteger inverseBasePowM = base.modPow(m.negate(), modulo);
        for (BigInteger j = BigInteger.ZERO; j.compareTo(m) < 0; j = j.add(BigInteger.ONE)) {
            if (babySteps.containsKey(giantStep)) {
                BigInteger babyIndex = babySteps.get(giantStep);
                return j.multiply(m).add(babyIndex);
            }
            giantStep = giantStep.multiply(inverseBasePowM).mod(modulo);
        }

        return null;
    }


    private BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = n.shiftRight(5).add(BigInteger.valueOf(8));
        while (b.compareTo(a) >= 0) {
            BigInteger mid = a.add(b).shiftRight(1);
            if (mid.multiply(mid).compareTo(n) > 0)
                b = mid.subtract(BigInteger.ONE);
            else
                a = mid.add(BigInteger.ONE);
        }
        return a.subtract(BigInteger.ONE);
    }






    public void setModulo(BigInteger modulo) {
        this.modulo = modulo;
    }



    public void setBase(BigInteger base) {
        this.base = base;
    }

    public void setTarget(BigInteger target) {
        this.target = target;
    }
}
