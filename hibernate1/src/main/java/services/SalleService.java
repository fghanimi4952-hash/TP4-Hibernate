package services;

import dao.IDao;
import entities.Salle;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class SalleService implements IDao<Salle> {

    @Override
    public boolean save(Salle o) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Salle findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Salle.class, id);
        }
    }

    @Override
    public List<Salle> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Chargement des salles + leurs machines pour éviter LazyInitializationException
            return session.createQuery(
                    "select distinct s from Salle s left join fetch s.machines",
                    Salle.class
            ).list();
        }
    }
}
