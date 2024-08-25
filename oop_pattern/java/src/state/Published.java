package state;

class Published implements State {
    @Override
    public void handleRequest(Document doc) {
        // Final state, no action needed
    }
}
