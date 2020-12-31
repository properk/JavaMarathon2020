package day7;

import static day7.Airplane.compareAirplanes;

public class Task1 {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("Boening-777", 1959, 135.5,33333);
        Airplane airplane2 = new Airplane("Boening-700", 1999, 126.4, 34494);

        compareAirplanes(airplane1,airplane2);
    }
}