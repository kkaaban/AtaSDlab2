package com.company;

public class HashTable {
    private Rectangle[] arr;
    private int size;

    public HashTable(int size){
        arr = new Rectangle[size];
        this.size = size;
    }

    private int hashFunc(Rectangle rect){ return (int)rect.getPerimeter()%size; }
    private int hashFunc2(Rectangle rect){
        int key = (int)rect.getPerimeter();
        int hash = size-3-(key%(size-3));
        return hash;
    }

    public boolean insert(Rectangle rect){
        int index = hashFunc(rect);
        if (arr[index] == null){
            arr[index] = rect;
            return true;
        } else {
            if (!arr[index].equals((rect))){
                return collisions(index, rect);
            }
        }
        return false;
    }

    public void deleteRangeArea(double from, double to){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=null && arr[i].getArea()>from && arr[i].getArea()<to){
                arr[i] = null;
            }
        }
    }

    private boolean collisions(int index, Rectangle rectangle){
        int newInd = index;
        int hash = hashFunc2(rectangle);
        for (int i = 0; i < arr.length; i++) {
            newInd = (i*hash+index)%size;
            if (arr[newInd]==null){
                arr[newInd] = rectangle;
                return true;
            }
            if (arr[newInd].equals(rectangle)){
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String info = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null){
                info += "index "+i+", "+"периметр: "+arr[i].getPerimeter()+"\n";
            }
        }
        return info;
    }
}
