package myjava.io;

import java.io.*;

public class LineNumberReaderTest {

	public static void main(String[] args) {
		String cvsUploadFilePath = "D:/CreateMailing.ftl";
		System.out.println(hasContent(cvsUploadFilePath));
	}
	
	public static boolean hasContent(String cvsUploadFilePath){
		try {
			BufferedReader br = new BufferedReader(new FileReader(cvsUploadFilePath));
			String s = null;
			int i =0;
			while((s = br.readLine())!=null){
				i++;
				System.err.println(i);
				System.err.println("-----------------");
				if(i==2)
					return (s.length()>0) ? true : false;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
