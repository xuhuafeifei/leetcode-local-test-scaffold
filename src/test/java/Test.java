import com.leetcode.CodeScanner;
import com.leetcode.CommonObject.ListNode;
import com.leetcode.CommonObject.TreeNode;
import com.leetcode.Converter;
import com.leetcode.LeetCodeRunner;
import com.leetcode.common.Constant;
import com.leetcode.common.Environment;
import com.leetcode.convert.*;
import com.leetcode.utils.PackageScanner;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Test
 * Package: com.leetcode
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 3:04
 */
public class Test {
    public static void main(String[] args) {
        // 测试代码扫描
        CodeScanner cs = new CodeScanner();
        cs.doScan();
        System.out.println(cs.getArgc());
        System.out.println(cs.getMethodName());
        for (Class type : cs.getTypes()) {
            System.out.println(type);
        }
    }

    @org.junit.Test
    public void testConvertFunc() {
        assert 123 == (Integer) new ConvertToInt().invoke("123");
        assert Arrays.equals(new int[]{1, 2, 3}, (int[]) new ConvertToIntArray().invoke("[1,2,3]"));
        assert "123".equals((String) new ConvertToStr().invoke("\"123\""));
        assert Arrays.equals(new String[]{"1", "2", "3"}, (String[]) new ConvertToStrArray().invoke("[\"1\",\"2\",\"3\"]"));
        assert Arrays.deepEquals(new String[][]{{"1", "2"}, {"3", "4"}}, (String[][]) new ConvertToTwoStrArray().invoke("[[\"1\",\"2\"],[\"3\",\"4\"]]"));
        assert Arrays.deepEquals(new int[][]{{1, 2}, {3, 4}}, (int[][]) new ConvertToTwoIntArray().invoke("[[1,2],[3,4]]"));
    }

    @org.junit.Test
    public void instanceOfTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<Object> classes = new PackageScanner("com.leetcode.convert").getClasses();
        for (Object aClass : classes) {
            System.out.println(aClass);
        }
    }

    @org.junit.Test
    public void testConvert() throws Exception {
        LeetCodeRunner.main(new String[]{});
        Converter converter = new Converter();
    }

    @org.junit.Test
    public void testConvertToTreeNode() {
        ConvertToTreeNode convertToTreeNode = new ConvertToTreeNode();
//        TreeNode node = (TreeNode) convertToTreeNode.invoke("[1,null,3,2,4,null,null,null,5]");
        TreeNode node = (TreeNode) convertToTreeNode.invoke("[2,null,3,2,null,1]");
        node.print();
    }

    @org.junit.Test
    public void testConvertToListNode() {
        ConvertToListNode convertToListNode = new ConvertToListNode();
        ListNode node = (ListNode) convertToListNode.invoke("[1,2,3,4,5]");
        node.print();
    }

    @org.junit.Test
    public void testClassFor() throws Exception {
        Class<?> aClass = Class.forName("com.leetcode.Solution");
        Object o = aClass.newInstance();
        System.out.println(o);
    }

    @org.junit.Test
    public void testEnviroment() {
        Environment environment = new Environment();
        assert "com.leetcode.Solution".equals(environment.getProperty(Constant.CORE_CODE));
        assert "com.leetcode.convert".equals(environment.getProperty(Constant.SCAN_CONVERT_PATH));
        PackageScanner scanner = environment.getScanner("com.leetcode.convert");
        for (Object aClass : scanner.getClasses()) {
            System.out.println(aClass.getClass());
        }
    }
}
