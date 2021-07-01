package site.alex_xu.dev.utils;


import site.alex_xu.dev.utils.geometry.Line;

public class Vec2D {
    public float x, y;
    public static Vec2D CENTER = new Vec2D();

    /**
     * Create an empty vec (0, 0)
     */
    public Vec2D() {
        x = 0;
        y = 0;
    }

    public Vec2D(Size2i size2i) {
        x = size2i.width;
        y = size2i.height;
    }

    public Vec2D(Size2f size2f) {
        x = size2f.width;
        y = size2f.height;
    }

    public final Vec2D copy() {
        return new Vec2D(x, y);
    }

    /**
     * @param vec specify which vec to set to
     */
    public void set(Vec2D vec) {
        x = vec.x;
        y = vec.y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static Vec2D create(float x, float y) {
        return new Vec2D(x, y);
    }

    public static Vec2D create(int x, int y) {
        return Vec2D.create((float) x, (float) y);
    }

    public static Vec2D create(Vec2D vec) {
        return Vec2D.create(vec.x, vec.y);
    }

    public Vec2D(int x, int y) {
        this((float) x, (float) y);
    }

    public Vec2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vec2D(Vec2D vec) {
        this(vec.x, vec.y);
    }

    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void move(Vec2D vec) {
        x += vec.x;
        y += vec.y;
    }

    /**
     * @param x position x
     * @param y position y
     * @return the squared distance to a certain vec
     */
    public float squaredDistanceTo(float x, float y) {
        return (this.x - x) * (this.x - x) + (this.y - y) * (this.y - y);
    }

    public float squaredDistanceTo(int x, int y) {
        return squaredDistanceTo((float) x, (float) y);
    }

    public float squaredDistanceTo(Vec2D vec) {
        return squaredDistanceTo(vec.x, vec.y);
    }

    public float squaredDistanceTo(Line line) {
        return line.squaredDistanceTo(this);
    }

    public float distanceTo(Line line) {
        return line.distanceTo(this);
    }

    public Line shortestPathTo(Line line) {
        float m = - (1 / line.slope);
        float b = this.y - m * this.x;
        return new Line(m, b);
    }

    public Vec2D nearestPointOn(Line line) {
        return this.shortestPathTo(line).intersectLine(line);
    }

    /**
     * @param x position x
     * @param y position y
     * @return the distance to the certain vec
     */
    public float distanceTo(float x, float y) {
        return (float) Math.sqrt(squaredDistanceTo(x, y));
    }

    public float distanceTo(int x, int y) {
        return distanceTo((float) x, (float) y);
    }

    public float distanceTo(Vec2D vec) {
        return distanceTo(vec.x, vec.y);
    }

    public float directionTo(float x, float y) {
        return (float) Math.atan2(this.y - y, this.x - x);
    }

    public float directionTo(int x, int y) {
        return directionTo((float) x, (float) y);
    }

    public float directionTo(Vec2D vec) {
        return directionTo(vec.x, vec.y);
    }

    /**
     * Normalize the vec
     */
    public void normalize() {
        float direction = CENTER.directionTo(x, y);
        x = FastMath.cos(direction);
        y = FastMath.sin(direction);
    }

    /**
     * Normalize and returns itself
     *
     * @return normalized
     */
    public Vec2D normalized() {
        Vec2D vec = new Vec2D(x, y);
        vec.normalize();
        return vec;
    }

    /**
     * This will not affect the original vec
     *
     * @param vec another vec to multiply with
     * @return the multiplied vec
     */
    public Vec2D mult(Vec2D vec) {
        return new Vec2D(x * vec.x, y * vec.y);
    }

    public Vec2D mult(float multiplier) {
        return new Vec2D(x * multiplier, y * multiplier);
    }

    /**
     * This will affect the original vec
     *
     * @param vec another vec to multiply with
     * @return the multiplied vec
     */
    public Vec2D multLocal(Vec2D vec) {
        x *= vec.x;
        y *= vec.y;
        return this;
    }

    public Vec2D multLocal(float multiplier) {
        set(x * multiplier, y * multiplier);
        return this;
    }

    public static Vec2D fromAngle(float angle, float distance) {
        return new Vec2D(FastMath.cos(angle) * distance, FastMath.sin(angle) * distance);
    }

    public static Vec2D fromAngle(float angle) {
        return fromAngle(angle, 1);
    }

    /**
     * This will not affect the original vec
     *
     * @param vec another vec to plus with
     * @return the added vec
     */
    public Vec2D plus(Vec2D vec) {
        return new Vec2D(x + vec.x, y + vec.y);
    }

    /**
     * This will affect the original vec
     *
     * @param vec another vec to plus with
     * @return the added vec
     */
    public Vec2D plusLocal(Vec2D vec) {
        x += vec.x;
        y += vec.y;
        return this;
    }

    public Vec2D plusLocal(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    @Override
    public String toString() {
        return "vec2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
