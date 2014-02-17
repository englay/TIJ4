package test.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest2 {
    // ��ʽ��ʱ��
    private static SimpleDateFormat MY_SDF = new SimpleDateFormat("mm:ss");

    static class MyThread implements Runnable {
        @Override
        public void run() {
            // ��������
            try {
                Thread.sleep(1000);

                System.out.println("[" + MY_SDF.format(new Date()) + "]finished job!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // �����̳߳�
        ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(1);
        System.out.println("[" + MY_SDF.format(new Date()) + "]starting...");

        
        // ��ʼ�ӳ�2���ֻ����һ��
    //     schedulePool.schedule(new MyThread(), 2, TimeUnit.SECONDS);
        // ֻ����һ�Σ����Թرճأ���������ַ�ʽ��scheduleAtFixedRate/scheduleWithFixedDelay���򲻿��Թر��̳߳أ�
    //     schedulePool.shutdown();

        
        // ��ʼ�ӳ�2���ÿ���3������һ���߳�
        schedulePool.scheduleAtFixedRate(new MyThread(), 2, 3, TimeUnit.SECONDS);

        // ��ʼ�ӳ�2���ÿ���гɹ����ٵ�3������һ���߳�
//        schedulePool.scheduleWithFixedDelay(new MyThread(), 2, 3, TimeUnit.SECONDS);

    }
}