package test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest1 {
    
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
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        ExecutorService threadPool = Executors.newCachedThreadPool();

        
        // ���̳߳�����������
        for (int i = 0; i < 4; i++) {
            threadPool.execute(new MyThread("Thread" + i));
        }

        
        // �ر��̳߳�
        threadPool.shutdown();
    }
}
