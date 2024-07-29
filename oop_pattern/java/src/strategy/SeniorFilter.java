package strategy;

public class SeniorFilter implements PersonFilter {
    @Override
    public boolean apply(Person person) {
        return person.getAge() >= 65;
    }

}
