package org.example.IO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Model.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    public static void writeStatistics(List<Statistics> statisticsList, String path) throws IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticsSheet = workbook.createSheet("Статистика");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor((short) 10);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        int nextRow = 0;
        Row firstRow = statisticsSheet.createRow(nextRow++);
        int nextCellNum = 0;
        Cell studyProfileCellHeader = firstRow.createCell(nextCellNum++);
        studyProfileCellHeader.setCellValue("Study Profile");
        studyProfileCellHeader.setCellStyle(headerCellStyle);
        Cell aesCellHeader = firstRow.createCell(nextCellNum++);
        aesCellHeader.setCellValue("Average Exam Score");
        aesCellHeader.setCellStyle(headerCellStyle);
        Cell studentsQuantityCellHeader = firstRow.createCell(nextCellNum++);
        studentsQuantityCellHeader.setCellValue("Students Quantity");
        studentsQuantityCellHeader.setCellStyle(headerCellStyle);
        Cell universitiesQuantityCellHeader = firstRow.createCell(nextCellNum++);
        universitiesQuantityCellHeader.setCellValue("Universities Quantity");
        universitiesQuantityCellHeader.setCellStyle(headerCellStyle);
        Cell universitiesNamesCellHeader = firstRow.createCell(nextCellNum++);
        universitiesNamesCellHeader.setCellValue("Universities Names");
        universitiesNamesCellHeader.setCellStyle(headerCellStyle);

        nextCellNum = 0;
        for(Statistics statistics : statisticsList){
            Row dataRow = statisticsSheet.createRow(nextRow++);
            Cell studyProfileCell = dataRow.createCell(nextCellNum++);
            studyProfileCell.setCellValue(statistics.getStudyProfile().getProfileName());
            Cell aesCell = dataRow.createCell(nextCellNum++);
            aesCell.setCellValue(statistics.getAvgExamScore());
            Cell studentsQuantityCell = dataRow.createCell(nextCellNum++);
            studentsQuantityCell.setCellValue(statistics.getStudentsQuantity());
            Cell universitiesQuantityCell = dataRow.createCell(nextCellNum++);
            universitiesQuantityCell.setCellValue(statistics.getStudentsQuantity());
            Cell universitiesNamesCell = dataRow.createCell(nextCellNum++);
            universitiesNamesCell.setCellValue(statistics.getUniversitiesNames());
            nextCellNum = 0;
        }

        try(FileOutputStream fos = new FileOutputStream(path)){
            workbook.write(fos);
        }

    }
}
