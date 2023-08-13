package vscodejava;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;

// Abstract class representing a student
abstract class Student {
    protected String name;
    protected int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void displayInfo();
}

// Concrete class representing an undergraduate student
class UndergraduateStudent extends Student {
    private String major;

    public UndergraduateStudent(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void displayInfo() {
        System.out.println("Undergraduate Student");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Major: " + major);
    }
}

// Class representing a binary tree node
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Student> studentsMap = new HashMap<>();
        Stack<TreeNode> treeStack = new Stack<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Undergraduate Student");
            System.out.println("2. Display Student Info");
            System.out.println("3. Perform Binary Tree Operations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student major: ");
                    String major = scanner.nextLine();

                    // Create and store an UndergraduateStudent object
                    UndergraduateStudent undergradStudent = new UndergraduateStudent(name, age, major);
                    studentsMap.put(studentsMap.size() + 1, undergradStudent);
                    System.out.println("Undergraduate student added.");
                    break;

                case 2:
                    System.out.print("Enter student number: ");
                    int studentNumber = scanner.nextInt();
                    Student student = studentsMap.get(studentNumber);
                    if (student != null) {
                        student.displayInfo();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                // Implement Binary Tree Operations case here

                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}