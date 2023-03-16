package org.example.UtilityClasses;

import org.apache.commons.lang3.StringUtils;
import org.example.Enums.StudyProfile;
import org.example.Model.Statistics;
import org.example.Model.Student;
import org.example.Model.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUtil {
    private StatisticsUtil(){}
    private static final Logger logger = LoggerFactory.getLogger(StatisticsUtil.class);
    public static List<Statistics> createStatistics(List<Student> students, List<University> universities){
        logger.info("Начал работы со статистикой");
        List<Statistics> statisticsList = new ArrayList<>();
        Set<StudyProfile> studyProfiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());
        studyProfiles.forEach(studyProfile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(studyProfile);

            List<String> profileUniversitiesIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getId)
                    .toList();
            statistics.setUniversitiesQuantity(profileUniversitiesIds.size());
            statistics.setUniversitiesNames(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversitiesNames(statistics.getUniversitiesNames() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversitiesIds.contains(student.getUniversityId()))
                    .toList();
            statistics.setStudentsQuantity(profileStudents.size());
            OptionalDouble averageExamScore = students.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            averageExamScore.ifPresent(value ->
                    statistics.setAvgExamScore((float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));

        });
        logger.info("Работа со статистикой завершена", statisticsList);
        return statisticsList;
    }

}
