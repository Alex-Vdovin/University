package org.example;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Enums.Comparators.StudentComparators;
import org.example.Enums.StudyProfile;
import org.example.Enums.Comparators.UniversityComparators;
import org.example.Interfaces.StudentComparator;
import org.example.Interfaces.UniversityComparator;
import org.example.UtilityClasses.ComparatorUtilityClass;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Idea Projects\\UniversityProject\\src\\main\\resources\\universityInfo.xlsx";
        List<University> universities = XSSFReader.readUniversity(filePath);
        List<Student> students = XSSFReader.readStudents(filePath);
        universities.forEach(System.out::println);
        System.out.println("----------------------------------------------");
        students.forEach(System.out::println);
    }
}