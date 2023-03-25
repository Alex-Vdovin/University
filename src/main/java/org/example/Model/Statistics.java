package org.example.Model;

import org.example.Enums.StudyProfile;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;
    @XmlElement(name = "averageScore")
    private float avgExamScore;
    @XmlTransient
    private int studentsQuantity;
    @XmlTransient
    private int universitiesQuantity;
    @XmlTransient
    private String universitiesNames;

    public Statistics(StudyProfile studyProfile, float avgExamScore, int studentsQuantity, int universitiesQuantity, String universitiesNames) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.studentsQuantity = studentsQuantity;
        this.universitiesQuantity = universitiesQuantity;
        this.universitiesNames = universitiesNames;
    }
    public Statistics(){

    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getStudentsQuantity() {
        return studentsQuantity;
    }

    public void setStudentsQuantity(int studentsQuantity) {
        this.studentsQuantity = studentsQuantity;
    }

    public int getUniversitiesQuantity() {
        return universitiesQuantity;
    }

    public void setUniversitiesQuantity(int universitiesQuantity) {
        this.universitiesQuantity = universitiesQuantity;
    }

    public String getUniversitiesNames() {
        return universitiesNames;
    }

    public void setUniversitiesNames(String universitiesNames) {
        this.universitiesNames = universitiesNames;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "studyProfile=" + studyProfile +
                ", avgExamScore=" + avgExamScore +
                ", studentsQuantity=" + studentsQuantity +
                ", universitiesQuantity=" + universitiesQuantity +
                ", universitiesNames=" + universitiesNames +
                '}';
    }
}
