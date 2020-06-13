package com.study.studythread.LockStudy;

/**
 * @author jiayq
 * @Date 2020-06-10
 */
public class People {

    private Long sum = 0L;

    private static Long all = 0L;

    public People() {
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Long getAll() {
        return all;
    }

    public void setAll(Long all) {
        People.all = all;
    }
}
