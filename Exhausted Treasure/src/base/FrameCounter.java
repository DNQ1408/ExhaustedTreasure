package base;

public class FrameCounter {
    private int count = 0;
    private int timeInterval;

    public FrameCounter(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public boolean run() {
        if (this.count == this.timeInterval) {
            return true;
        } else {
            this.count += 1;
            return false;
        }
    }

    public void reset() {
        this.count = 0;
    }
}
