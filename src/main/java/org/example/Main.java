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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

import java.util.List;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args){
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("C:\\Users\\avavi\\University\\src\\main\\resources\\logging.properties"));
        }catch (IOException e){
            System.out.println("Ошибка с чтением файла конфигурации логирования" + Arrays.toString(e.getStackTrace()));
        }

        logger.log(Level.INFO, "Начало работы программы");
        String filePath = "src/main/resources/universityInfo.xlsx";
        List<University> universities = XSSFReader.readUniversity(filePath);
        List<Student> students = XSSFReader.readStudents(filePath);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeStatistics(statisticsList, "src/main/resources/statistics.xlsx");
        logger.log(Level.INFO,"Работа программы завершена" );
    }
}