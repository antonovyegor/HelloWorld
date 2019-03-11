package com.example.helloworld;

import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Objects;

public class Perceptron {
    private double w1;
    private double w2;
    private double out_y;
    private double p;
    private double sigma;
    private ArrayList<MyPoint> points;



    public Perceptron(double w1, double w2, double p, double sigma) {
        this.w1 = w1;
        this.w2 = w2;
        this.p = p;
        this.sigma = sigma;
        this.points = new ArrayList<>();
    }

    public Perceptron(double p, double sigma) {
        this.p = p;
        this.sigma = sigma;
        this.w1=0;
        this.w2=0;
        this.points = new ArrayList<>();
    }

    public ArrayList<MyPoint> getPoints() {
        return points;
    }

    public void addPoint(MyPoint p){
        this.points.add(p);
    }
    public void addPoint(int x , int y , boolean b){
        this.points.add(new MyPoint(x,y,b));
    }

    public double getY(MyPoint p) {
        return w1*p.x + w2*p.y;
    }
    public double getY(int x , int y) {
        return w1*x + w2*y;
    }
    public boolean isEnd(MyPoint point){
        return ((getY(point)>this.p)&&point.isMoreP())  ||  ((getY(point)<this.p)&&!point.isMoreP()) ;
    }


    public void run() {
        System.out.println("!!!!!START!!!!!");
        double delta ;
        int counter=0;
        while (true) {
            double oldw1=w1;
            double oldw2 = w2;
            for (MyPoint point : points) {
                delta = p - getY(point);
                w1 += delta * point.x * sigma;
                w2 += delta * point.y * sigma;
            }
            counter++;
            if (Math.abs(oldw1-w1)<0.001  && Math.abs(oldw2-w2)<0.001 )
                break;
        }

        System.out.println("!!!Конец!!!");
        System.out.println("W1="+w1);
        System.out.println("W2="+w2);
    }

    public void Clear() {
        this.points.clear();
        w1=0;w2=0;p=1;sigma=0.01;
    }

}
