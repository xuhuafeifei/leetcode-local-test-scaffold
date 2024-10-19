package com.leetcode;

import java.util.List;

/**
 * ClassName: Template
 * Package: com.leetcode
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 4:18
 */
public class Template {
    public static void main(String[] args) throws Exception {
        CodeScanner codeScanner = new CodeScanner();
        InputParser inputParser = new InputParser();
        Recaller recaller = new Recaller();
        Outper outper = new Outper();

        while (true) {
            Object[] convertedArgs = inputParser.doParse(codeScanner);
            Object res = recaller.doCall(convertedArgs, codeScanner);
            outper.output(res);
        }
    }
}
