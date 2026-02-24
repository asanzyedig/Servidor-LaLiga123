package edu.masanz.laliga123.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ImageConvertor {

    public static void main(String[] args) {
        imgToBase64();
    }

    public static void imgToBase64(File file){
        byte[] fileContent = null;
        try {
            fileContent = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        System.out.println("data:image/png;base64, "+encodedString);
    }

    public static void imgToBase64(){
        String filePath = "prueba.jpg";
        byte[] fileContent = null;
        try {
            fileContent = FileUtils.readFileToByteArray(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        System.out.println("data:image/png;base64, "+encodedString);
    }

}
