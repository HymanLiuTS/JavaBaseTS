package debugtool;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/10 18:32
 * @description：
 * @modified By：
 * @version: $
 */
public class ByteUtiles {

    public static int bytes2Int(byte[] b, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum = n + sum;
        }
        return sum;
    }

    public static byte[] int2Bytes(int value, int len) {
        System.out.println(Integer.toBinaryString(value));
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return b;
    }

    public static void main(String[] args) {
        byte[] b = int2Bytes(1, 8);
        int i = bytes2Int(b, 0, 8);
        System.out.println("End");
    }
}
