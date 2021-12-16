package T9IteratorsAndComparators.exercise.Froggy_04;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private int[] numbers;

    public Lake(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        private int index = 0;

        private int lastEvenIndex = (numbers.length - 1) % 2 == 0
                ? numbers.length - 1
                : numbers.length - 2;

        @Override
        public boolean hasNext() {
            return this.index < numbers.length;
        }

        @Override
        public Integer next() {
            int currentNumber = numbers[this.index];
            if (index == lastEvenIndex) {
                index = 1;
                return currentNumber;
            }
            this.index += 2;
            return currentNumber;
        }
    }

}


