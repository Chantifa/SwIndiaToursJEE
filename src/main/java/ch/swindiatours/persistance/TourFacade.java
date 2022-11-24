package ch.swindiatours.persistance;
import ch.swindiatours.model.Tour;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class TourFacade extends Facade<Tour> implements Serializable {
       @PersistenceContext(unitName = "swindiatours")
        private EntityManager em;
        public TourFacade() {
            super(Tour.class);
        }

        @Override
        protected EntityManager getEntityManager() {
            return em;
        }

    public HashMap<String,Tour> getAllToursMap(){
        HashMap<String, Tour> tours = new HashMap<>();
        for(Tour tour : getAll()){
            tours.put(tour.getTitel(), tour);
        }
        return tours;
    }

    public Collection<Tour> getAllTours(){
        return em.createNamedQuery("tour.findAll", Tour.class).getResultList();
    }

    public Tour getTourById(int tourId){
        return em.createNamedQuery("tour.findById", Tour.class).setParameter("tourId", tourId).getSingleResult();
    }

    protected Tour getItem(String tourId){
        return em.createNamedQuery("tour.findById", Tour.class).setParameter("tourId", tourId).getSingleResult();
    }

    public void create(Tour tour) {
        em.getTransaction().begin();
        em.persist(tour);
        em.flush();
        em.refresh(tour);
        em.getTransaction().commit();
    }

}
