import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.budowniczowie.entity.Company;
import pl.budowniczowie.entity.CompanyDetail;
import pl.budowniczowie.entity.Property;

public class FetchTypeApp {
    public static void main(String[] args){
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        SessionFactory factory = conf.buildSessionFactory();

        Session session = factory.getCurrentSession();

        Integer id = 32;

        session.beginTransaction();

        System.out.println("Pobieranie obiektu");
        Company company = session.get(Company.class, id);
        System.out.println("Pobrano obiekt");
        System.out.println(company);
        System.out.println("Nierchomości: ");
        for (Property p:company.getProperties()) {
            System.out.println(p);
        }


        session.getTransaction().commit();


        factory.close();
    }
}
