package site.alex_xu.dev.utils;

public final class Clock {
    private static final long startUpNano = System.nanoTime();
    private static final long startUpMillis = System.currentTimeMillis();
    private boolean isNanoClock;

    public static float getCurrentTime(boolean isNanoClock) {
        if (isNanoClock)
            return (System.nanoTime() - startUpNano) / 1000000000f;
        else
            return (System.currentTimeMillis() - startUpMillis) / 1000f;
    }

    private float lastRecord;

    public Clock(boolean isNanoClock) {
        lastRecord = getCurrentTime(isNanoClock);
        this.isNanoClock = isNanoClock;
    }

    public void setNanoClock(boolean isNanoClock) {
        this.isNanoClock = isNanoClock;
    }

    public Clock() {
        this(false);
    }

    public float getElapsedTime() {
        return getCurrentTime(isNanoClock) - lastRecord;
    }

    public void reset() {
        lastRecord = getCurrentTime(isNanoClock);
    }

}
