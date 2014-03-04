package test.thread;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    /**
     * 相关方法列表
     * @see AtomicReference#compareAndSet(Object, Object) 对比设置值，参数1：原始值，参数2：修改目标引用
     * @see AtomicReference#getAndSet(Object) 将引用的目标修改为设置的参数，直到修改成功为止，返回修改前的引用
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
                        System.out.println("我是线程：" + num + ",我获得了锁进行了对象修改！"+ ATOMIC_REFERENCE.get().getName());
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
