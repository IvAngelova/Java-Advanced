package T9IteratorsAndComparators.exercise.ListyIterator_01_02;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int index;

    public ListyIterator(List<String> list) {
        this.list = list;
        if (this.list.isEmpty()) {
            this.index = -1;
        } else {
            this.index = 0;
        }
    }

    public boolean move() {
        if (this.index < list.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (this.index < this.list.size() - 1) {
            return true;
        }
        return false;
    }

    public void print() throws Exception {
        if (this.list.isEmpty()) {
            throw new Exception("Invalid Operation!");
        } else {
            System.out.println(this.list.get(index));
        }
    }

    public void printAll(){
        for (String s : this.list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public String next() {
                return list.get(index++);
            }
        };
    }
}
