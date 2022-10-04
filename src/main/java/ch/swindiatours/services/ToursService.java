package ch.swindiatours.services;

import ch.swindiatours.model.Tour;
import ch.swindiatours.persistance.TourFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless(name = "ToursService")
@Local

public class ToursService implements IToursService<Tour>  {
     @EJB
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
            return tourFacade.find(id);
        }

        @Override
        public List<Tour> findAll() {
            return tourFacade.getAll();
        }
}
