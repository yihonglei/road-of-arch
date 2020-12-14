package com.jpeony.design.patterns.decorator.iodecorator;

import java.io.*;

/**
 * @author yihonglei
 */
public class InputTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in =
                    new LowerCaseInputStream(// 自定义装饰者
                            new BufferedInputStream( // API自带的装饰者
                                    new FileInputStream("D:\\test.text")));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
