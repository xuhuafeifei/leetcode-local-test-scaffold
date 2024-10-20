package com.leetcode;

import com.leetcode.common.Constant;
import com.leetcode.convert.*;
import com.leetcode.utils.PackageScanner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName: Converter
 * Package: com.leetcode
 * Description:
 * 参数转换器(string类型的参数转换)
 *
 * @Author: fgbg
 * @Create: 2024/10/19 - 3:00
 */
public class Converter {
    // class(string需要转换的类型) -> function(转换函数), 存储对应类型的转换方法
    private Map<Class, ConvertFunc> handlerMap;
    public Converter() {
        handlerMap = new HashMap<>();
        // 初始化
        try {
            // 从环境中获取扫描的包
            List<ConvertFunc> convertFunc = LeetCodeRunner.getEnv().getScanner(Constant.SCAN_CONVERT_PATH).getClasses()
                    .stream().filter(k -> k instanceof ConvertFunc)
                    .map(k -> (ConvertFunc) k)
                    .collect(Collectors.toList());
            for (ConvertFunc func : convertFunc) {
                handlerMap.put(func.getType(), func);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 转换
    Object doConvert(String arg, Class type) {
        return handlerMap.get(type).invoke(arg);
    }
}
