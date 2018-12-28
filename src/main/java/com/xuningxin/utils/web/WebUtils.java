package com.xuningxin.utils.web;

import com.alibaba.fastjson.JSONArray;
import okhttp3.*;
import org.springframework.util.StringUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xnx on 2018/12/26.
 * 网站的工具集
 */
public class WebUtils {


    private static OkHttpClient okHttpClient = new OkHttpClient();


    static OkHttpClient getOkHttpClient(){
        return okHttpClient;
    }



    //根据字符串获取图片src
    public static JSONArray getImgSrcByHtml(String html) {
        if (html == null)
            return null;
        JSONArray imgs = new JSONArray();
        Pattern pattern = Pattern.compile("<img.*src\\s*=\\s*(.*?)[^>]*?>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            String imgStr = matcher.group();
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(imgStr);
            while (m.find()) {
                String url = m.group(1);
                imgs.add(url);
            }
        }
        return imgs;
    }

    public static String getFirstImgSrcByHtml(String html) {
        if (html == null)
            return null;

        JSONArray galley = getImgSrcByHtml(html);

        if (galley == null || galley.size() == 0)
            return null;
        else
            return galley.getString(0);
    }


    /**
     *  通过url获取字符集
     */
    public static byte[] getBytesFromWebUrl(String urlStr) {
        ByteArrayOutputStream out = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url;
        try {
            url = new URL(urlStr);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();


            if (httpUrl.getResponseCode() == 200){
                bis = new BufferedInputStream(httpUrl.getInputStream());
                byte[] t = new byte[1024];

                out = new ByteArrayOutputStream(1024);
                int sizes;
                while ((sizes = bis.read(t)) != -1){
                    out.write(t,0,sizes);
                }

                return out.toByteArray();
            } else {
                System.out.println("can not connect [" + urlStr + "] success.rcode : " + httpUrl.getResponseCode());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if (out != null)
                    out.close();
                if (bis != null)
                    bis.close();
                if (httpUrl != null)
                    httpUrl.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static String[] types = {"jpg","JPEG","bmp","png","gif","webp"};


    /**
     *  处理 图片链接，将某些无法识别的后缀进行更改
     */
    public static String processImgExt(String imgUrl){
        if (StringUtils.isEmpty(imgUrl))
            return null;

        //今日头条
        if (imgUrl.contains("pstatp")){
            return ".jpg";
        }

        for (String t : types){
            if (imgUrl.contains(t)){
                if (t.equals("JPEG")){
                    t = "jpg";
                }
                return "." + t;
            }
        }

        return null;
    }


    public static String doGet(String url) throws IOException{
        OkHttpClient client = getOkHttpClient();
        System.out.println("client : " + client.hashCode());
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    /**
     *  JSON
     */
    public static String doPost(String url,String json) throws IOException{
        OkHttpClient client = getOkHttpClient();
        System.out.println("post client : " + client.hashCode());

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }



}
