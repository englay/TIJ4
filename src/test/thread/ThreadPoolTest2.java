package test.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest2 {
    // 格式化时间
    private static SimpleDateFormat MY_SDF = new SimpleDateFormat("mm:ss");

    static class MyThread implements Runnable {
        @Override
        public void run() {
            // 做点事情
            try {
                Thread.sleep(1000);

                System.out.println("[" + MY_SDF.format(new Date()) + "]finished job!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 创建线程池
        ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(1);
        System.out.println("[" + MY_SDF.format(new Date()) + "]starting...");

        
        // 初始延迟2秒后，只运行一次
    //     schedulePool.schedule(new MyThread(), 2, TimeUnit.SECONDS);
        // 只运行一次，可以关闭池；下面的两种方式（scheduleAtFixedRate/scheduleWithFixedDelay）则不可以关闭线程池！
    //     schedulePool.shutdown();

        
        // 初始延迟2秒后，每间隔3秒运行一次线程
        schedulePool.scheduleAtFixedRate(new MyThread(), 2, 3, TimeUnit.SECONDS);

        // 初始延迟2秒后，每运行成功后再等3秒运行一次线程
//        schedulePool.scheduleWithFixedDelay(new MyThread(), 2, 3, TimeUnit.SECONDS);

    }
}