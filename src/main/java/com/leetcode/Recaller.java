package com.leetcode;

import java.lang.reflect.Method;
import java.util.List;

/**
 * ClassName: Recaller
 * Package: com.leetcode
 * Description:
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 2:52
 */
public class Recaller {

    /**
     * 实例化Solution, 调用方法
     * @param args
     * @param codeScanner
     * @return
     * @throws Exception
     */
    public Object doCall(Object[] args, CodeScanner codeScanner) throws Exception {
        String methodName = codeScanner.getMethodName();
        Class coreClass = codeScanner.getCoreClass();
        // 创建solution调用的核心方法
        Method coreMethod = coreClass.getMethod(methodName, codeScanner.getTypes());
        // 触发核心方法
        Object ans = coreMethod.invoke(coreClass.newInstance(), args);
        return ans;
    }
}
