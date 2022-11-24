package ch.swindiatours.view.controller;

import ch.swindiatours.model.Tour;
import ch.swindiatours.services.ToursService;

import java.util.List;

public class testPersistence {
    public static void main(String[] args) {
        ToursService toursService = new ToursService();
        List<Tour> toursList = toursService.search("yxc");

        for (Tour tour : toursList) {
            System.out.println(tour.toString());
        }
    }
}
