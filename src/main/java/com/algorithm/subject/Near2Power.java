package com.algorithm.subject;

import org.junit.Assert;
import org.junit.Test;

public class Near2Power {

    /**
     * 已知n是正数
     * 返回大于等于n，最接近n的，2的某次方值
     * @param n
     * @return
     */
    public int tableSizeFor(int n) {
        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : n + 1;
    }

    @Test
    public void tableSizeForTest() {
        Assert.assertEquals(tableSizeFor(9), 16);
        Assert.assertEquals(tableSizeFor(33), 64);
    }

}
