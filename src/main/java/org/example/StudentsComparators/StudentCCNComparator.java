package org.example.StudentsComparators;

import org.example.Student;
import org.example.Interfaces.StudentComparator;

public class StudentCCNComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}