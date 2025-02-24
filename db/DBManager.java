package kz.bitlab.techorda2025.secondProject.db;

import java.util.*;

public class DBManager {

    private static Long id = 8L;
    static List<Student> studentList = new ArrayList<>();
    static Map<Integer, String> cities = new HashMap<>();

    static {
        Student st = Student.builder()
                .id(1L)
                .name("Dinara")
                .surname("Bagzhan")
                .city("Kyzylorda")
                .exam(80)
                .build();

        st.setMark(setMarkObject(st.getExam()));

        Student st2 = Student.builder().id(2L).name("Zhansaya").surname("Batyrbek").city("Almaty").exam(90).build();
        st2.setMark(setMarkObject(st2.getExam()));

        Student st3 = Student.builder().id(3L).name("Nurzhan").surname("Belebayev").city("Astana").exam(63).build();
        st3.setMark(setMarkObject(st3.getExam()));

        Student st4 = Student.builder().id(4L).name("Esil").surname("Askar").city("Shymkent").exam(50).build();
        st4.setMark(setMarkObject(st4.getExam()));

        Student st5 = Student.builder().id(5L).name("Madiyar").surname("Kypshakbayev").city("Kyzylorda").exam(40).build();
        st5.setMark(setMarkObject(st5.getExam()));

        Student st6 = Student.builder().id(6L).name("Ruslan").surname("Omarov").city("Akmola").exam(106).build();
        st6.setMark(setMarkObject(st6.getExam()));

        Collections.addAll(studentList, st, st2, st3, st4, st5,st6);
    }


    static{
        cities.put(1, "Almaty");
        cities.put(2, "Astana");
        cities.put(3, "Shymkent");
        cities.put(4, "Kyzylorda");
        cities.put(5, "Kirov");
        cities.put(6, "Taldykorgan");
    }

    public static String setMarkObject(int exam) {
        if(exam <= 100 && exam > 89) {
            return "A";
        } else if(exam <= 90 && exam > 79) {
            return "B";
        } else if(exam <= 80 && exam > 69) {
            return "C";
        } else if(exam <= 70 && exam > 59) {
            return "D";
        } else if(exam <= 60 && exam > 49) {
            return "E";
        } else if(exam <= 50 && exam > 0) {
            return "F";
        } else {
            return "Wrong value";
        }
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static Map<Integer, String> getCities() {
        return cities;
    }

    public static void addStudent(Student student){
        student.setId(id);
        studentList.add(student);
        id++;
    }
}
