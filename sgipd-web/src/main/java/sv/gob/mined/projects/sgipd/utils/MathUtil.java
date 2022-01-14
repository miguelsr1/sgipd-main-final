package sv.gob.mined.projects.sgipd.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil {

    public static final int SCALE=2;

    public static double roundDouble(double d) {

        BigDecimal bigDecimal = new BigDecimal(d);

        bigDecimal = bigDecimal.setScale(SCALE, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static BigDecimal roundBigDecimal(BigDecimal bigDecimal) {
        return bigDecimal.setScale(SCALE, RoundingMode.HALF_UP);
    }
}
