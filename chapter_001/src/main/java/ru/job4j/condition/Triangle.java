package ru.job4j.condition;

public class Triangle {

    public static boolean exists(double ab, double ac, double bc){
        /*if(ab + ac > bc && ac + bc > ab && ab + bc > ac) {
            return true;
        } else {
            return false;
        }*/
        return ab + ac > bc && ac + bc > ab && ab + bc > ac;
    }
}
