package com.leetcode.convert;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: ConvertFunc
 * Package: com.leetcode.convert
 * Description:
 * 转换方法
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 3:27
 */
public abstract class ConvertFunc {
    public Class type;

    public ConvertFunc() {
        this.type = initType();
    }

    protected abstract Class initType();

    /**
     * 提取字符串
     * @param arg
     * @param offset
     * @return
     */
    protected String extractString(String arg, int offset) {
        return arg.substring(offset, arg.length() - offset);
    }

    /**
     * 获取二维数组
     * @param arg
     * @return
     */
    protected String[][] getTwoDimArray(String arg) {
        // "[[1,2,3], [4,5,6]]" -> int[][]
        String subStr = extractString(arg, 1); // [1,2,3],[4,5,6]
        List<String> split = new LinkedList<>();
        int start = 0, end = 0;
        for (int i = 0; i < subStr.length(); ++i) {
            char c = subStr.charAt(i);
            if (c == '[') {
                start = i;
            }else if (c == ']') {
                end = i;
                split.add(subStr.substring(start + 1, end));
            }
        }
        int m = split.size(), n = split.get(0).split(",").length;
        String[][] ans = new String[m][n];
        for (int i = 0; i < m; ++i) {
            ans[i] = split.get(i).split(",");
        }
        return ans;
    }

    /**
     * 从leetcode字符串中提取数组
     * "[1,2,3]"返回String[]{1,2,3}
     * @param arg
     * @return
     */
    protected String[] getArrayFromString(String arg) {
        String substring = extractString(arg, 1);
        String[] split = substring.split(",");
        return split;
    }

    public abstract Object invoke(String arg);

    public Class getType() {return this.type;}
}
