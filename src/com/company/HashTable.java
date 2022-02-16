package com.company;

public class HashTable {
    private Rectangle[] arr;
    private int size;

    public HashTable(int size){
        arr = new Rectangle[size];
        this.size = size;
    }

    private int hashFunc(Rectangle rect){ return (int)rect.getPerimeter()%size; }

    public boolean insert(Rectangle rect){
        int index = hashFunc(rect);
        if (arr[index] == null){
            arr[index] = rect;
            return true;
        } else return false;
    }

    @Override
    public String toString(){
        String info = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null){
                info += "index "+i+"\n"+arr[i].toString()+"\n";
            }
        }
        return info;
    }
}
