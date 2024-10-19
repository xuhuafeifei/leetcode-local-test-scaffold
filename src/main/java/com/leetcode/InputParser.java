package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: InputParser
 * Package: com.leetcode
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 2:51
 */
public class InputParser {
    private Scanner sc;
    private Converter converter;

    public InputParser() {
        this.sc = new Scanner(System.in);
        this.converter = new Converter();
    }

    // 解析输入
    public Object[] doParse(CodeScanner codeScanner) {
        int argc = codeScanner.getArgc();
        Class[] types = codeScanner.getTypes();
        Object[] ans = new Object[argc];
        // 读取输入
        for (int i = 0; i < argc; ++i) {
            String arg = sc.next();
            Class type = types[i];
            // convert by type
            Object res = this.converter.doConvert(arg, type);
            ans[i] = res;
        }
        return ans;
    }
}
