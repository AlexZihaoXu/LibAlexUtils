package site.alex_xu.dev.utils;

public final class Clock {
    private static final long startUpRecord = System.currentTimeMillis();

    public static float getCurrentTime() {
        return (System.currentTimeMillis() - startUpRecord) / 1000f;
    }

    private float lastRecord;

    public Clock() {
        lastRecord = getCurrentTime();
    }

    public float getElapsedTime() {
        return getCurrentTime() - lastRecord;
    }

    public void reset() {
        lastRecord = getCurrentTime();
    }

}
