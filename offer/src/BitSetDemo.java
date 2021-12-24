import java.util.BitSet;

public class BitSetDemo {

    public static void containChars(String str) {
        BitSet used = new BitSet();
        for (int i = 0; i < str.length(); i++) {
            used.set(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = used.size();
        System.out.print(size);
        for (int i = 0; i < size; i++) {
            if (used.get(i)) {
                sb.append((char) i);
            }
        }
        sb.append("]");
        System.out.printf(sb.toString());
    }

    public static void sortArray() {
        int[] array = new int[]{423,700,9999,2323,356,6400,1,2,3,2,2,2,2};
        BitSet bitSet = new BitSet();
        System.out.println("BitSet size:"+bitSet.size());

        for (int elem : array) {
            bitSet.set(elem);
        }

        System.out.println("BitSet length:"+bitSet.length());
        System.out.println("BitSet cardinality:"+bitSet.cardinality());

        // max + 1
        int length = bitSet.length();
        int count = 0;
        int[] sorted = new int[bitSet.cardinality()];
        for (int i = bitSet.nextSetBit(0);
             i > 0;
             i = bitSet.nextSetBit(i + 1)) {
            sorted[count++] = i;
        }

        System.out.println("After ordering:");
        for (int elem:sorted) {
            System.out.print(elem + "\t");
        }
    }

    public static void main(String[] args) {
        containChars("How do you do?");
        sortArray();
    }
}
