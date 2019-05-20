/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author GTFO
 */
public class TreeDemo {
    public static void main(String[] args) {
       BinaryTree tree = new BinaryTree();
        try {
            Scanner input = new Scanner(new File("input.txt"));
            while (input.hasNext()) {
                String[] number = input.next().split(",");
                int[] result = new int[number.length];
                for (int i = 0; i < number.length; i++) {
                    result[i] = Integer.parseInt(number[i]);
                    tree.insert(result[i]);
                }
            }
            input.close();
        } catch (FileNotFoundException exc) {
        }

        System.out.println(tree.printTree());
        
        System.out.println("Preorder traversal of binary tree is ");
        System.out.println(tree.printPreorder());

        System.out.println("\nInorder traversal of binary tree is ");
        System.out.println(tree.printInorder());

        System.out.println("\nPostorder traversal of binary tree is ");
        System.out.println(tree.printPostorder());
        
        System.out.println("\n");
        Scanner src = new Scanner(System.in);
        int userInput = 0;
        do{
            System.out.println("Please enter the number you want to search(-1 to quit): ");
            while(!src.hasNextInt()){
                System.out.println("Please enter the number you want to search(-1 to quit): ");
            }
            userInput = src.nextInt();
            if(userInput == -1 ){
                break;
            }
            System.out.println(tree.search(userInput));
        }while(userInput != -1);
        
        do{
            System.out.println("Please enter the number you want to delete(-1 to quit): ");
            while(!src.hasNextInt()){
                System.out.println("Please enter the number you want to delete(-1 to quit): ");
            }
            userInput = src.nextInt();
            if(userInput == -1 ){
                break;
            }
            tree.delete(userInput);
        }while(userInput != -1);
        
        System.out.println(tree.printInorder());
    }
}
