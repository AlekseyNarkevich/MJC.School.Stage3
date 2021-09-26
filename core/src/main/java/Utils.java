public class Utils {
    boolean isAllPositiveNumbers(String... str) {
        StringUtils stringUtils = new StringUtils();

        for (String s : str) {
            if (!stringUtils.isPositiveNumber(s)) {
                return false;
            }
        }
        return true;
    }
}
