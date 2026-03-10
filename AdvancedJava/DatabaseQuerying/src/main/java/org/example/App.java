package org.example;


import org.example.dao.StudentDAO;
import org.example.dao.StudentDAOImpl;
import org.example.entity.Student;

public class App {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();

        dao.save(new Student("Hibban", "CS", 22, 85));
        dao.save(new Student("Aryan", "CS", 23, 90));
        dao.save(new Student("Nikhil", "CS_DS", 23, 82));

        System.out.println("---- FETCH ALL ----");
        dao.fetchAll().forEach(System.out::println);

        System.out.println("---- FETCH BY ID ----");
        System.out.println(dao.fetchById(1));

        System.out.println("---- UPDATE MARKS ----");
        dao.updateMarks(1, 95);

        System.out.println("---- SORT BY MARKS ----");
        dao.sortByMarks().forEach(System.out::println);

        System.out.println("---- FILTER BY DEPT ----");
        dao.filterByDept("IT").forEach(System.out::println);

        System.out.println("---- NATIVE FETCH ----");
        dao.nativeFetch().forEach(System.out::println);
    }
}