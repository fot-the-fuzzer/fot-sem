package common;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    public static String getMD5(byte[] bytes) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        md.update(bytes);
        return new BigInteger(1, md.digest()).toString();
    }

    public static String getMD5(String text) {
        return getMD5(text.getBytes());
    }

    public static String inferExt(File file) {
        String fileName = file.getName();
        int idx = fileName.lastIndexOf('.');
        if (idx > 0) {
            return fileName.substring(idx + 1).toLowerCase();
        } else {
            return null;
        }
    }

    public static String getBaseName(File file) {
        String name = file.getName();
        int pos = name.lastIndexOf('.');
        if (pos > 0) {
            name = name.substring(0, pos);
        }
        return name;
    }

}
