package com.jpeony.spring;

import org.springframework.stereotype.Service;

/**
 * @author yihonglei
 */
@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Override
    public void conference() {
        System.out.println("开会......");
    }

}
