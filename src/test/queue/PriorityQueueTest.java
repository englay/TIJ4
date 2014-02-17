package test.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * http://www.importnew.com/6510.html
 * @author wb-dingyudong
 *
 */
public class PriorityQueueTest {
    
    public static void main(String args[]) {
 
        Queue<Item> items = new PriorityQueue<Item>();
        items.add(new Item("IPone", 900));
        items.add(new Item("IPad", 1200));
        items.add(new Item("Xbox", 300));
        items.add(new Item("Watch", 200));
 
        System.out.println("Order of items in PriorityQueue");
        System.out.println(items);
 
        System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
        System.out.println(items);
 
        System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
        System.out.println(items);
 
        System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
        System.out.println(items);
 
        //items.add(null); // null elements not allowed in PriorityQueue - NullPointerException
 
    }
 
    private static class Item implements Comparable<Item> {
 
        private String name;
        private int price;
 
        public Item(String name, int price) {
            this.name = name;
            this.price = price;
        }
 
        public String getName() {
            return name;
        }
 
        public int getPrice() {
            return price;
        }
 
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + price;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Item other = (Item) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (price != other.price)
                return false;
            return true;
        }
 
 
        @Override
        public int compareTo(Item i) {
            if (this.price == i.price) {
                return this.name.compareTo(i.name);
            }
 
            return this.price - i.price;
        }
 
        @Override
        public String toString() {
            return String.format("%s: $%d", name, price);
        }      
 
    }
}