package org.example.Comparators.StudentsComparators;

import org.example.Model.Student;
import org.example.Interfaces.StudentComparator;

public class StudentAESComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
