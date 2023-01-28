package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;

public class ReadData {
	
	public static void main(String[] args)  {
		

		String s="greens12345@mail.com";
		
		char[] charArray = s.toCharArray();
			for(int i=charArray.length-1;i>0;i--) {
				System.out.print(s.charAt(i));
			}
		System.out.println();
			
		}
		
	}

	


