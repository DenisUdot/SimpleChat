package com.mychat.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ApachePOIExcelReadLang {
@SuppressWarnings("unchecked")
public static String getNameFromExcel(String nameOfComponents){
	int i=1;
	try {
		 File table = new File("lang.xls");
         FileInputStream inputStream = new FileInputStream(table);
         HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
         HSSFSheet sheet = workbook.getSheet("lang");
         System.out.println(sheet.getRow(0).getCell(1).toString());
         if (sheet.getRow(0).getCell(1).getNumericCellValue()!=0){
				i = 1;
			} else {
				i = 2;
			}
         Iterator<HSSFRow> iterator = sheet.iterator();
         	while (iterator.hasNext()) {
         		HSSFRow currentRow = iterator.next();
         		HSSFCell currentCell = currentRow.getCell(0);
         		String componentName = currentCell.toString();
         		if ( componentName.compareTo(nameOfComponents) == 0 ){
         			return currentRow.getCell(i).toString();
           		}
         	}
       	}catch (FileNotFoundException e) {
       		e.printStackTrace();
       	} catch (IOException e) {
       		e.printStackTrace();
      	}
	return nameOfComponents;
	}
public static void setupLang(int j){
	try {
		File table = new File("lang.xls");
        FileInputStream inputStream = new FileInputStream(table);
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheet("lang");
        HSSFCell cellEn = sheet.getRow(0).getCell(1);
        HSSFCell cellRu = sheet.getRow(0).getCell(2);
        //getCell(1) == en, getCell(2) == ru
        if (j == 1){
        	cellEn.setCellValue(1);
        	cellRu.setCellValue(0);
        }else{
        	cellEn.setCellValue(0);
        	cellRu.setCellValue(1);
        }
        inputStream.close();
        FileOutputStream out = new FileOutputStream(table);
        workbook.write(out);
        out.close();
	}catch (FileNotFoundException e) {
   		e.printStackTrace();
   	} catch (IOException e) {
   		e.printStackTrace();
  	}   
}
}