package com.kauruck.tree;

import datenstrukturen.BinaryTree;
import datenstrukturen.Stack;

public class Main {

    private static BinaryTree<String> lisa;

    private static BinaryTree<Integer> test;

    public static void main(String[] args) {
        //TODO 2a
        {
            BinaryTree<String> b1 = new BinaryTree<>("Jacqueline");
            BinaryTree<String> b2 = new BinaryTree<>("Clancy");
            BinaryTree<String> b3 = new BinaryTree<>("Marge", b1, b2);
            BinaryTree<String> b4 = new BinaryTree<>("Mona");
            BinaryTree<String> b5 = new BinaryTree<>("Abraham");
            BinaryTree<String> b6 = new BinaryTree<>("Homer", b4, b5);
            lisa = new BinaryTree<>("Lisa", b3, b6);
        }
        //TODO 3d
        {
            BinaryTree<Integer> i1 = new BinaryTree<>(10);
            BinaryTree<Integer> i2 = new BinaryTree<>(7);
            BinaryTree<Integer> i3 = new BinaryTree<>(6, null, i2);
            BinaryTree<Integer> i4 = new BinaryTree<>(11, i1, null);
            BinaryTree<Integer> i5 = new BinaryTree<>(9, i3, i4);
            BinaryTree<Integer> i6 = new BinaryTree<>(3);
            test = new BinaryTree<>(5, i6, i5);
        }

        caboom(test);
        System.out.println("-------------------------------------");
        traversePreorder(lisa);
        System.out.println("-------------------------------------");
        traverseInorder(lisa);
        System.out.println("-------------------------------------");
        traversePostorder(lisa);
        System.out.println("-------------------------------------");
        System.out.println(size(lisa));

    }


    //TODO 2b & 3c
    public static void traversePreorder(BinaryTree<?> root){
        System.out.println(root.getContent());
        if(!root.getLeftTree().isEmpty())
            traversePreorder(root.getLeftTree());
        if(!root.getRightTree().isEmpty())
            traversePreorder(root.getRightTree());
    }

    //TODO 3c
    public static void traversePostorder(BinaryTree<?> root){
        if(!root.getLeftTree().isEmpty())
            traversePreorder(root.getLeftTree());
        if(!root.getRightTree().isEmpty())
            traversePreorder(root.getRightTree());
        System.out.println(root.getContent());
    }

    //TODO 3c
    public static void traverseInorder(BinaryTree<?> root){
        if(!root.getLeftTree().isEmpty())
            traversePreorder(root.getLeftTree());
        System.out.println(root.getContent());
        if(!root.getRightTree().isEmpty())
            traversePreorder(root.getRightTree());
    }

    //TODO 3e
    public static int size(BinaryTree<?> root){
        int size = 0;
        if(!root.getLeftTree().isEmpty())
            size += size(root.getLeftTree());
        if(!root.getRightTree().isEmpty())
            size += size(root.getRightTree());
        return  size + 1;
    }


    //TODO 3d
    public static void caboom(BinaryTree<Integer> b){
        Stack<BinaryTree<Integer>> stack = new Stack<>();

        while (!stack.isEmpty() || !b.isEmpty()){
            if(!b.isEmpty()){
                stack.push(b);
                b  = b.getLeftTree();
            }
            else{
                b = stack.top();
                stack.pop();
                System.out.println(b.getContent());
                b = b.getRightTree();
            }
        }
    }
}
