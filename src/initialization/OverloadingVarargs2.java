//: initialization/OverloadingVarargs2.java
package initialization; /* Added by Eclipse.py */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
// {CompileTimeError} (Won't compile)

public class OverloadingVarargs2 {
  static void f(float i, Character... args) {
    System.out.println("first");
  }
  static void f(Character... args) {
    System.out.print("second");
  }
  public static void main(String[] args) {
    f(1, 'a');
  //  ('a', 'b');
/*    xukun compile error  
    f('a', 'b');*/
 //   Arrays.asList(a);
    hasSamePhoneNumber2((Customer[]) Arrays.asList(new Customer(1L),new Customer(11L),new Customer(11L)).toArray());
    
  }
  
  public static boolean hasSamePhoneNumber2(Customer[] customers) {
      if (null == customers || customers.length < 1)
          return Boolean.FALSE;

      TreeSet<Customer> ts = new TreeSet<Customer>(new Comparator<Customer>() {
          public int compare(Customer o1, Customer o2) {
              return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
          }
      });
      ts.addAll(Arrays.asList(customers));

      Collections.addAll(new ArrayList(), 1,null);
      List list = new LinkedList();
      list.add(1);
      list.add(2);
      list.add(3);
      return customers.length == ts.size() ? Boolean.FALSE : Boolean.TRUE;
  }
} ///:~

class Customer {
    
    public Customer(Long phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    private Long phoneNumber;

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}