package controller;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
    public static SessionFactory factory;

    public static SessionFactory getFactory() {
        if (factory == null) {
            Configuration con = new Configuration().configure();
            con.addAnnotatedClass(entity.User.class);
            con.addAnnotatedClass(entity.Issue.class);
            con.addAnnotatedClass(entity.Crm.class);

            factory = con.buildSessionFactory();
        }
        return factory;
    }

    public void closeFactory() {
        if (factory.isOpen()) {
            factory.close();
        }
    }
}
