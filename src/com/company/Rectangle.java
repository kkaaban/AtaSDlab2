package com.company;

import java.util.Random;

public class Rectangle {
    Rectangle(){
        // Random задаёт диагональ, а потом автоматически из диагонали генерируется прямоугольник
        Random rnd = new Random();
        Point diagonalPoint1 = new Point(rnd.nextInt(100), rnd.nextInt(100));
        Point diagonalPoint2 = new Point(rnd.nextInt(100), rnd.nextInt(100));
        makeRect(diagonalPoint1, diagonalPoint2);
    }
    Rectangle(int ax, int ay, int bx, int by){
        makeRect(new Point(ax, ay), new Point(bx, by));
    }

    private Point A, B, C, D;

    public double getArea(){
        return getLengthSide(A, B)* getLengthSide(B, C);
    }
    /*Ключ*/public double getPerimeter(){ return getLengthSide(A, B)+ getLengthSide(B, C)+
            getLengthSide(C,D)+ getLengthSide(D, A); }

    private void makeRect(Point a, Point c){
        this.A = a;
        this.C = c;
        // На основе диагонали создаем прямоугольник
        B = new Point(a.x, c.y);
        D = new Point(c.x, a.y);
    }

    private double getLengthSide(Point a, Point b){
        return Math.sqrt(Math.pow(b.x-a.x, 2)+Math.pow(b.y-a.y, 2));
    }

    @Override
    public String toString(){
        return String.format("a.x: %s\n" +
                "a.y: %s\n" +
                "b.x: %s\n" +
                "b.y: %s\n" +
                "c.x: %s\n" +
                "c.y: %s\n" +
                "d.x: %s\n" +
                "d.y: %s\n"+
                "Периметр: "+getPerimeter()+"\n", A.x, A.y, B.x, B.y, C.x, C.y, D.x, D.y);
    }
}
