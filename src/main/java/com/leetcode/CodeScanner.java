package com.leetcode;

import java.lang.reflect.Method;
import java.util.List;

/**
 * ClassName: CodeScanner
 * Package: com.leetcode
 * Description:
 * 扫描核心代码
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 2:50
 */
public class CodeScanner {
    private int argc;
    private Class[] types;
    private String methodName;
    private Class coreClass;

    public CodeScanner() {
        doScan();
    }

    // 扫描核心代码
    public void doScan() {
        Class<Solution> clazz = Solution.class;
        Method coreMethod = clazz.getMethods()[0];
        this.methodName = coreMethod.getName();
        this.types = coreMethod.getParameterTypes();
        this.argc = coreMethod.getParameterCount();
        this.coreClass = clazz;
    }

    public int getArgc() {
        return argc;
    }

    public Class[] getTypes() {
        return types;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class getCoreClass(){
        return coreClass;
    }
}
