package com.company;

public class Main {

    public static void main(String[] args) {
        MyList a = new MyList();
        a.add(34);
        a.add(43);
        a.add(67);
        a.add(323);
        a.add(78);
        a.add(24);
        a.add(90);
        a.add(1);
        a.add(9);
        System.out.println(a.toString());
        a.swap(2, 3);
        System.out.println(a.toString());
        a.sort();
        System.out.println(a.toString());
    }
}