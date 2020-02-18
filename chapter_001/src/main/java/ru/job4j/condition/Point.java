package ru.job4j.condition;

import static java.lang.Math.pow;

public class Point {

    private int x;
    private int y;
    private int z;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point that) {
        return Math.sqrt(pow(this.x - that.x, 2) + (pow(this.y - that.y, 2)));
    }

    public void info(String message) {
        System.out.println(String.format("Point " + message + " [%s, %s]", this.x, this.y));
    }

    public double distance3d(Point that) {
        return Math.sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        a.info("a");
        b.info("b");
        double dist = a.distance(b);
        System.out.println(dist);
    }
}
