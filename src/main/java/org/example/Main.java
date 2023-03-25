package org.example;


import org.example.Comparators.StudentsComparators.StudentAESComparator;
import org.example.Enums.Comparators.StudentComparators;
import org.example.Enums.Comparators.UniversityComparators;
import org.example.IO.JsonWriter;
import org.example.IO.XSSFReader;
import org.example.IO.XlsWriter;
import org.example.IO.XmlWriter;
import org.example.Interfaces.UniversityComparator;
import org.example.Model.FullInfo;
import org.example.Model.Statistics;
import org.example.Model.Student;
import org.example.Model.University;
import org.example.UtilityClasses.ComparatorUtilityClass;
import org.example.UtilityClasses.JsonUtil;
import org.example.UtilityClasses.StatisticsUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;

import java.util.List;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("C:\\Users\\avavi\\University\\src\\main\\resources\\logging.properties"));
        } catch (IOException e) {
            System.out.println("Ошибка с чтением файла конфигурации логирования" + Arrays.toString(e.getStackTrace()));
        }
        logger.log(Level.INFO, "Начало работы программы");
        String univerPath = "C:\\Users\\avavi\\University\\src\\main\\resources\\universityInfo.xlsx";
        List<Student> studentList = XSSFReader.readStudents(univerPath);
        List<University> universityList = XSSFReader.readUniversity(univerPath);
        try {
            studentList.sort(ComparatorUtilityClass.getStudentComparator(StudentComparators.STUDENT_AES_COMPARATOR));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Произошла ошибка сортировки студентов", e);
        }
        try {
            universityList.sort(ComparatorUtilityClass.getUniversityComparator(UniversityComparators.UNIVERSITY_ID_COMPARATOR));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Произошла ошибка сортировки университетов", e);
        }
        List<Statistics> statisticsList = StatisticsUtil.createStatistics(studentList, universityList);
        XlsWriter.writeStatistics(statisticsList, "C:\\Users\\avavi\\University\\src\\main\\resources\\statistics.xlsx");
        FullInfo fullInfo = new FullInfo().setStudentList(studentList)
                .setUniversityList(universityList)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());
        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);
        logger.log(Level.INFO, "Конец работы программы");

    }
}