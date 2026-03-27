/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptproject.asm_gd1.util;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class InputHelper {
    
    public Scanner getScaner(){
        return new Scanner(System.in); 
    }
    
    public void close(Scanner scanner){
        scanner.close();
    }
}
