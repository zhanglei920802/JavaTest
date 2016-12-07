package com.ray.java.effective.commonmethod;

/**
 * Created by 80107442 on 2016-12-07.
 */
public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(short areaCode, short prefix, short lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
//        return super.hashCode();
        int result = 17;
        result = result * 31 + areaCode;
        result = result * 31 + prefix;
        result = result * 31 + lineNumber;
        return result;
    }
}
