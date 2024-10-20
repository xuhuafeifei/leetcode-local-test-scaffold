package com.leetcode;

import com.leetcode.common.Environment;

/**
 * ClassName: Template
 * Package: com.leetcode
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 4:18
 */
public class LeetCodeRunner {
    private static Environment env;

    public static void main(String[] args) throws Exception {
        run();
    }

    public static void run() throws Exception {
        // 环境初始化
        LeetCodeRunner.env = new Environment();
        // 模块初始化
        CodeScanner codeScanner = new CodeScanner();
        InputParser inputParser = new InputParser();
        Recaller recaller = new Recaller();
        Outper outper = new Outper();

        // 项目启动
        while (true) {
            Object[] convertedArgs = inputParser.doParse(codeScanner);
            Object res = recaller.doCall(convertedArgs, codeScanner);
            outper.output(res);
        }
    }

    public static Environment getEnv() {
        return env;
    }
}
