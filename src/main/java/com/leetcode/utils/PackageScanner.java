package com.leetcode.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PackageScanner {
    private List<Object> classes;
    private String packagePath = null;

    /*
     * 无参构造方法，内部调用带参的构造方法。
     * 
     * @throw classNotFound
     * 
     */
    public PackageScanner() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this("");
    }

    /*
     * 实现，调用fileScanner进行目录扫描和加载
     * 
     * @param String 传入需要扫描的包
     * 
     * @throw classNotFound
     */
    public PackageScanner(String basePackage) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        packagePath = System.getProperty("user.dir") + "\\src\\main\\java\\";
        String filePath = packagePath + basePackage.replace('.', '\\');
        classes = new ArrayList<Object>();
        fileScanner(new File(filePath));
    }

    private void fileScanner(File file) throws ClassNotFoundException, IllegalAccessException {
        if (file.isFile() && file.getName().lastIndexOf(".java") == file.getName().length() - 5) {//5是".java"的长度
            String filePath = file.getAbsolutePath();
            String qualifiedName = filePath.substring(packagePath.length(), filePath.length() - 5).replace('\\', '.');
            try {
                Object o = Class.forName(qualifiedName).newInstance();
                classes.add(o);
            } catch (InstantiationException e) {
                System.out.println("class " + qualifiedName + " is abstract, can not instance");
            }
        } else if (file.isDirectory()) {
            for (File f : file.listFiles())
                fileScanner(f);
        }
    }

    /*
     * 得到加载到的类对象的List,返回的是ArrayList
     */
    public List<Object> getClasses() {
        return this.classes;
    }
}