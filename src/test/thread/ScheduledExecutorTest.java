package test.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {
        
        static class MyThread implements Runnable {
            private String name;
            
            public MyThread(String name){
                this.name = name;
            }

            
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    // 做点事情
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 如果用Thread.currentThread().getName()方法获取当前线程名称，则不会得到你想到的结果。
                    System.out.println(name + " said:" + i);
                }
            }
        }

        
        public static void main(String[] args) {
            // 创建线程池
            ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

            
            // 向线程池里面扔任务
          //  for (int i = 0; i < 4; i++) {
                scheduledExecutor.schedule(new MyThread("Thread" + 1), 1, TimeUnit.SECONDS);
          //  }

            
            // 关闭线程池
          //  threadPool.shutdown();
        }
    }


