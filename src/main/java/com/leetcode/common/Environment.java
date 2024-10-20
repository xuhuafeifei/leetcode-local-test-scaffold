package com.leetcode.common;

import com.leetcode.utils.PackageScanner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.leetcode.common.Constant.*;

public class Environment {
    // 存储配置池
    private Map<String, String> propertiesPool;
    // 存储扫描对象池
    private Map<String, PackageScanner> scannerMap;

    public Environment() {
        readProperty();
        loadScanObject();
    }

    public String getProperty(String key) {
        return propertiesPool.get(key);
    }

    public PackageScanner getScanner(String key) {
        return scannerMap.get(getProperty(key));
    }

    /**
     * 加载扫描对象
     */
    private void loadScanObject() {
        this.scannerMap = new HashMap<>();
        // 加载扫描路径
        this.propertiesPool.forEach((key, value) -> {
            if (key.startsWith("scan_")) {
                try {
                    PackageScanner scanner = new PackageScanner(value);
                    scannerMap.put(value, scanner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 加载配置对象
     */
    private void readProperty() {
        this.propertiesPool = new HashMap<>();
        // 创建Properties对象
        Properties prop = new Properties();

        // 通过类加载器获取资源文件流
        try (
                InputStream input = Environment.class.getClassLoader().getResourceAsStream(Constant.CONFIG_FILE_NAME);
                ) {
            prop.load(input);
            Enumeration<?> pNames = prop.propertyNames();
            while (pNames.hasMoreElements()) {
                String key = (String) pNames.nextElement();
                String value = prop.getProperty(key);
                this.propertiesPool.put(key, value);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
