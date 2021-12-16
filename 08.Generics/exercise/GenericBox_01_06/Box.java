package T8Generics.exercise.GenericBox_01_06;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int index1, int index2) {
        T firstElement = this.elements.get(index1);
        T secondElement = this.elements.get(index2);

        this.elements.set(index1, secondElement);
        this.elements.set(index2, firstElement);
    }

    public int countGreaterThan(T value) {
        return (int) this.elements.stream().filter(e -> e.compareTo(value) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
