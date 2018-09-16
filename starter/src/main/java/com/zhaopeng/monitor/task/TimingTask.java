package com.zhaopeng.monitor.task;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.zhaopeng.monitor.api.MainController;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimingTask implements InitializingBean {

    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);


    @Autowired
    private MainController mainController;

    private  Random random= new Random();

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println();

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                int radom=random.nextInt(100);

                System.out.println("running "+ radom);
                mainController.index(radom);
            }
        }, 1, 300, TimeUnit.MILLISECONDS);
    }
}
