package com.example.projekt;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserAccountRepo {
    public UserAccount findUser(String login){
        Transaction transaction = null;
        try(Session session = Connect.openSession()) {
            transaction = session.beginTransaction();
            Query<UserAccount> query = session.createQuery("SELECT u FROM UserAccount u WHERE u.login = :login", UserAccount.class);
            query.setParameter("login",login);
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
    public List<UserAccount> findUsers(String login){
        Transaction transaction = null;
        try(Session session = Connect.openSession()) {
            transaction = session.beginTransaction();
            Query<UserAccount> query = session.createQuery("SELECT u FROM UserAccount u WHERE u.login = :login", UserAccount.class);
            query.setParameter("login",login);
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

    public void saveUser(UserAccount userAccount){
        Transaction transaction = null;
        try(Session session = Connect.openSession()) {
            transaction = session.beginTransaction();
            session.persist(userAccount);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }
}
