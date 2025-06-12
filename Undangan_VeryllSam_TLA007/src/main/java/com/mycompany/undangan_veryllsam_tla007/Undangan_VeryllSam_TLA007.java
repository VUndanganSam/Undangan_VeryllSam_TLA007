/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.undangan_veryllsam_tla007;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Undangan_VeryllSam_TLA007 {

    public static void main(String[] args) {
        BaonBST tree = new BaonBST();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("Please enter student name: ");
            String inputName = sc.nextLine();

            int inputBaon = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Enter Student's \"Baon\": ");
                try {
                    inputBaon = sc.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    sc.nextLine(); // Clear invalid input
                }
            }
            sc.nextLine(); // Consume newline after nextInt()

            tree.insert(new Student(inputName, inputBaon));
        }

        System.out.println("\nStudents sorted by baon (Highest to Lowest):");
        tree.printDescending();
    }

    static class Student {

        String name;
        int baon;

        public Student(String name, int baon) {
            this.name = name;
            this.baon = baon;
        }

        @Override
        public String toString() {
            return name + " - " + baon;
        }
    }

    static class BSTNode {

        Student data;
        BSTNode left, right;

        public BSTNode(Student data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BaonBST {

        BSTNode root;

        public void insert(Student data) {
            root = insertRec(root, data);
        }

        private BSTNode insertRec(BSTNode root, Student data) {
            if (root == null) {
                return new BSTNode(data);
            }

            if (data.baon > root.data.baon) {
                root.left = insertRec(root.left, data);
            } else {
                root.right = insertRec(root.right, data);
            }

            return root;
        }

        public void printDescending() {
            printRec(root);
        }

        private void printRec(BSTNode root) {
            if (root != null) {
                printRec(root.right); // Start with right subtree for descending order
                System.out.println(root.data);
                printRec(root.left);
            }
        }
    }
}
