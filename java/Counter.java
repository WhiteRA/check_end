class Counter implements AutoCloseable {
    private int count = 0;
    private boolean resourceOpened = false;

    public void add() {
        if (!resourceOpened) {
            throw new IllegalStateException("Counter resource not opened.");
        }
        count++;
    }

    @Override
    public void close() throws Exception {
        if (!resourceOpened) {
            throw new IllegalStateException("Counter resource not opened.");
        }

        if (count > 0) {
            throw new IllegalStateException("Counter value is not reset.");
        }

        resourceOpened = false;
    }

    public void openResource() {
        resourceOpened = true;
    }

    public int getCount() {
        return count;
    }
}
