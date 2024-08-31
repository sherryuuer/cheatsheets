package observer;

class Customer implements Observer {
    private String name;
    private int notifications;

    public Customer(String name) {
        this.name = name;
        this.notifications = 0;
    }

    public void notify(String itemName) {
        this.notifications += 1;
        System.out.println(name + " has been notified about " + itemName);
    }

    public int countNotifications() {
        return this.notifications;
    }
}
