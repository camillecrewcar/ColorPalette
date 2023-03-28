package com.example.projekt;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ColorsRepo {
    public List<Colors> findColors(Long id){
        Transaction transaction = null;
        try(Session session = Connect.openSession()) {
            transaction = session.beginTransaction();
            Query<Colors> query = session.createQuery("SELECT u FROM Colors u WHERE u.userAccount.id = :id", Colors.class);
            query.setParameter("id",id);
            transaction.commit();
            return query.getResultList();
        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Colors> findAllColors(){
        Transaction transaction = null;
        try(Session session = Connect.openSession()) {
            transaction = session.beginTransaction();
            Query<Colors> query = session.createQuery("SELECT u FROM Colors u", Colors.class);

            transaction.commit();
            return (ArrayList<Colors>) query.getResultList();
        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Colors findColor(Long id, String nazwa){
        Transaction transaction = null;
        try(Session session = Connect.openSession()) {
            transaction = session.beginTransaction();
            Query<Colors> query = session.createQuery("SELECT u FROM Colors u WHERE u.userAccount.id = :id and u.name =: nazwa", Colors.class);
            query.setParameter("id",id);
            query.setParameter("nazwa",nazwa);
            transaction.commit();
            return query.getSingleResult();
        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void saveColor(Colors color){
        Transaction transaction = null;
        try(Session session = Connect.openSession()) {
            transaction = session.beginTransaction();
            session.persist(color);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }
    public void removeColor(Colors color){
        Transaction transaction = null;
        try(Session session = Connect.openSession()) {
            transaction = session.beginTransaction();
            session.remove(color);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }
    public void updateColor(Colors color){
        Transaction transaction = null;
        try(Session session = Connect.openSession()) {
            transaction = session.beginTransaction();
            session.merge(color);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

}
