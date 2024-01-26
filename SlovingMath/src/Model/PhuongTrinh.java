package model;

import java.util.ArrayList;
import java.util.List;

public class PhuongTrinh {
    public List<Float> giaiPTbacmot(float a, float b) {
        List<Float> solutions = new ArrayList<>();
        if (a == 0) {
            return solutions;
        } else {
            float x = -b / a;
            solutions.add(x);
            return solutions;
        }
    }

    public List<Float> giaiPTbacHai(float a, float b, float c) {
        List<Float> solutions = new ArrayList<>();
        if (a == 0) {
            return giaiPTbacmot(b, c);
        } else {
            float delta = b * b - 4 * a * c;
            if (delta < 0) {
                return solutions;
            } else if (delta == 0) {
                float x = -b / (2 * a);
                solutions.add(x);
                return solutions;
            } else {
                float sqrtDelta = (float) Math.sqrt(delta);
                float x1 = (-b + sqrtDelta) / (2 * a);
                float x2 = (-b - sqrtDelta) / (2 * a);
                solutions.add(x1);
                solutions.add(x2);
                return solutions;
            }
        }
    }
}