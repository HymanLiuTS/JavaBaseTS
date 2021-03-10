package debugtool;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/10 18:10
 * @description： 修改class文件，暂时只提供修改常量池常量的功能
 * @modified By：
 * @version: $
 */
public class ClassModifier {
    /**
     * create by: Hyman
     * description: class文件中常量池的起始偏移
     * create time: 2021/3/10
     */
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /**
     * <p> CONSTANT_Utf8_INFO常量的tag标志
     **/
    private static final int CONSTANT_Utf8_INFO = 1;

    private static final int[] CONSTANT_ITEM_LENGTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};

    private static final int u1 = 1;
    private static final int u2 = 2;

    private byte[] classByte;

    public ClassModifier(byte[] classByte) {
        this.classByte = classByte;
    }

    public byte[] modifyUTF8Constant(String oldStr, String newStr) {
        return null;
    }

    public int getConstantPoolCount() {
        return 0;
    }

}
