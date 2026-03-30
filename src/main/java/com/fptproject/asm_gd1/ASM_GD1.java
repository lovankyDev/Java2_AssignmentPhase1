/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fptproject.asm_gd1;

import com.fptproject.asm_gd1.entity.Student;
import com.fptproject.asm_gd1.service.StudentService;
import com.fptproject.asm_gd1.util.InputHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class ASM_GD1 {

    public static void main(String[] args) {
        run(); 
    }
    
    private static List<Student> students = new ArrayList<>(); 
    private static Set<String> emails = new HashSet<>(); 
    private static Map<String, Student> studentMap = new HashMap<>(); 
    private static StudentService studentService = new StudentService();
    private static InputHelper ip = new InputHelper();
    
    
    public static void run(){
        
        Scanner sc = ip.getScaner();
        
        int choose = Integer.MAX_VALUE; 
        do{
            
            System.out.println("""
                               ======================================
                               ======================================
                               Student Management Program
                               ---------------------------------------
                               1. Nhap danh sach sinh vien
                               2. Hien thi danh sach
                               3. Xoa sinh vien theo ma
                               4. Tim sinh vien theo ten
                               5. Tim sinh vien theo id voi map
                               6. Hien thi map
                               7. Sap xep danh sach theo ten
                               8. Tao du lieu test
                               9. Hien thi danh sach email
                               0. Thoat
                               Option: 
                               """);
            
            choose = sc.nextInt();
            
            switch (choose) {
                case 1:
                    studentService.addStudent(students, emails, studentMap);
                    break;
                case 2: 
                    studentService.showList(students);
                    break;
                case 3: 
                    studentService.deleteById(students, studentMap, emails);
                    break;
                case 4: 
                    studentService.findAllByName(students);
                    break;
                case 5: 
                    studentService.findStudentMapById(studentMap);
                    break;
                case 6: 
                    studentService.showMap(studentMap);
                    break;
                case 7: 
                    studentService.sortByName(students);
                    break;
                    
                case 8: 
                    studentService.initSample(students, studentMap, emails);
                    break;
                case 9: 
                    studentService.showMailSet(emails);
                    break;
                case 0: 
                    System.out.println("See you again");
                    break;
                default:
                    System.out.println("Your option is INVALID");
                    break;
            }
        }while(choose != 0); 
        
        ip.close(sc);
    }
}
