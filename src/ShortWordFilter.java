public class ShortWordFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof String) {
            String word = (String) x;
            return word.length() < 5;
        }
        return false;
    }
}