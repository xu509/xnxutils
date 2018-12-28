package com.xuningxin.utils.file;

import java.io.*;

/**
 * Created by xnx on 2018/12/26.
 * 文件处理器
 */
public class FileHandler {

    /**
     *  获取文件扩展名，会带.
     */
    public static String getExtension(String fileName){
        try {
            String result = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] toByteArray(File f) throws IOException {
        if (!f.exists()) {
            throw new FileNotFoundException("file not exists");
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

}
