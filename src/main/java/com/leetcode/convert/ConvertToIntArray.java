package com.leetcode.convert;

/**
 * ClassName: ConvertToIntArray
 * Package: com.leetcode.convert
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 3:28
 */
public class ConvertToIntArray extends ConvertFunc {
    @Override
    protected Class initType() {
        return int[].class;
    }
    @Override
    public Object invoke(String arg) {
        String[] split = getArrayFromString(arg);
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; ++i) {
            res[i] = Integer.parseInt(split[i]);
        }
        return res;
    }
}
