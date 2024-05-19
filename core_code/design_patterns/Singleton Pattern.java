static class Singleton {

    private static Singleton uniqueInstance = null;
    private String value = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


Singleton s = Singleton.getInstance();

s.getValue(); // null

s.setValue("a value string");
s.getValue(); // "a value string"

Singleton s2 = Singleton.getInstance();

s2.getValue(); // "a value string"
