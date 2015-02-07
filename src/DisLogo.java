import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gennadiy on 07.02.2015.
 */
public class DisLogo {


    public BigInteger getPower(String p, String g, String h) {
        BigInteger mitmB = new BigInteger("2").pow(20);

        BigInteger hBigInt = new BigInteger(h);
        BigInteger pBigInt = new BigInteger(p);
        BigInteger gBigInt = new BigInteger(g);
        BigInteger gPowB = gBigInt.modPow(mitmB, pBigInt);
        Map<BigInteger, BigInteger> map = new HashMap<BigInteger, BigInteger>();

        for (BigInteger indexBigInt = new BigInteger("0"); indexBigInt.compareTo(mitmB) == -1; indexBigInt = indexBigInt.add(BigInteger.ONE)) {
            BigInteger power = gBigInt.modPow(indexBigInt, pBigInt);
            BigInteger invers = power.modInverse(pBigInt);
            BigInteger ratio = hBigInt.multiply(invers).mod(pBigInt);
            map.put(ratio, indexBigInt);


        }

        System.out.println("map is completed");

        for (BigInteger indexBigInt = new BigInteger("0"); indexBigInt.compareTo(mitmB) == -1; indexBigInt = indexBigInt.add(BigInteger.ONE)) {

            BigInteger power = gPowB.modPow(indexBigInt, pBigInt);
            if (map.containsKey(power)) {
                System.out.println("x1 : " + map.get(power));
                System.out.println("x0 : " + indexBigInt);
                System.out.println("x : " + (indexBigInt.multiply(mitmB).add(map.get(power))));
            }

        }


        return null;
    }
}
