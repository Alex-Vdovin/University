package org.example;

public enum StudyProfile {
    ENGINEER("Инженеры"),
    PILOT("Пилоты"),
    ATC("Диспетчеры"),
    MEDICINE("Медицина"),
    COOKING("Кулинария");

    private String profileName;
    StudyProfile(String profileName){
        this.profileName = profileName;
    }
    public String getProfileName(){
        return profileName;
    }

    @Override
    public String toString() {
        return "StudyProfile{" +
                "profileName='" + profileName + '\'' +
                '}';
    }
}
