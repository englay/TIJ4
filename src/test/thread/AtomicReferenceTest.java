package test.thread;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    /**
     * ��ط����б�
     * @see AtomicReference#compareAndSet(Object, Object) �Ա�����ֵ������1��ԭʼֵ������2���޸�Ŀ������
     * @see AtomicReference#getAndSet(Object) �����õ�Ŀ���޸�Ϊ���õĲ�����ֱ���޸ĳɹ�Ϊֹ�������޸�ǰ������
     */
    public final static AtomicReference <User>ATOMIC_REFERENCE = new AtomicReference<User>();
    
    
    public static void main(String []args) {
        final User old = new User("abc");
        ATOMIC_REFERENCE.set(old);
        for(int i = 0 ; i < 100 ; i++) {
            final int num = i;
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(Math.abs((int)(Math.random() * 100)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(ATOMIC_REFERENCE.compareAndSet(old, new User("ccc"))) {
                        System.out.println("�����̣߳�" + num + ",�һ�����������˶����޸ģ�"+ ATOMIC_REFERENCE.get().getName());
                    }
                }
            }.start();
        }
    }
    
//    private class User{
//        private String name = "u";
//
//        public User(String name){
//            this.name = name;
//        }
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//        
//    }
}


class User{
    private String name = "u";

    public User(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
