package com.leetcode;

import com.leetcode.common.Constant;

import java.lang.reflect.Method;

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
        Method coreMethod = null;
        String methodName = LeetCodeRunner.getEnv().getProperty(Constant.METHOD_NAME);
        // 匹配核心方法名称, 默认读取扫描得到的第一个方法, 如果配置文件给出的方法能够找到, 优先配置文件
        for (Method method : clazz.getMethods()) {
            // 不考虑重载
            if (method.getName().equals(methodName)) {
                coreMethod = method;
                break;
            }
        }
        if (coreMethod == null) coreMethod = clazz.getMethods()[0];

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
