package service.impl;

import entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.UsersDao;
import util.HibernateUtils;

import java.util.List;

public class UsersDaoImpl implements UsersDao {
    @Override
    public boolean usersLogin(Users users) {
        Transaction tx = null;
        String hql = "";
        try {
            Session session = HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            hql = "from Users where username=?0 and password=?1";
            Query query = session.createQuery(hql);
            query.setParameter(0,users.getUsername());
            query.setParameter(1,users.getPassword());
            List list = query.list();
            tx.commit();
            return list.size()>0?true:false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
        }
    }
}
