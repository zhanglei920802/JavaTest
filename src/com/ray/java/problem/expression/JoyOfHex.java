package com.ray.java.problem.expression;

/**
 * Created by 80107442 on 2017-01-02.
 */
public class JoyOfHex {
    public static void main(String[] args) {
        //输出 17777,1和l的区别
        String hexString = Long.toHexString(0x100000000L + 0xcafebabe);
        System.out.println(Integer.toHexString(0xcafebabe));
        System.out.println(Long.toHexString(0xcafebabeL));
        assert "0x1cafebabe".equals(hexString);//实际上cafebabe
        System.out.println(hexString);
    }
}
