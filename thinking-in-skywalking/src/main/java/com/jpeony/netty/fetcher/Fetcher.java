package com.jpeony.netty.fetcher;

/**
 * @author yihonglei
 */
public interface Fetcher {
    void fetchData(FetchCallback callback);
}
