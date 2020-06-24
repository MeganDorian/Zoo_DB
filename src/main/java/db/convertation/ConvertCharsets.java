package db.convertation;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ConvertCharsets {
    public static String ConvertISO_8859_1(String originalString) {
        return new String (originalString.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
    }

    public static String ConvertWindows_1251(String originalString) throws UnsupportedEncodingException {
        return new String (originalString.getBytes("windows-1251"),StandardCharsets.UTF_8);
    }
}
