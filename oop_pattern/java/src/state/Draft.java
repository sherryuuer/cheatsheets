package state;

class Draft implements State {
    @Override
    public void handleRequest(Document doc) {
        doc.setState(new Review());
    }
}
