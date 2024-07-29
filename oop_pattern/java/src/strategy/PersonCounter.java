package strategy;

import java.util.List;

public class PersonCounter {
    PersonFilter filter;

    public void setFilter(PersonFilter filter) {
        this.filter = filter;
    }

    public int count(List<Person> people) {
        int count = 0;
        for (Person person : people) {
            if (filter.apply(person)) {
                count++;
            }
        }
        return count;
    }
}
