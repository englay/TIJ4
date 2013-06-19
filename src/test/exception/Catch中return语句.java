package test.exception;

public class Catch中return语句 {
    private static int a;
    
    public static int main() {
        System.out.println("没有参数的main方法");
        try{
            a=4/0;
        }catch(Exception e){
            System.out.println("在return中的a:!"+a);    
            return ++a;
        }
        finally{
            System.out.println("在finally中成功捕获异常!"+a);           
            a++;
            System.out.println("在finally中成功捕获异常!"+a);           
        }
        System.out.println("成功捕获异常!"+a);
        return 1;
    }
    public static void main(String[] string) {
        System.out.println(main());
        System.out.println("此时a的值为:"+a);
    }

}
