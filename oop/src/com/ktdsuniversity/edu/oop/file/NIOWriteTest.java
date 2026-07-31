package com.ktdsuniversity.edu.oop.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class NIOWriteTest {

	public static void main(String[] args) {
		
		File targetFile = new File("C:/java/outputs", "java_output.txt");
		
		// "C:/java/outputs" 존재 여부 확인
		if (!targetFile.getParentFile().exists()) {
			// 폴더가 없으면 생성
			targetFile.getParentFile().mkdirs();
		}
		
		// java_output.txt 파일 존재 여부 확인
		// 존재하면 java_output(2).txt로 순번을 증가시키면서 계속 확인
//		int index = 2;
//		while(targetFile.exists()) {
//			targetFile = new File(targetFile.getParent(),
//									"java_output (%d).txt".formatted(index++));
//		}
		
		// 파일 생성
//		try {
//			targetFile.createNewFile();
//		} catch(IOException ioe) {
//			ioe.printStackTrace();
//		}
		
		// 파일 생성 & 내용 작성
		// 1. 작성할 내용 만들기
		List<String> data = new ArrayList<>();
		data.add("안녕하시와요");
		data.add("안녕하시와요");
		data.add("안녕하시와요");
		data.add("당신은 사랑받기 위해 태어난 사람");
		data.add("당신은 사랑받기 위해 태어난 사람");
		data.add("당신은 사랑받기 위해 태어난 사람");
		data.add("당신은 사랑받기 위해 태어난 사람");
		data.add("당신은 사랑받기 위해 태어난 사람");
		
		// 2. 파일 생성하기
		try {
			// 파일에 내용 덧붙이기 StandardOpenOption.APPEND
			Files.write(targetFile.toPath(), data, StandardOpenOption.APPEND);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
	}
}
