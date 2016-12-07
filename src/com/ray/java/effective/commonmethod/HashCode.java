package com.ray.java.effective.commonmethod;

public class HashCode {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            int left = 31 * i;
            int right = (i << 5) - i;
            System.out.println(String.format("left[%d]==right[%d]?%s", left, right, (left == right)));
            assert left == right;
        }
    }
}
