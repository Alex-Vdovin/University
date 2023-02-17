package org.example.UniversityComparators;

import org.apache.commons.lang3.StringUtils;
import org.example.Interfaces.UniversityComparator;
import org.example.University;

public class UniversityMainProfileComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o2.toString(), o1.toString());
    }
}
