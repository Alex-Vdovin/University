package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        University uiga = new University("1", "Ульяновский институт гражданской авиации имени Главного маршала авиации Б. П. Бугаева", "УИГА", 1935, StudyProfile.PILOT);
        University mgtuga = new University("2", "Московский государственный технический университет ГА", "МГТУ", 1971, StudyProfile.ENGINEER);
        University spbguga = new University("3", "Санкт-Петербургский государственный университет ГА", "СПБГУГА", 1955, StudyProfile.ATC);
        Student student1 = new Student("Иванов Иван Иванович", "1", 1);
        Student student2 = new Student("Петров Петр Петрович", "2", 4, 4.7f);
        Student student3 = new Student("Иванов Алексей Анатольевич", "3", 2, 3.0f);

        UniversityComparator universityComparatorID = UtilityClass.getUniversityComparator(UniversityComparators.UNIVERSITY_ID_COMPARATOR);
        UniversityComparator universityComparatorFN = UtilityClass.getUniversityComparator(UniversityComparators.UNIVERSITY_FULL_NAME_COMPARATOR);
        UniversityComparator universityComparatorSN = UtilityClass.getUniversityComparator(UniversityComparators.UNIVERSITY_SHORT_NAME_COMPARATOR);
        UniversityComparator universityComparatorYOF = UtilityClass.getUniversityComparator(UniversityComparators.UNIVERSITY_YOF_COMPARATOR);
        UniversityComparator universityComparatorPr = UtilityClass.getUniversityComparator(UniversityComparators.UNIVERSITY_MAIN_PROFILE_COMPARATOR);

        StudentComparator studentComparatorName = UtilityClass.getStudentComparator(StudentComparators.STUDENT_FULL_NAME_COMPARATOR);
        StudentComparator studentComparatorUnID = UtilityClass.getStudentComparator(StudentComparators.STUDENT_UNIVERSITY_ID_COMPARATOR);
        StudentComparator studentComparatorCCN = UtilityClass.getStudentComparator(StudentComparators.STUDENT_CCN_COMPARATOR);
        StudentComparator studentComparatorAES = UtilityClass.getStudentComparator(StudentComparators.STUDENT_AES_COMPARATOR);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        List<University> universities = new ArrayList<>();
        universities.add(uiga);
        universities.add(spbguga);
        universities.add(mgtuga);

        String line = "-------------------------------------------------------------------------------------------";

        System.out.println("Сортировка университетов:");
        System.out.println("ID\n");
        universities
                .stream()
                .sorted(universityComparatorID)
                .forEach(System.out::println);
        System.out.println(line);
        System.out.println("Full Name\n");
        universities
                .stream()
                .sorted(universityComparatorFN)
                .forEach(System.out::println);
        System.out.println(line);
        System.out.println("Short Name\n");
        universities
                .stream()
                .sorted(universityComparatorSN)
                .forEach(System.out::println);
        System.out.println(line);
        System.out.println("Year Of Foundation\n");
        universities
                .stream()
                .sorted(universityComparatorYOF)
                .forEach(System.out::println);
        System.out.println(line);
        System.out.println("Main Profile\n");
        universities
                .stream()
                .sorted(universityComparatorPr)
                .forEach(System.out::println);
        System.out.println(line);
        System.out.println("\nСортировка студентов:");
        System.out.println("Full Name\n");
        students
                .stream()
                .sorted(studentComparatorName)
                .forEach(System.out::println);
        System.out.println(line);
        System.out.println("University ID\n");
        students
                .stream()
                .sorted(studentComparatorUnID)
                .forEach(System.out::println);
        System.out.println(line);
        System.out.println("Current Course Number\n");
        students
                .stream()
                .sorted(studentComparatorCCN)
                .forEach(System.out::println);
        System.out.println(line);
        System.out.println("AES\n");
        students
                .stream()
                .sorted(studentComparatorAES)
                .forEach(System.out::println);
        System.out.println(line);
    }
}