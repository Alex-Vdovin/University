package org.example;

public class Main {
    public static void main(String[] args) {
        University uiga = new University("1", "Ульяновский институт гражданской авиации имени Главного маршала авиации Б. П. Бугаева", "УИГА", 1935, StudyProfile.PILOT);
        University mgtuga = new University("2", "Московский государственный технический университет ГА", "МГТУ", 1971, StudyProfile.ENGINEER);
        University spbguga = new University("3", "Санкт-Петербургский государственный университет ГА", "СПБГУГА", 1955, StudyProfile.ATC);
        Student student1 = new Student("Иванов Иван Иванович", "1",1);
        Student student2 = new Student("Петров Петр Петрович", "2",4, 4.7f);
        Student student3 = new Student("Иванов Алексей Анатольевич", "3",2, 3.0f);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(uiga);
        System.out.println(mgtuga);
        System.out.println(spbguga);

    }
}