package com.example.helloworld;

import android.graphics.Point;

public class MyPoint extends Point {
    private boolean isMoreP;

    public boolean isMoreP() {
        return isMoreP;
    }

    public MyPoint(int x, int y, boolean isMoreP) {
        super(x, y);
        this.isMoreP = isMoreP;
    }

    public MyPoint(Point src, boolean isMoreP) {
        super(src);
        this.isMoreP = isMoreP;
    }

}
