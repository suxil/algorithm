package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class SortEntity implements Compare<SortEntity> {

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(SortEntity sortEntity) {
        return this.num < sortEntity.getNum() ? -1 : (this.num > sortEntity.getNum() ? 1 : 0);
    }
}
