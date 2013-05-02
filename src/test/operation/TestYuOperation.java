package test.operation;

public class TestYuOperation {
    private int options;

    public boolean HasOption(int option) {
        return (this.options & option) == option;
    }

    public void SetOption(int option, boolean add) {
        if (add)
            this.options |= option;// add flag
        else
            this.options &= ~option;// remove flag
    }

    public static void main(String[] args) {
        int a = 1 << 1;
        int b = 1 << 2;
        System.out.println(a + "Binary String:" + Integer.toBinaryString(a));
        System.out.println(b + "Binary String:" + Integer.toBinaryString(b));
        TestYuOperation test = new TestYuOperation();
        System.out.println("add flag  a & b ");
        test.SetOption(a, true);
        test.SetOption(b, true);
        System.out.println("Is has flag a:" + test.HasOption(a));
        System.out.println("Is has flag b:" + test.HasOption(b));
        System.out.println("remove flagb");
        test.SetOption(b, false);
        System.out.println("Is has flag b:" + test.HasOption(b));
    }

    public int getOptions() {
        return options;
    }

    public void setOptions(int options) {
        this.options = options;
    }

}
