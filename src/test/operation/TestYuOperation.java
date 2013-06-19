package test.operation;

/**
 * 
 * @author yudong
 *
 */
public class TestYuOperation {
    
    /**
     * The flags used to stores 32 boolean flags.
     * Because the flags is a integer , it's byte size is 32.
     * Every byte can be used as a boolean flag.
     * 0 is false,1 is true.
     */
    private int flags;

    /**
     * if flags has flag return true, then return false.
     * Exp: flag = 4(0100),flags = 6(0110);
     *   4 & 6 
     * = 0100 & 0110 
     * = 0100 
     * = 4 == 4 return true.
     * @param flag
     * @return boolean
     */
    public boolean IsHasFlag(int flag) {
        return (this.flags & flag) == flag;
    }
    
    /**
     * If add is true, add flag to flags, otherwise remove the flag from the flags.
     * 
     * Note:
     * A compound assignment expression of the form 
     * E1 op= E2 is equivalent to E1 = (T)((E1) op (E2)), 
     * where T is the type of E1, except that E1 is evaluated only once.
       So a &= b; is equivalent to a = a & b;
     * @param flag
     * @param add a boolean
     */
    public void SetFlag(int flag, boolean add) {
        if (add)
            this.flags |= flag;//add flag
        else
            this.flags &= ~flag;//remove flag
    }

    public static void main(String[] args) {
        int a = 1 << 1;
        int b = 1 << 2;
        System.out.println(a + "Binary String:" + Integer.toBinaryString(a));
        System.out.println(b + "Binary String:" + Integer.toBinaryString(b));
        TestYuOperation test = new TestYuOperation();
        System.out.println("add flag  a & b ");
        test.SetFlag(a, true);
        test.SetFlag(b, true);
        System.out.println("flags:" + Integer.toBinaryString(test.flags));
        System.out.println("Is has flag a:" + test.IsHasFlag(a));
        System.out.println("Is has flag b:" + test.IsHasFlag(b));
        System.out.println("remove flagb");
        test.SetFlag(b, false);
        System.out.println("flags:" + Integer.toBinaryString(test.flags));
        System.out.println("Is has flag b:" + test.IsHasFlag(b));
    }
    

    public int getflags() {
        return flags;
    }

    public void setflags(int flags) {
        this.flags = flags;
    }

}
