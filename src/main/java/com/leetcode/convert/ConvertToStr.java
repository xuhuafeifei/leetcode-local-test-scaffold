package com.leetcode.convert;

/**
 * ClassName: ConvertToStr
 * Package: com.leetcode.convert
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 4:41
 */
public class ConvertToStr extends ConvertFunc {
    @Override
    protected Class initType() {
        return String.class;
    }
    /**
     * 去除leetcode字符串自带的引号
     * @param arg
     * @return
     */
    @Override
    public Object invoke(String arg) {
        return extractString(arg, 1);
    }
}
