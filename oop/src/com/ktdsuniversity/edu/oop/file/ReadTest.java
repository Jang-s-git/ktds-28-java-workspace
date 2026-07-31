package com.ktdsuniversity.edu.oop.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTest {

	public static void main(String[] args) {
		
		// 내가 읽고 싶은 파일을 지정 (File 이용)
		File textFile = new File("C:/Java Exam", "Java Exam.txt");
		
		// Java Exam.txt 라는 파일이 존재하는지 확인하고, 파일 형태인지 확인
		if (textFile.exists() && textFile.isFile()) {
			
			//파일을 읽어주는 객체를 선언
			FileReader reader = null;
			// 파일을 청킹해주는 객체 선언
			BufferedReader bufferedReader = null;
			
			try {
				// 파일을 읽어주는 FileReader 인스턴스를 생성
				reader = new FileReader(textFile);
				
				// 파일을 청킹해주는 BufferedReader 인스턴스를 생성
				bufferedReader = new BufferedReader(reader);
				
				// 파일을 한 줄 씩 읽어와 출력
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
				
			} catch(FileNotFoundException fnfe) {
				System.out.println(fnfe.getMessage());
				fnfe.printStackTrace();
			} catch(IOException ieo) {
				System.out.println(ieo.getMessage());
				ieo.printStackTrace();
			} finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch(IOException ieo) {}
				}
				
				if (reader != null) {
					try {
						reader.close();
					} catch(IOException ieo) {}
				}
			}
			
		}
		
	}
}
