package org.example.UniversityComparators;

import org.example.Interfaces.UniversityComparator;
import org.example.University;

public class UniversityYOFComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
