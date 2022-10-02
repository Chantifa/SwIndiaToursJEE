package ch.swindiatours.persistance;
import ch.swindiatours.model.Tour;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class TourFacade extends Facade<Tour> {
       @PersistenceContext(unitName = "ch.swindiatours.jakarta.ch")
        private EntityManager em;

        public TourFacade() {
            super(Tour.class);
        }

        @Override
        protected EntityManager getEntityManager() {
            return em;
        }
}
