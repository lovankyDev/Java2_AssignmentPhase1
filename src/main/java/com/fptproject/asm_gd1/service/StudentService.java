/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptproject.asm_gd1.service;

import com.fptproject.asm_gd1.entity.Student;
import com.fptproject.asm_gd1.util.InputHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class StudentService {

    private InputHelper ip = new InputHelper();
    private Scanner sc = ip.getScaner();

    public void addStudent(List<Student> students, Set<String> emails, Map<String, Student> map) {

        System.out.println("Please type the student's id");
        String id = sc.nextLine();

        System.out.println("Please type the student's name");
        String name = sc.nextLine();

        System.out.println("Please type the student's age");
        int age = Integer.parseInt(sc.nextLine());

        System.out.println("Please type the student's email");
        String email = "";
        boolean run = true;
        while (run) {
            String tmp = sc.nextLine();
            if (!emails.contains(tmp)) {
                email = tmp;
                emails.add(tmp);
                run = false;
            } else {
                System.out.println("Email already existed. Please try again");
            }
        }

        System.out.println("Please type the student's average mark");
        double mark = Double.parseDouble(sc.nextLine());
        Student student = new Student(id, name, age, email, mark);

        map.put(id, student);
        students.add(student);

        System.out.println("Student " + student.toString() + "has been added successfully!");

    }

    public void showMailSet(Set<String> emails) {

        if (emails.isEmpty()) {
            System.out.println("Email list is empty");
        } else {
            System.out.println("Email list");
            emails.forEach(System.out::println);
        }

    }

    public void showList(List<Student> students) {

        System.out.println("Student List");
        students.forEach((student) -> {
            System.out.println(student.toString());
        });
    }

    public void deleteById(List<Student> students) {

        System.out.println("Please type your student's id");
        Scanner sc = ip.getScaner();
        String id = sc.nextLine();
        students.removeIf(student -> student.getId().equals(id));
        System.out.println("Delete student successfully!");
    }

    public void findAllByName(List<Student> students) {
        System.out.println("Please type your student's name");
        String pattern = sc.nextLine();
        List<Student> resutls = students.stream().filter(student -> {
            return student.getName().contains(pattern);
        }).toList();

        if (resutls.isEmpty()) {
            System.out.println("There's no student is named pattern");
        } else {
            resutls.forEach(student -> {
                System.out.println(student.toString());
            });
        }

    }

    public void update(String id, List<Student> students) {

        Optional<Student> studentOpt = students.stream().filter(student -> {
            return student.getId().equals(id);
        }).findFirst();

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            System.out.println("You're updating student: " + id);
            System.out.println("Please type the student's name");
            String name = sc.nextLine();
            student.setName(name);

            System.out.println("Please type the student's age");
            int age = Integer.parseInt(sc.nextLine());
            student.setAge(age);

            System.out.println("Please type the student's email");
            String email = sc.nextLine();
            student.setEmail(email);

            System.out.println("Please type the student's average mark");
            double mark = Double.parseDouble(sc.nextLine());
            student.setMark(mark);
        } else {
            System.out.println("There is no student with id " + id);
        }
        System.out.println("Update user successfully");
    }

    public void findStudentMapById(Map<String, Student> map) {
        System.out.println("Please type student's id");
        String id = sc.nextLine();

        Student student = map.get(id);
        if (Objects.isNull(student)) {
            System.out.println("There is no student with id: " + id);
        } else {
            System.out.println(student.toString());
        }
    }

    public void showMap(Map<String, Student> map) {
        System.out.println("Show map");
        map.keySet().forEach(key -> {

            Student student = map.get(key);
            System.out.println(key + "->" + student.toString());
        });
    }

    public void sortByName(List<Student> students) {

        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("Sort students by students' name successfully!");
    }

    public void initSample(List<Student> students, Map<String, Student> studentMap, Set<String> emails) {
        Student s3 = new Student("S3", "Nguyen Van E", 12, "nguyenvane@gmail.com", 10);
        students.add(s3);
        emails.add(s3.getEmail());
        studentMap.put(s3.getId(), s3);
        Student s1 = new Student("S1", "Nguyen Van A", 12, "nguyenvana@gmail.com", 10);
        students.add(s1);
        studentMap.put(s1.getId(), s1);
        Student s2 = new Student("S2", "Nguyen Van C", 19, "cvannguyen1998@gmail.com", 10);
        students.add(s2);
        emails.add(s2.getEmail());
        studentMap.put(s2.getId(), s2);

        System.out.println("Init sample value successful");
    }

}
