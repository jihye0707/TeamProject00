package main;

import main.list.MyQueue;
import main.list.MyStack;
import main.map.MyHashTable;
import main.map.StudentInfo;
import main.pq.*;
import main.sort.MyMergeSort;
import main.tree.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
//        Stack_Queue_practice2();    //3주차 실습 2 실행
//        Stack_Queue_practice3();    //3주차 실습 3 실행
//        List_and_Iterators_Practice2_1(); //4주차 실습 2-1
//        System.out.println("-------------------");
//        List_and_Iterators_Practice2_2(); //4주차 실습 2-2
//        Trees_3();
//        System.out.println();
//        System.out.println("-------------------");
//        Trees_4_1();
//        System.out.println("-------------------");
//        Trees_4_2();
////        Trees2_1(); //6주차 실습
//        PQ1_2();
//        PQ2();
//        HashTable_10_1();
//        System.out.println("-----------------실습 2----------------------");
//        HashTable_10_2();
//          SearchTree();
          MergeSort();
    }

    private static void MergeSort() {
        System.out.println("----------실습2 1번-----------");
        MyMergeSort myMergeSort = new MyMergeSort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2)
                    return 1;
                else
                    return 0;
            }
        });

        ArrayList arr = new ArrayList();

        for(int i = 0; i < 20; i++)
            arr.add((int)(Math.random() * 100) + 1);

        System.out.println("정렬 전= " + arr);
        myMergeSort.sort(arr);

        System.out.println("----------실습2 2번-----------");
        MyMergeSort myMergeSort2 = new MyMergeSort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.compareTo(o2)<0)
                    return 1;
                else
                    return 0;
            }
        });

        String str = "In computer science, a data structure is a data organization, management, and storage format that enables efficient access and modification. More precisely, a data structure is a collection of data values, the relationships among them, and the functions or operations that can be applied to the data.";
        String[] split_str = str.split(" ");
        for(int i = 0; i<split_str.length; i++){
            split_str[i] = split_str[i].toLowerCase();
            split_str[i] = split_str[i].replace(",","");
            split_str[i] = split_str[i].replace(".","");
        }

        ArrayList<String> str_arr = new ArrayList<>();
        for(int i = 0; i<split_str.length; i++){
            str_arr.add(split_str[i]);
        }

        System.out.println("정렬 전 = " + str_arr);
        myMergeSort2.sort(str_arr);
    }

    private static void SearchTree() {
        MyBST tree = new MyBST(6);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(8);
        tree.insert(9);
        tree.insert(9);
        System.out.println("tree.find(8) = " + tree.find(8));
        System.out.println("tree.find(3) = " + tree.find(3));
        System.out.println("tree.insert(3) = " + tree.insert(3));
        System.out.println("tree.insert(7) = " + tree.insert(7));
        System.out.println("tree.insert(9) = " + tree.insert(9));
        System.out.println("tree.remove(1) = " + tree.remove(1));
        System.out.println("tree.remove(4) = " + tree.remove(4));
        System.out.println("tree.remove(6) = " + tree.remove(6));
        System.out.println("tree.find(3) = " + tree.find(3));
        System.out.println("tree.find(6) = " + tree.find(6));
        System.out.println("tree.findAll(6) = " + tree.findAll(9));

        tree.printInorder(tree.root());
    }

    //10주차 실습 2
    private static void HashTable_10_2() {
        MyHashTable table = new MyHashTable(13, (float) 0.9);
        table.put("202311276", "1");
        table.put("202211276", "2");
        table.put("202111276", "3");
        table.put("202011276", "4");
        table.put("201911276", "5");
        table.put("201811276", "6");
        table.put("201711276", "7");
        table.put("201611276", "8");
        table.put("201511276", "9");
        table.put("201411276", "10");
        table.put("201311276", "11");
        table.put("201211276", "12");
        table.put("201111276", "13");
        table.put("201011276", "14");
        table.printHashTable();
        table.put("200611276", "15");   //rehash 발생
        table.put("200911276", "16");
        table.put("200811276", "17");
        table.put("200711276", "18");
        table.printHashTable();
    }

    //10주차 실습 1
    private static void HashTable_10_1() {
        MyHashTable table = new MyHashTable(13);
        table.put("202311276", "1");
        table.put("202211276", "2");
        table.put("202111276", "3");
        table.put("202011276", "4");
        table.put("201911276", "5");
        table.put("201811276", "6");
        table.put("201711276", "7");
        table.put("201611276", "8");
        table.put("201511276", "9");
        table.put("201411276", "10");

        table.printHashTable();
    }

    //8주차 실습 1-2
    private static void PQ1_2() {
        IntComparator c = new IntComparator();
        MyPQ pq = new MyPQ(c);
        pq.insert(30, null);
        pq.insert(10, null);
        pq.insert(20, null);
        System.out.println((Integer) pq.removeMin().getKey());
        System.out.println((Integer) pq.removeMin().getKey());
        System.out.println((Integer) pq.removeMin().getKey());
    }

    //8주차 실습 2
    private static void PQ2() {
        //2-1
        PointComparator c = new PointComparator();
        MyPQ pq = new MyPQ(c);

        pq.insert(new Point(5, 4), 'a');
        pq.insert(new Point(2, 7), 'b');
        pq.insert(new Point(9, 5), 'c');
        pq.insert(new Point(3, 1), 'd');
        pq.insert(new Point(7, 2), 'e');
        pq.insert(new Point(9, 7), 'f');
        pq.insert(new Point(1, 4), 'g');
        pq.insert(new Point(4, 3), 'h');
        pq.insert(new Point(8, 2), 'i');
        pq.insert(new Point(4, 8), 'j');

        System.out.println("[가까운 순서]");
        printPoint(pq);

        //2-2
        PointComparator2 c2 = new PointComparator2();
        MyPQ pq2 = new MyPQ(c2);

        pq2.insert(new Point(5, 4), 'a');
        pq2.insert(new Point(2, 7), 'b');
        pq2.insert(new Point(9, 5), 'c');
        pq2.insert(new Point(3, 1), 'd');
        pq2.insert(new Point(7, 2), 'e');
        pq2.insert(new Point(9, 7), 'f');
        pq2.insert(new Point(1, 4), 'g');
        pq2.insert(new Point(4, 3), 'h');
        pq2.insert(new Point(8, 2), 'i');
        pq2.insert(new Point(4, 8), 'j');

        System.out.println();
        System.out.println("[멀리 있는 순서]");
        printPoint(pq2);

    }

    private static void printPoint(MyPQ pq) {
        while (!pq.isEmpty()) {
            System.out.print(pq.min().getValue());
            Point p1 = (Point) pq.removeMin().getKey();
            System.out.printf(" (%d, %d)", p1.x, p1.y);
            System.out.println();
        }
    }


    //6주차 실습
    private static void Trees2_1() {
        //3-1번
        MyBinTree binTree = new MyBinTree();

        MyBinNode binNode1 = binTree.addRoot("+");
        MyBinNode binNode2 =binTree.addNode("*");
        MyBinNode binNode3 =binTree.addNode("*");
        MyBinNode binNode4 =binTree.addNode(2);
        MyBinNode binNode5 =binTree.addNode("-");
        MyBinNode binNode6 =binTree.addNode(3);
        MyBinNode binNode7 =binTree.addNode(2);
        MyBinNode binNode10 =binTree.addNode(3);
        MyBinNode binNode11 =binTree.addNode(1);

        binNode1.setLeft(binNode2);
        binNode1.setRight(binNode3);
        binNode2.setLeft(binNode4);
        binNode2.setRight(binNode5);
        binNode3.setLeft(binNode6);
        binNode3.setRight(binNode7);
        binNode5.setLeft(binNode10);
        binNode5.setRight(binNode11);

        //3-2번
        inOrder(binTree,binNode1);
        //3-3번
        System.out.println();
        System.out.print("= ");
        System.out.print(postOrder(binTree,binNode1));
    }

    private static void inOrder(MyBinTree tree, MyBinNode node){
        if(!tree.isExternal(node)){
            System.out.print("(");
            if (tree.hasLeft(node)) {
                inOrder(tree, node.left());
                System.out.print(node.element());
                if (tree.hasRight(node)) {
                    inOrder(tree,node.right());
                }
            }
            else{
                System.out.print(node.element());
                inOrder(tree,node.right());
            }
            System.out.print(")");
        }
        else{
            if (node == tree.parent(node).left()) {
                System.out.print(node.element());
            }
            else{
                System.out.print(node.element());
            }
        }
    }

    private static int postOrder(MyBinTree tree, MyBinNode node) {
        if(!tree.isExternal(node)){
            if (tree.hasLeft(node) && tree.hasRight(node)) {
                int left = postOrder(tree, node.left());
                int right = postOrder(tree,node.right());

                if (node.element() == "+"){
                    return left + right;
                }
                else if(node.element() == "-"){
                    return left - right;
                }
                else if(node.element() == "*"){
                    return left * right;
                }
                else{
                    return left / right;
                }
            }
        }
        else{
            return (int)(node.element());
        }
        return 0;
    }

    //5주차 실습 3번 코드
    private static void Trees_3(){
        MyTree tree = new MyTree();

        //root와 함께 트리 생성
        MyNode root = tree.addRoot("Computers’R Us");
        System.out.println("[Level 0]");
        System.out.println(root.element());
        System.out.println();

        //depth 1
        MyNode node2 = tree.addChild(root, "sales");
        MyNode node3 = tree.addChild(root, "Manufacturing");
        MyNode node4 = tree.addChild(root, "R&D");

        System.out.println("[Level 1]");
        System.out.printf("%s,%s,%s",node2.element(),node3.element(),node4.element());
        System.out.println();
        System.out.println();

        //depth 2
        MyNode node5 = tree.addChild(node2,"US");
        MyNode node6 = tree.addChild(node2,"International");
        MyNode node7 = tree.addChild(node3,"Laptops");
        MyNode node8 = tree.addChild(node3,"Desktops");

        System.out.println("[Level 2]");
        System.out.printf("%s,%s,%s,%s",node5.element(),node6.element(),node7.element(),node8.element());
        System.out.println();
        System.out.println();

        //depth 3
        MyNode node9 = tree.addChild(node6,"Europe");
        MyNode node10 = tree.addChild(node6,"Asia");
        MyNode node11 = tree.addChild(node6,"Canada");

        System.out.println("[Level 3]");
        System.out.printf("%s,%s,%s",node9.element(),node10.element(),node11.element());
        System.out.println();
        System.out.println();

        System.out.printf("* Tree size = Total %d Nodes",tree.size());
    }

    //5주차 실습 4번코드
    private static void Trees_4_1(){
        MyTree tree = new MyTree();

        MyNode root = tree.addRoot("Make Money Fast!");

        //depth 1
        MyNode node2 = tree.addChild(root, "1. Motivation");
        MyNode node3 = tree.addChild(root, "2. Methods");
        MyNode node4 = tree.addChild(root, "3. References");

        //depth2
        tree.addChild(node2, "1.1 Greed");
        tree.addChild(node2,"1.2 Greed");
        tree.addChild(node3, "2.1 Stock Fraud");
        tree.addChild(node3, "2.2 Ponzi Scheme");
        tree.addChild(node3, "2.3 Bank Robbery");

        preOrder(tree,root,0);
    }

    private static void preOrder(MyTree tree, MyNode node, int depth) {
        for (int i =0; i<depth; i++) {
            System.out.printf(" ");     //depth 만큼 들여쓰기
        }
        System.out.println(node.element());
        if(!tree.isExternal(node)){
            for (int i =0; i<node.children().size(); i++){
                preOrder(tree, (MyNode) node.children().get(i),depth+1);
            }
        }
    }

    //4주차 실습
    private static void Trees_4_2(){

        MyTree tree = new MyTree();

        MyNode root = tree.addRoot("cs16/");

        //depth 1
        MyNode node2 = tree.addChild(root, "homeworks/");
        MyNode node3 = tree.addChild(root, "programs/");
        MyNode node4 = tree.addChild(root, "todo.txt(1K)");

        //depth2
        tree.addChild(node2, "h1c.doc(3K)");
        tree.addChild(node2,"h1nc.doc(2K)");
        tree.addChild(node3, "DDR.java(10K)");
        tree.addChild(node3, "Stocks.java(25K)");
        tree.addChild(node3, "Robot.java(20K)");

        postOrder(tree,root);
    }

    private static int postOrder(MyTree tree, MyNode node) {
        if(node.element().toString().endsWith("/")){
            int size = 0;
            for(int i = 0; i<node.children().size(); i++){
                size+= postOrder(tree,(MyNode) node.children().get(i));
            }
            System.out.println(node.element().toString() +" = "+size + "KB");
            return size;
        }
        else{
            return Integer.valueOf(node.element().toString().split("\\(")[1].split("K")[0]);
        }
    }

    private static void List_and_Iterators_Practice2_1(){
        MyStack stack = new MyStack();
        for (int i =1; i<11; i ++){
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }

    private static void List_and_Iterators_Practice2_2(){
        MyQueue queue = new MyQueue();
        for (int i =1; i<11; i ++){
            queue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }
    }
//    //3주차 실습 2 실행코드
//    private static void Stack_Queue_practice2() {
//        ArrayStack arrayStack = new ArrayStack();
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//
//        for (int i = 0; i < input.length(); i++) {
//            arrayStack.push(input.charAt(i));
//        }
//
//        arrayStack.revPrint();
//    }
//
//    //3주차 실습 3 실행코드
//    private static void Stack_Queue_practice3() {
//        StackQueue stackQueue = new StackQueue();
//        //1
//        stackQueue.enqueue('a');
//        stackQueue.enqueue('b');
//        stackQueue.enqueue('c');
//        stackQueue.enqueue('d');
//        stackQueue.enqueue('e');
//        //2
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        //3
//        stackQueue.enqueue('f');
//        stackQueue.enqueue('g');
//        stackQueue.enqueue('h');
//        stackQueue.enqueue('i');
//        stackQueue.enqueue('j');
//        //4
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        //5
//        stackQueue.enqueue('k');
//        stackQueue.enqueue('l');
//        stackQueue.enqueue('m');
//        stackQueue.enqueue('n');
//        stackQueue.enqueue('o');
//        //6
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        //7
//        while (!stackQueue.isEmpty()){
//            System.out.println(stackQueue.dequeue());
//        }
//
//    }

}
