package strategy;

public class AdultFilter implements PersonFilter {
    @Override
    public boolean apply(Person person) {
        return person.getAge() >= 18;
    }

}
