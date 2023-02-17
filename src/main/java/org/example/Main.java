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

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String filePath = "src/main/resources/universityInfo.xlsx";
        List<University> universities = XSSFReader.readUniversity(filePath);
        UniversityComparator universityComparator = ComparatorUtilityClass.getUniversityComparator(UniversityComparators.UNIVERSITY_YOF_COMPARATOR);
        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.universitieListToJson(universities);
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        List<Student> students = XSSFReader.readStudents(filePath);
        String studentsToJson = JsonUtil.studentListToJson(students);
        System.out.println(studentsToJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsToJson);
        System.out.println(studentsFromJson);
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentToJson = JsonUtil.studentToJson(student);
            System.out.println(studentToJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentToJson);
            System.out.println(studentFromJson);
        });

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeStatistics(statisticsList, "src/main/resources/statistics.xlsx");
    }
}