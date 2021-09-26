import static org.apache.commons.lang3.math.NumberUtils.isCreatable;
import static org.apache.commons.lang3.math.NumberUtils.createNumber;

public class StringUtils {

    public boolean isPositiveNumber(String string) {

        if (isCreatable(string)) {
            Number number = createNumber(string);
            return number.doubleValue() > 0;
        }

        throw new RuntimeException("Can't convert to number");
    }

}
