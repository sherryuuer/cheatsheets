package strategy;

public class MarriedFilter implements PersonFilter {
    @Override
    public boolean apply(Person person) {
        return person.isMarried();
    }

}
