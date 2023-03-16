package org.example.IO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Model.Statistics;
import java.util.logging.*;



import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    private static final Logger logger =Logger.getLogger(XlsWriter.class.getName());
    public static void writeStatistics(List<Statistics> statisticsList, String path){

        logger.log(Level.INFO, "Началась запись в файл");

        XSSFWorkbook workbook = new XSSFWorkbook();
        logger.log(Level.INFO, "Создан workbook " + workbook.getClass().getSimpleName());
        XSSFSheet statisticsSheet = workbook.createSheet("Статистика");
        logger.log(Level.INFO, "Создан лист " + statisticsSheet.getSheetName());

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
        logger.log(Level.INFO,"Создана клетка " + studyProfileCellHeader.getStringCellValue() );
        studyProfileCellHeader.setCellStyle(headerCellStyle);
        Cell aesCellHeader = firstRow.createCell(nextCellNum++);
        aesCellHeader.setCellValue("Average Exam Score");
        logger.log(Level.INFO, "Создана клетка " + aesCellHeader.getStringCellValue());
                aesCellHeader.setCellStyle(headerCellStyle);
        Cell studentsQuantityCellHeader = firstRow.createCell(nextCellNum++);
        studentsQuantityCellHeader.setCellValue("Students Quantity");
        logger.log(Level.INFO,"Создана клетка " +studentsQuantityCellHeader.getStringCellValue() );
                studentsQuantityCellHeader.setCellStyle(headerCellStyle);
        Cell universitiesQuantityCellHeader = firstRow.createCell(nextCellNum++);
        universitiesQuantityCellHeader.setCellValue("Universities Quantity");
        logger.log(Level.INFO,"Создана клетка " + universitiesQuantityCellHeader.getStringCellValue() );
                universitiesQuantityCellHeader.setCellStyle(headerCellStyle);
        Cell universitiesNamesCellHeader = firstRow.createCell(nextCellNum++);
        universitiesNamesCellHeader.setCellValue("Universities Names");
        logger.log(Level.INFO,"Создана клетка " + universitiesNamesCellHeader.getStringCellValue() );
                universitiesNamesCellHeader.setCellStyle(headerCellStyle);

        nextCellNum = 0;
        logger.log(Level.INFO, "Началось внесение данных");
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
        }catch (IOException e){
            logger.log(Level.SEVERE, "Произошла ошибка во время записи файла", e);
        }
        logger.log(Level.INFO,"Запись файла прошла успешно");
    }
}
