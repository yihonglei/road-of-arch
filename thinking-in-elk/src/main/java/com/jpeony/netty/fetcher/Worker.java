package com.jpeony.netty.fetcher;

/**
 * @author yihonglei
 */
public class Worker {
    public void doWork() {
        Fetcher fetcher = new FetcherImpl();
        fetcher.fetchData(new FetchCallback() {
            @Override
            public void onData(String data) {
                System.out.println("Data received: " + data);
            }

            @Override
            public void onError(Throwable cause) {
                System.err.println("An error accour: " + cause.getMessage());
            }
        });
    }
}
