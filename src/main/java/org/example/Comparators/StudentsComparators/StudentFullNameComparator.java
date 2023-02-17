package org.example.Comparators.StudentsComparators;

import org.apache.commons.lang3.StringUtils;
import org.example.Interfaces.StudentComparator;
import org.example.Model.Student;

public class StudentFullNameComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
