package T9IteratorsAndComparators.exercise.StrategyPattern_06;

import java.util.Comparator;

public class ComparatorName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getName().length(), o2.getName().length());
        if (result == 0) {
            //case-insensitive
            result = Character.compare(o1.getName().toLowerCase().charAt(0),
                    o2.getName().toLowerCase().charAt(0));
        }
        return result;
    }
}
