package org.example;


import org.example.Enums.Comparators.UniversityComparators;
import org.example.IO.XSSFReader;
import org.example.IO.XlsWriter;
import org.example.Interfaces.UniversityComparator;
import org.example.Model.Statistics;
import org.example.Model.Student;
import org.example.Model.University;
import org.example.UtilityClasses.ComparatorUtilityClass;
import org.example.UtilityClasses.JsonUtil;
import org.example.UtilityClasses.StatisticsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        logger.info("Начало работы программы");
        String filePath = "src/main/resources/universityInfo.xlsx";
        List<University> universities = XSSFReader.readUniversity(filePath);
        List<Student> students = XSSFReader.readStudents(filePath);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeStatistics(statisticsList, "src/main/resources/statistics.xlsx");
        logger.info("Работа программы завершена");
    }
}