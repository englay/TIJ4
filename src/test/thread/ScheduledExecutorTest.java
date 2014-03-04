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
                    // ��������
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // �����Thread.currentThread().getName()������ȡ��ǰ�߳����ƣ��򲻻�õ����뵽�Ľ����
                    System.out.println(name + " said:" + i);
                }
            }
        }

        
        public static void main(String[] args) {
            // �����̳߳�
            ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

            
            // ���̳߳�����������
          //  for (int i = 0; i < 4; i++) {
                scheduledExecutor.schedule(new MyThread("Thread" + 1), 1, TimeUnit.SECONDS);
          //  }

            
            // �ر��̳߳�
          //  threadPool.shutdown();
        }
    }


