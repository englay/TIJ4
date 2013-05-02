package test.operation;

public class TestYuOperation {
    private int options;

    public boolean HasOption(int option) {
        return (this.options & option) == option;
    }

    public void SetOption(int option, boolean add) {
        if (add)
            this.options |= option;// 添加标志位
        else
            this.options &= ~option;// 移除标志位
    }

    public static void main(String[] args) {
        int a = 1 << 1;
        int b = 1 << 2;
        System.out.println(a + "的二进制:" + Integer.toBinaryString(a));
        System.out.println(b + "的二进制:" + Integer.toBinaryString(b));
        TestYuOperation test = new TestYuOperation();
        System.out.println("添加标志位  a 和 b ");
        test.SetOption(a, true);
        test.SetOption(b, true);
        System.out.println("是否存在a:" + test.HasOption(a));
        System.out.println("是否存在b:" + test.HasOption(b));
        System.out.println("移除标志位b");
        test.SetOption(b, false);
        System.out.println("是否存在b:" + test.HasOption(b));
    }

    public int getOptions() {
        return options;
    }

    public void setOptions(int options) {
        this.options = options;
    }

}
