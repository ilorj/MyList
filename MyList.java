package com.company;

public class MyList
{

    class Item {
        private int value;
        private Item object;
        public Item(int value) {
            this.value = value;
            this.object = null;
        }
        public boolean hasNext() {
            if (this.object != null){
                return true;
            }
            else {
                return false;
            }
        }
        public String toString() {
            return Long.toString(this.value);
        }
        public int getValue() {
            return value;
        }
        public Item getObject() {
            return object;
        }
        public void setObject(Item object) {
            this.object = object;
        }

    }
    private Item start;
    private long counter;

    public MyList() {
        this.start = null;
        this.counter = 0;
    }

    public void add(int value){
        Item item = new Item(value);
        if (this.start == null){
            this.start = item;
        }
        else {
            end().setObject(item);
        }
        this.counter ++;
    }


    public String toString() {
        String result = "[ ";
        if (this.start == null) {
            return null;
        }
        else {
            Item iter = this.start;
            while (iter.hasNext()) {
                result += iter.toString() + ", ";
                iter = iter.getObject();
            }
            result += iter.toString();
        }
        result += " ]";
        return result;
    }
    public Item end(){
        if (this.start == null)
            return null;
        Item iter = this.start;
        while (iter.hasNext()) {
            iter = iter.getObject();
        }
        return iter;
    }

    public Item indexAt (int index) {
        if (index <= this.counter - 1 && index >= 0) {
            Item iter = this.start;
            for (; index > 0; --index) {
                iter = iter.getObject();
            }
            return iter;
        }
        else
            return null;
    }

    public void swap (int firstPoth, int secondPoth) {
        Item preFirst = indexAt(firstPoth - 1);
        Item first = indexAt(firstPoth);
        Item aftFirst = indexAt(firstPoth + 1);
        Item preSecond = indexAt(secondPoth - 1);
        Item second = indexAt(secondPoth);
        Item aftSecond = indexAt(secondPoth + 1);

        if (preFirst != null) {
            preFirst.setObject(second);
        }
        else {
            this.start = second;
        }
        first.setObject(aftSecond);
        if (preSecond == first) {
            second.setObject(first);
        }
        else {
            second.setObject(aftFirst);
            preSecond.setObject(first);
        }
    }

    public void sort () {
        long count = this.counter;
        int i;
        Item a;
        Item b;
        while (count > 0) {
            i = 0;
            a = indexAt(i);
            b = indexAt(i + 1);
            while (i + 1 < count) {
                if (a.getValue() > b.getValue()) {
                    swap(i, i + 1);
                    i += 1;
                    a = indexAt(i);
                    b = indexAt(i + 1);
                }
                else if(a.getValue() <=  b.getValue()) {
                    ++i;
                    a = a.getObject();
                    b = b.getObject();
                }
            }
            --count;
        }
    }


}
