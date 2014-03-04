package test.thread;

public class PossibleReordering {
    
    private static int a = 0, b = 0;
    private static int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread() {
            @Override
            public void run() {
                a = 1;
                x = b;
            }
        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                b = 1;
                y = a;
            }
        };
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(x + "," + y);
    }
}
