package state;

class Review implements State {
    @Override
    public void handleRequest(Document doc) {
        if (doc.isApproved()) {
            doc.setState(new Published());
        } else {
            doc.setState(new Draft());
        }
    }
}
