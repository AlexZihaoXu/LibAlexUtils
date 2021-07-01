package site.alex_xu.dev.utils.geometry;

import site.alex_xu.dev.utils.Vec2D;

public class Line {
    public float slope;
    public float yIntercept;

    public Line(float slope, float yIntercept) {
        this.slope = slope;
        this.yIntercept = yIntercept;
    }

    public static Line fromPoints(Vec2D p1, Vec2D p2) {
        float slope = (p2.y - p1.y) / (p2.x - p1.x);
        float yIntercept = p1.y - p1.x * slope;
        return new Line(slope, yIntercept);
    }

    public float squaredDistanceTo(Vec2D point) {
        return point.squaredDistanceTo(point.nearestPointOn(this));
    }

    public float distanceTo(Vec2D point) {
        return (float) Math.sqrt(squaredDistanceTo(point));
    }

    public Vec2D intersectLine(Line line) {

        if (line.slope == slope) {
            return null;
        }

        float x = (line.yIntercept - this.yIntercept) / (this.slope - line.slope);
        float y = this.slope * x + this.yIntercept;

        return new Vec2D(x, y);
    }

    public boolean contains(Vec2D point) {
        float expectedY = point.x * slope + yIntercept;
        return expectedY == point.y;
    }
}
