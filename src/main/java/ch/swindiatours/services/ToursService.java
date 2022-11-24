package ch.swindiatours.services;

import ch.swindiatours.model.Customer;
import ch.swindiatours.model.Tour;
import ch.swindiatours.persistance.TourFacade;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.Dependent;

import java.util.List;

@Stateless(name = "ToursService")
@Local
@Dependent
public class ToursService implements IToursService<Tour> {

    private TourFacade tourFacade;

    @Override
    public void create(Tour entity) {
        tourFacade.create(entity);
    }

    @Override
    public void edit(Tour entity) {
        tourFacade.edit(entity);
    }

    @Override
    public void remove(Tour entity) {
        tourFacade.remove(entity);
    }

    @Override
    public Tour find(Object id) {
        return tourFacade.find(Customer.class, id);
    }

    @Override
    public List<Tour> findAll() {
        return tourFacade.getAll();
    }

    public List<Tour> search(String searchquery) {
        return List.of(null);
    }
}
