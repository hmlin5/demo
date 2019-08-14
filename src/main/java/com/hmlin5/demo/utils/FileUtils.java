package com.hmlin5.demo.utils;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.Random;

public class FileUtils {

         //编码方式
        private static final String ENCODING = "gbk";
        private static final String FILENAME = "random_word.txt";

        /**
         * 获取文件的行
         *
         * @param fileName
         *            文件名称
         * @return List<String>
         */
        public static String getContentByLine(String fileName) {
            StringBuffer lines = new StringBuffer();
            InputStreamReader read = null;
            BufferedReader bufferedReader = null;
            try {
                String configPath = FileUtils.class.getClassLoader().getResource(fileName).getPath();
                // 处理文件路径中空格问题
                configPath = configPath.replaceAll("%20", " ");
                File file = new File(configPath);
                // 判断文件是否存在
                if (file.isFile() && file.exists()) {
                    read = new InputStreamReader(new FileInputStream(file), ENCODING);
                    bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        if (lineTxt == null || lineTxt.length() == 0) {
                            continue;
                        }
                        lines.append(lineTxt);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (read != null) {
                        read.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return lines.toString();
        }




    /**
     * 获取文件的随机行
     *
     * @return List<String>
     */
    public static String getContentByRandomLine() {
        InputStreamReader read = null;
        BufferedReader bufferedReader = null;
        String randomLine = "";
        try {
            String configPath = FileUtils.class.getClassLoader().getResource(FILENAME).getPath();
            // 处理文件路径中空格问题
            configPath = configPath.replaceAll("%20", " ");
            File file = new File(configPath);
            // 判断文件是否存在
            if (file.isFile() && file.exists()) {
                read = new InputStreamReader(new FileInputStream(file), ENCODING);
                bufferedReader = new BufferedReader(read);
                bufferedReader.mark((int)file.length());
                String lineTxt = null;
                int totalLineNum = 0;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    /*if (lineTxt == null || lineTxt.length() == 0) {
                        continue;
                    }*/
                    totalLineNum++;
                }
                if (totalLineNum > 0) {
                    Random random = new Random();
                    int chooseLineNum = random.nextInt(totalLineNum) + 1;
                    bufferedReader.reset();
                    int currentLineNum = 1;
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        if (currentLineNum == chooseLineNum) {
                            randomLine = lineTxt;
                        }
                        currentLineNum++;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (read != null) {
                    read.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return randomLine;
    }
}

