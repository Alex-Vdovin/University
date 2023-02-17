package org.example.Interfaces;

import org.example.Model.Student;

import java.util.Comparator;

public interface StudentComparator extends Comparator <Student>{
    @Override
    int compare(Student o1, Student o2);
}
