package ps;

//https://leetcode.com/problems/product-of-the-last-k-numbers/

import java.util.ArrayList;
import java.util.List;

public class _1352_ProductOfTheLastKNumbers {

    public static class ProductOfNumbers {

        List<Integer> product;

        public ProductOfNumbers() {
            product = new ArrayList<>();
        }

        public void add(int num) {
            if (num == 0) {
                product.clear();
            } else if (product.isEmpty()) {
                product.add(num);
            } else {
                product.add(product.get(product.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            if (product.size() < k) {
                return 0;
            }
            int lastIdx = product.size() - 1;
            int last = product.get(product.size() - 1);
            if (product.size() == k) {
                return last;
            }

            int prevIdx = lastIdx - k;
            int prev = product.get(prevIdx);
            return last / prev;
        }
    }
}
