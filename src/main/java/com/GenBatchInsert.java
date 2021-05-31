package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * TODO
 *
 * @author fuwb
 * @since 2021-05-17
 */
public class GenBatchInsert {
    public static void main(String[] args) {
        String prefix = "";
        String postfix = "');\n";
        File file = new File("usercode.txt");
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            String tempStr;
            reader = new BufferedReader(new FileReader(file));
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(prefix).append(tempStr).append(postfix);
            }
            reader.close();
            System.out.println(sbf.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
