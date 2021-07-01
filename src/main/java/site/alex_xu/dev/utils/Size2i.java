package site.alex_xu.dev.utils;

public class Size2i {
    public int width, height;

    public Size2i(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Size2i(Vec2D vec) {
        this.width = (int) vec.x;
        this.height = (int) vec.y;
    }

    public Size2i(Size2f size) {
        this.width = (int) size.width;
        this.height = (int) size.height;
    }

    public Vec2D toVec2D() {
        return new Vec2D(this.width, this.height);
    }
}
