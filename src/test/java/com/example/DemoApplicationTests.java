package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		fileTest();
	}

	/**
	 * 파일 읽고 쓰기 테스트
	 */
	@Test
	public void fileTest(){
		File file1 = new File("C:\\test\\3456.txt");
		File file2 = new File("C:\\test\\test1.txt");

		try(
			FileInputStream fis = new FileInputStream(file1);
			BufferedInputStream bis = new BufferedInputStream(fis, 1024);
			DataInputStream dis = new DataInputStream(bis);

			FileOutputStream fileOutputStream = new FileOutputStream(file2);
			BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream, 1024);
			DataOutputStream dos = new DataOutputStream(bos)
		){

			while(true) {
				int x = dis.read();
				if(x == -1) break;
				dos.write(x);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
