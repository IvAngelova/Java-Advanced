package T9IteratorsAndComparators.exercise.StrategyPattern_06;

import java.util.Comparator;

public class ComparatorAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
