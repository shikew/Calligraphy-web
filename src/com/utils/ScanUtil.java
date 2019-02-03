package com.utils;

import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
/**
 * ɨ�蹤����,����ɨ��ָ���������������,�����Ӱ�
 */
public class ScanUtil {
    /**
     * ��������������
     */
    private static List<String> list = new ArrayList<String>();

    /**
     * ɨ��
     * @param packagePath
     * @return
     */
    public static List<String> scanPackage(String packages) {
        String[] packs = packages.split(",");
        for (String pack : packs) {
            String path = toPackagePath(pack);
            try {
                toClassPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * ��·��ת���ɰ���
     * @param packagePath
     * @return
     */
    private static String toPackagePath(String packagePath) {
        packagePath = packagePath.replace(".", File.separator);
        return getRealPath()+packagePath;
    }
    /**
     * ����Ŀ¼����������List��
     * @param classPath
     * @throws Exception
     */
    private static void toClassPath(String classPath) throws Exception {
        classPath = URLDecoder.decode(classPath, "utf-8");
        // listFiles()��ȡ·���µ������ļ����ļ��У����ص���һ��File[]����
        File[] fs = new File(classPath).listFiles();
        if (fs != null) {
            for (File file : fs) {
                // file.isDirectory()�����жϵ�ǰ���file�����Ƿ���һ���ļ���
                if (file.isDirectory()) {
                    // ��ȡ�ļ��еľ���·��
                    // �ݹ����
                    toClassPath(file.getAbsolutePath());
                } else {
                    // ���ļ���ת������������
                    String path = toClassName(file);
                    if (path != null) 
                        list.add(path);
                }
            }
        }
    }

    /**
     *  ���ļ���ת������������
     * @param file
     * @return
     * @throws Exception
     */
    private static String toClassName(File file) throws Exception {
        if (file.getName().endsWith(".class")) {
            String path = URLDecoder.decode(getRealPath(), "utf-8");
            path = new File(path).getAbsolutePath() + File.separator;
            path = file.getAbsolutePath().substring(path.length(),
                    file.getAbsolutePath().length());
            String className = path.replace(File.separator, ".");
            className = className.substring(0, className.length() - 6);
            return className;
        } else {
            return null;
        }
    }
    
    /**
     * ��ȡ��ǰ��Ŀ��classesĿ¼
     * @return
     */
    private static String getRealPath(){
        return ScanUtil.class.getClassLoader().getResource("").getPath();
    }
}