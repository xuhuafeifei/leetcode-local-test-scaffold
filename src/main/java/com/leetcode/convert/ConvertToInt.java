package com.leetcode.convert;

/**
 * ClassName: ConvertToInt
 * Package: com.leetcode.convert
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 4:24
 */
public class ConvertToInt extends ConvertFunc {

    @Override
    protected Class initType() {
        return int.class;
    }

    @Override
    public Object invoke(String arg) {
        return Integer.parseInt(arg);
    }
}
