package org.example.Enums;

public enum StudyProfile {
    ENGINEER("Инженеры"),
    PILOT("Пилоты"),
    ATC("Диспетчеры"),
    MEDICINE("Медицина"),
    COOKING("Кулинария"),
    PHYSICS("Физика"),
    COMPUTER_SCIENCE("Информатика"),
    MATHEMATICS("Математика"),
    JURISPRUDENCE("Юриспруденция"),
    LINGUISTICS("Лингвистика");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public String toString() {
        return "StudyProfile{" +
                "profileName='" + profileName + '\'' +
                '}';
    }
}
