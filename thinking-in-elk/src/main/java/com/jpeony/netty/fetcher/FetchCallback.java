package com.jpeony.netty.fetcher;

/**
 * @author yihonglei
 */
public interface FetchCallback {
    void onData(String data);

    void onError(Throwable cause);
}
