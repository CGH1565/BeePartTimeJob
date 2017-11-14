package priv.xiaohan.ssm.utils;

import org.apache.commons.lang.StringUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by HotSauce on 2017/8/3.
 */
public class ShowSign {

    public static String getSign(String url) throws Exception {
        String[] urls = url.split("&");
        return Signing(urls);
    }

    private static String Signing(String[] urls) throws NoSuchAlgorithmException {
        Map<String, String> params = new TreeMap<String, String>();
        for (int i = 0; i < urls.length; i++) {

            String item[] = urls[i].split("=");
            params.put(item[0], item[1]);
        }

        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String,String> s : params.entrySet()){
            String key = s.getKey();
            String value = s.getValue();
            if(StringUtils.isBlank(value)){
                continue;
            }
            builder.append(key).append("=").append("&");
        }
        if (!params.isEmpty()) {
            builder.deleteCharAt(builder.length() - 1);
        }

        String minSign = builder.toString();

        //MD5算法
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        byte[] input = minSign.getBytes();
        byte[] buff = messageDigest.digest(input);
        minSign = bytesToHex(buff);
        return minSign;
    }

    private static String bytesToHex(byte[] bytes){
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }
}
