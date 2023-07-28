package com.cvillegas.app.main.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class Base64Converter {
    public static String convertToString(MultipartFile file) throws IOException {
        return Base64.encodeBase64String( file.getBytes() );
    }
}
