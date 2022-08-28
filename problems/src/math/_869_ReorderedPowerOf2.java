package math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _869_ReorderedPowerOf2 {

    public boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i > 0; i <<= 1) {
            set.add(numToStr(i));
        }
        String converted = numToStr(n);
        return set.contains(converted);
    }

    private String numToStr(int i) {
        char[] c = String.valueOf(i).toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
