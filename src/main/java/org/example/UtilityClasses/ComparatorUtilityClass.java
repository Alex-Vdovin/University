package org.example.UtilityClasses;

import org.example.Enums.Comparators.StudentComparators;
import org.example.Enums.Comparators.UniversityComparators;
import org.example.Interfaces.StudentComparator;
import org.example.Interfaces.UniversityComparator;
import org.example.StudentsComparators.StudentAESComparator;
import org.example.StudentsComparators.StudentCCNComparator;
import org.example.StudentsComparators.StudentFullNameComparator;
import org.example.StudentsComparators.StudentUniversityIdComparator;
import org.example.UniversityComparators.*;

public class ComparatorUtilityClass {
    private ComparatorUtilityClass() {
    }

    public static final UniversityComparator getUniversityComparator(UniversityComparators universityComparators) throws Exception {
        switch (universityComparators) {
            case UNIVERSITY_ID_COMPARATOR -> {
                return new UniversutyIdComparator();
            }
            case UNIVERSITY_SHORT_NAME_COMPARATOR -> {
                return new UniversityShortNameComparator();
            }
            case UNIVERSITY_FULL_NAME_COMPARATOR -> {
                return new UniversityFullNameComparator();
            }
            case UNIVERSITY_MAIN_PROFILE_COMPARATOR -> {
                return new UniversityMainProfileComparator();
            }
            case UNIVERSITY_YOF_COMPARATOR -> {
                return new UniversityYOFComparator();
            }
        }
        throw new Exception("Что-то пошло не так с Comparators университетов");
    }

    public static final StudentComparator getStudentComparator(StudentComparators studentComparators) throws Exception {
        switch (studentComparators) {
            case STUDENT_AES_COMPARATOR -> {
                return new StudentAESComparator();
            }
            case STUDENT_CCN_COMPARATOR -> {
                return new StudentCCNComparator();
            }
            case STUDENT_FULL_NAME_COMPARATOR -> {
                return new StudentFullNameComparator();
            }
            case STUDENT_UNIVERSITY_ID_COMPARATOR -> {
                return new StudentUniversityIdComparator();
            }
        }
        throw new Exception("Что-то пошло не так с Comparators студентов");
    }
}
