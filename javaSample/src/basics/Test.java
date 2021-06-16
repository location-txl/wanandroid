package basics;

public class Test {



    public static void binaryToDecimal(int n) {
        int index  = 0;
        for (int i = 31; i >= 0; i--) {

            System.out.print(n >>> i & 1);
            index++;
            if (index == 4) {
                System.out.print(":");
                index = 0;
            }
        }
        System.out.println("\r\n");
    }
    @org.junit.Test
    public void testInt(){
        System.out.println(~2);
        binaryToDecimal(2);
        binaryToDecimal(~2);
        int a  = 1;
        binaryToDecimal(-4);
        binaryToDecimal(-4 >> 1);
        binaryToDecimal(4);
        binaryToDecimal(4 >> 1);
        binaryToDecimal(1 << 30);
        binaryToDecimal(2 << 30);
        binaryToDecimal(3 << 30);
        System.out.println("mode mask");
        final int MODE_MASK  = 0x3 << 30;
        binaryToDecimal(MODE_MASK);
        binaryToDecimal(~MODE_MASK);
        System.out.println("mode mask start");
        binaryToDecimal(1);
        binaryToDecimal(1 & ~MODE_MASK);
        binaryToDecimal((2 & ~MODE_MASK)  | ((1 << 30) & MODE_MASK));
        System.out.println(a << 2); // 4
        System.out.println(a << 3); // 8

    }
}
