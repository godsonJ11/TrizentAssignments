package com.wordscount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Wordscount{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your file Location....");
		String path = sc.nextLine();
		String paraContents = "";
		String output = "G:\\god\\output.txt";
		try {
			FileInputStream fis = new FileInputStream(path);
			FileOutputStream fos = new FileOutputStream(output,true);
			while(fis.available() != 0) {
				paraContents += (char)fis.read();
			}
			//System.out.println(paraContents);
			String[] words = paraContents.split(" "); 
			//System.out.println(Arrays.toString(words));
			boolean[] visited =   new boolean[words.length];
			String newWords = "";
			for(int i=0;i<words.length;i++) {
				if(visited[i] == false && !words[i].isBlank()) {
					int count = 1;
					for(int j = i+1;j<words.length;j++) {
						if(words[i].equals(words[j])) {
							count++;
							visited[j] =  true;
						}
					}
					if(count > 1) {
						newWords = words[i] + " = " + count + " " ;
						fos.write(newWords.getBytes());
					}
				}
			}
			
			fis.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
