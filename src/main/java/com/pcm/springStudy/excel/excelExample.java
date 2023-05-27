package com.pcm.springStudy.excel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelExample {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		loadExcel(br.readLine());
	}
	
	public static void loadExcel(String path) throws IOException {
		try {
			String filePath = "D:\\" + path;
			//FileInputStream 으로 파일 읽기
			FileInputStream inputStream = new FileInputStream(filePath);
			
			//XSSFWorkbook 객체 생성
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			//XSSFSheet 객체 생성 - 첫번쨰 시트 가져온다
			XSSFSheet sheet = workbook.getSheetAt(0);
			int len = sheet.getLastRowNum();
			for(int i=0; i<=len; i++) {
				XSSFRow row = sheet.getRow(i);
				int cellLen = row.getLastCellNum();
				for(int j=0; j<cellLen; j++) {
					XSSFCell cellData = row.getCell(j);
					if(cellData != null) {
						System.out.println(i+"번쨰 ROW "+j+"번쨰 CELL :: "+cellData);
					}
				}
			}
			
			//FileOutputStream 으로 파일 저장
			FileOutputStream out = new FileOutputStream(filePath);
			workbook.write(out);
			
			//자원 반환
			out.close();
			workbook.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("엑셀 파일 ERROR ::: " + e.getMessage());
		}  
	}
	
}
