package ru.job4j.tracker;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        var session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        var session = sf.openSession();
        boolean rls = true;
        try {
            session.getTransaction();
            session.createQuery("UPDATE Item WHERE id = :fId")
                    .setParameter("fId", id);
            session.getTransaction().commit();
        } catch (Exception e) {
            rls = false;
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rls;
    }

    @Override
    public void delete(int id) {
        var session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE Item WHERE id = :fId")
                            .setParameter("fId", id);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAll() {
        var session = sf.openSession();
        List<Item> all = new ArrayList<>();
        try {
            session.beginTransaction();
            var query = session.createQuery("FROM Item", Item.class).getResultList();
            all.addAll(query);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return all;
    }

    @Override
    public List<Item> findByName(String key) {
        var session = sf.openSession();
        List<Item> all = new ArrayList<>();
        try {
            session.beginTransaction();
            var query = session.createQuery("FROM Item as k WHERE k.name = :fKey", Item.class)
                    .setParameter("fKey", key).getResultList();
            all.addAll(query);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return all;
    }

    @Override
    public Item findById(int id) {
        var session = sf.openSession();
        var rsl = new Item();
        try {
            session.beginTransaction();
            rsl = session.createQuery("FROM Item as i WHERE i.id = :fId", Item.class)
                    .setParameter("fId", id).getSingleResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rsl;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}