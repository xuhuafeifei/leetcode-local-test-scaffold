package com.leetcode.convert;

/**
 * ClassName: ConvertToStrArray
 * Package: com.leetcode.convert
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 3:31
 */
public class ConvertToStrArray extends ConvertFunc {

    @Override
    protected Class initType() {
        return String[].class;
    }
    @Override
    public Object invoke(String arg) {
        String[] split = getArrayFromString(arg);
        for (int i = 0; i < split.length; i++) {
            split[i] = extractString(split[i], 1);
        }
        return split;
    }
}
