package com.example.projekt;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AddressRepo {
//    public Address findUser(String login){
//        Transaction transaction = null;
//        try(Session session = Connect.openSession()) {
//            transaction = session.beginTransaction();
//            Query<UserAccount> query = session.createQuery("SELECT u FROM UserAccount u WHERE u.login = :login", UserAccount.class);
//            query.setParameter("login",login);
//            transaction.commit();
//            return query.getSingleResult();
//        }catch (Exception e){
//            if(transaction != null && transaction.isActive()){
//
//                transaction.rollback();
//            }
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
    public void saveAddress(Address address){
        Transaction transaction = null;
        try(Session session = Connect.openSession()) {
            transaction = session.beginTransaction();
            session.persist(address);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }
}
