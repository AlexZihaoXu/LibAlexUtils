package site.alex_xu.dev.utils.geometry;


import site.alex_xu.dev.utils.Vec2D;

public class Rect {
    private float w, h;
    private final Vec2D position = new Vec2D();

    public Rect(float x, float y, float width, float height) {
        position.x = x;
        position.y = y;
        this.w = width;
        this.h = height;
    }

    public Vec2D getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
    }

    public void setPosition(Vec2D position) {
        this.position.set(position);
    }

    public Rect(float width, float height) {
        this(0, 0, width, height);
    }

    public Rect() {
        this(0, 0);
    }

    public boolean contains(Vec2D point) {
        return getLeft() <= point.x && point.x <= getRight() && getTop() <= point.y && point.y <= getBottom();
    }

    public boolean contains(float x, float y) {
        return getLeft() <= x && x <= getRight() && getTop() <= y && y <= getBottom();
    }

    public float getRight() {
        return getLeft() + getWidth();
    }

    public float getBottom() {
        return getTop() + getHeight();
    }

    public void setCenter(Vec2D center) {
        setCenterX(center.x);
        setCenterY(center.y);
    }

    public void setCenter(float x, float y) {
        setCenterX(x);
        setCenterY(y);
    }

    public boolean push(Rect rect) {
        Rect intersection = new Rect();
        if (rect.intersectsWith(this, intersection)) {
            if (intersection.getWidth() < intersection.getHeight()) {
                if (rect.getX() < getX()) {
                    rect.setRight(getLeft());
                } else {
                    rect.setLeft(getRight());
                }
            } else {
                if (rect.getY() < getY()) {
                    rect.setBottom(getTop());
                } else {
                    rect.setTop(getBottom());
                }
            }
            return true;
        }
        return false;
    }

    public final boolean intersectsWith( Rect rect, Rect out) {
        float x_min = Math.max(rect.getX(), this.getX());
        float x_max1 = rect.getX() + rect.getWidth();
        float x_max2 = this.getX() + this.getWidth();
        float x_max = Math.min(x_max1, x_max2);
        if (x_max > x_min) {
            float y_min = Math.max(rect.getY(), this.getY());
            float y_max1 = rect.getY() + rect.getHeight();
            float y_max2 = this.getY() + this.getHeight();
            float y_max = Math.min(y_max1, y_max2);
            if (y_max > y_min) {
                if (out != null) {
                    out.setX(x_min);
                    out.setY(y_min);
                    out.setWidth(x_max - x_min);
                    out.setHeight(y_max - y_min);
                }
                return true;
            }
        }
        return false;
    }

    public final boolean intersectsWith( Rect rect) {
        return intersectsWith(rect, null);
    }

    public float getCenterX() {
        return getLeft() + getWidth() / 2f;
    }

    public float getCenterY() {
        return getTop() + getHeight() / 2f;
    }

    public float getTop() {
        return getY();
    }

    public void setCenterX(float centerX) {
        setLeft(centerX - getWidth() / 2f);
    }

    public void setCenterY(float centerY) {
        setTop(centerY - getHeight() / 2f);
    }

    public void setLeft(float left) {
        setX(left);
    }

    public float getLeft() {
        return getX();
    }

    public void setRight(float right) {
        setLeft(right - getWidth());
    }

    public void setTop(float top) {
        setY(top);
    }

    public void setBottom(float bottom) {
        setTop(bottom - getHeight());
    }

    public void setX(float x) {
        this.position.x = x;
    }

    public void setY(float y) {
        this.position.y = y;
    }

    public void setWidth(float w) {
        this.w = w;
    }

    public void setHeight(float h) {
        this.h = h;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return w;
    }

    public float getHeight() {
        return h;
    }
}
