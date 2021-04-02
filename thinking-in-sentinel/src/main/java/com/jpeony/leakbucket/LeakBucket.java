package com.jpeony.leakbucket;

/**
 * 规定固定容量的桶, token 以固定速度往桶内填充, 当桶满时 token 不会被继续放入,
 * 每过来一个请求把 token 从桶中移除, 如果桶中没有 token 不能请求
 *
 * @author yihonglei
 */
public class LeakBucket {
    /**
     * 时间
     */
    private long time;
    /**
     * 总量
     */
    private Double total;
    /**
     * 水流出去的速度
     */
    private Double rate;
    /**
     * 当前总量
     */
    private Double nowSize;

    public boolean limit() {
        long now = System.currentTimeMillis();
        nowSize = Math.max(0, (nowSize - (now - time) * rate));
        time = now;
        if ((nowSize + 1) < total) {
            nowSize++;
            return true;
        } else {
            return false;
        }

    }
}