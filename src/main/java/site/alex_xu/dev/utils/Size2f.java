package site.alex_xu.dev.utils;

public class Size2f {
    public float width, height;

    public Size2f(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public Size2f(Vec2D vec) {
        this.width = (int) vec.x;
        this.height = (int) vec.y;
    }

    public Size2f(Size2i size) {
        this.width = size.width;
        this.height = size.height;
    }

    public Size2f copy() {
        return new Size2f(this.width, this.height);
    }

    public Vec2D toVec2D() {
        return new Vec2D(this.width, this.height);
    }
}
