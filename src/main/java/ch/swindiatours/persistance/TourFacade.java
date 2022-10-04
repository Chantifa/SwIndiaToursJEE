package ch.swindiatours.persistance;

import ch.swindiatours.model.Tour;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;

@Stateless
public class TourFacade extends Facade<Tour> implements Serializable {
       @PersistenceContext
        private EntityManager em;

        public TourFacade() {
            super(Tour.class);
        }

        @Override
        protected EntityManager getEntityManager() {
            return em;
        }
}
