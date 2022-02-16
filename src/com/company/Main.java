package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        System.out.println("Создана хэш-таблица размером 10. Добавление прямоугольников: ");
        for (int i = 0; i < 6; i++) {
            Rectangle rct = new Rectangle();
            if (hashTable.insert(rct)){
                System.out.println("Успешно добавлен прямоугольник. Периметр: "+rct.getPerimeter());
            } else System.out.println("Коллизия. Периметр: "+rct.getPerimeter());
        }
        System.out.println(hashTable.toString());
        System.out.println("Введите значение площади, меньше которого элементы удалятся: ");
        Scanner scanner = new Scanner(System.in);
        hashTable.deleteRangeArea(0, scanner.nextDouble());
        System.out.println(hashTable.toString());
    }
}
