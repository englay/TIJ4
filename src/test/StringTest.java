package test;

import java.lang.reflect.Field;

public class StringTest {

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        String s1 = "Hello World";  
        String s2 = "Hello World";  
        String s3 = s1.substring(6);  
        System.out.println(s1); // Hello World  
        System.out.println(s2); // Hello World  
        System.out.println(s3); // World  
         
        Field field = String.class.getDeclaredField("value");  
        field.setAccessible(true);  
        char[] value = (char[])field.get(s1);  
        value[6] = 'J';  
        value[7] = 'a';  
        value[8] = 'v';  
        value[9] = 'a';  
        value[10] = '!';  
         
        System.out.println(s1); // Hello Java!  
        System.out.println(s2); // Hello Java!  
        System.out.println(s3); 
        
        
    }
}
