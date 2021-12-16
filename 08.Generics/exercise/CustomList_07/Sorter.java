package T8Generics.exercise.CustomList_07;


public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {

        // customList.getElements().sort((f, s) -> f.compareTo(s));

        //Bubble Sort
        int size = customList.getElements().size();
        for (int index = 0; index < size; index++) {
            T element = customList.getElements().get(index);
            for (int nextIndex = index + 1; nextIndex < size; nextIndex++) {
                T nextElement = customList.getElements().get(nextIndex);
                if (element.compareTo(nextElement) > 0) { //element > nextElement
                    customList.swap(index, nextIndex);
                }
            }
        }

    }
}
