package org.example.IO;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Enums.StudyProfile;
import org.example.Model.Student;
import org.example.Model.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XSSFReader {
    private XSSFReader() {

    }
    private static final Logger logger = LoggerFactory.getLogger(XSSFReader.class);
    public static List<Student> readStudents(String filePath) {
        logger.info("Началось чтение файла");
        List<Student> students = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(filePath);
            logger.info("Файл прочитан");
        } catch (FileNotFoundException e) {
            logger.error("Не удалось прочитать файл", e);
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(fis);
            logger.info("Workbook создан");
        } catch (IOException e) {
            logger.error("Не удалось создать новый workbook", e);
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheet("Студенты");
        logger.info("Лист " + sheet.getSheetName() + " прочитан");
        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Student student = new Student();
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());
            student.setFullName(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
            students.add(student);
        }
        logger.info("Чтение файла завершено");
        return students;
    }
    public static List<University> readUniversity(String filePath){
        logger.info("Началось чтение файла");
        List<University> universities = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(filePath);
            logger.info("Файл прочитан");
        } catch (FileNotFoundException e) {
            logger.error("Не удалось прочитать файл", e);
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(fis);
            logger.info("Workbook создан");
        } catch (IOException e) {
            logger.error("Не удалось создать новый workbook", e);
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheet("Университеты");
        logger.info("Лист " + sheet.getSheetName() + " прочитан");
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while(rows.hasNext()){
            Row currentRow = rows.next();
            University university = new University();
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
            universities.add(university);
        }
        logger.info("Чтение файла завершено");
        return universities;
    }
}
