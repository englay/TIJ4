package test.pattern;

public class JobSeeker implements Observer {
    
    private String name;
 
    public JobSeeker(String name){
        this.name = name;
    }
    
    @Override
    public void notify(Subject s) {
        System.out.println(this.name + " got notified!");
        //print job list
        System.out.println(s);
    }
    
        public static void main(String[] args) {
            Hunter hh = new Hunter();
            hh.registerObserver(new JobSeeker("Mike"));
            hh.registerObserver(new JobSeeker("Chris"));
            hh.registerObserver(new JobSeeker("Jeff"));
     
            //ÿ�����һ����job�������ҹ����˶����Եõ�֪ͨ��
            hh.addJob(new Job("Google Job"));
            System.gc();
            hh.addJob(new Job("Yahoo Job"));
        }
}