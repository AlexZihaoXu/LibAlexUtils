package site.alex_xu.dev.utils;

public class FastMath {
    private static boolean initialized = false;
    private static final float PRECISION = 1024f;
    private static final float[] cosCache = new float[(int) (360 * PRECISION)];
    private static final float[] sinCache = new float[(int) (360 * PRECISION)];

    private static void initFastMath() {
        if (!initialized) {
            initialized = true;
            for (int i = 0; i < 360 * PRECISION; i++) {
                float angle = i / PRECISION;
                cosCache[i] = (float) Math.cos(Math.toRadians(angle));
                sinCache[i] = (float) Math.sin(Math.toRadians(angle));
            }
        }
    }

    public static float toDeg(float radians) {
        return (float) (radians * 180 / Math.PI);
    }

    public static float toRad(float degree) {
        return (float) (degree * Math.PI / 180);
    }

    public static int randRange(int begin, int end) {
        return (int) ((Math.random() * (end - begin)) + begin);
    }

    public static float cos(float angle) {
        initFastMath();
        int index = (int) (angle * PRECISION) % (int) (360 * PRECISION);
        if (index < 0) {
            index = (int) (360 * PRECISION + index);
        }
        return cosCache[index];
    }

    public static float sin(float angle) {
        initFastMath();
        int index = (int) (angle * PRECISION) % (int) (360 * PRECISION);
        if (index < 0) {
            index = (int) (360 * PRECISION + index);
        }
        return sinCache[index];
    }
}
