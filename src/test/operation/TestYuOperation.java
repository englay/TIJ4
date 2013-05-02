package test.operation;

public class TestYuOperation {
    private int options;

    public boolean HasOption(int option) {
        return (this.options & option) == option;
    }

    public void SetOption(int option, boolean add) {
        if (add)
            this.options |= option;// ��ӱ�־λ
        else
            this.options &= ~option;// �Ƴ���־λ
    }

    public static void main(String[] args) {
        int a = 1 << 1;
        int b = 1 << 2;
        System.out.println(a + "�Ķ�����:" + Integer.toBinaryString(a));
        System.out.println(b + "�Ķ�����:" + Integer.toBinaryString(b));
        TestYuOperation test = new TestYuOperation();
        System.out.println("��ӱ�־λ  a �� b ");
        test.SetOption(a, true);
        test.SetOption(b, true);
        System.out.println("�Ƿ����a:" + test.HasOption(a));
        System.out.println("�Ƿ����b:" + test.HasOption(b));
        System.out.println("�Ƴ���־λb");
        test.SetOption(b, false);
        System.out.println("�Ƿ����b:" + test.HasOption(b));
    }

    public int getOptions() {
        return options;
    }

    public void setOptions(int options) {
        this.options = options;
    }

}
