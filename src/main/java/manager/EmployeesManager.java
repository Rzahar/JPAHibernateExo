package manager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Employees;

public class EmployeesManager {

	protected SessionFactory sessionFactory;

	protected void setup() {
		// Chargement de la Session hibernate
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println(ex.getStackTrace());
		}
	}

	protected void exit() {
		// Code qui nous fera quitter la session !! IMPERATIF !!
		sessionFactory.close();
	}

    ArrayList<String> employeeList = new ArrayList<String>();
	protected void create() {
		// Creation d'un salarié fictif

		Employees employe = new Employees();
		employe.setNom("Toto");
		employe.setPrenom("TotoJr");
		employe.setCourriel("toto@aol.fr");
		employe.setAge(29);
		employe.setFonction("Dev Jr");
		employe.setTelephone(836656565);
		employe.setAdresse("30 rue du trotoire d'en face, 59000 Lille");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employe);
		session.getTransaction().commit();
		session.close();
	}

	protected Employees read(long id) {
		// Fonction servant à accèder aux infos d'un salarié
		Session session = sessionFactory.openSession();
		id = 1;
		Employees employe = session.get(Employees.class, id);
		System.out.println(" Nom : " + employe.getNom());
		System.out.println(" Prenom : " + employe.getPrenom());
		System.out.println(" Courriel : " + employe.getCourriel());
		System.out.println(" Age : " + employe.getAge());
		System.out.println(" Fonction : " + employe.getFonction());
		System.out.println(" Telephone : " + employe.getTelephone());
		System.out.println(" Adresse : " + employe.getAdresse());
		session.close();
		return employe;
	}

	protected void update(long id, Employees NewEmploye) {
		// Permet de mettre à jour un enregistrement
		Employees employe = this.read(id);
		if (NewEmploye.getNom() != null) {
			employe.setNom(NewEmploye.getNom());
		}
		if (NewEmploye.getPrenom() != null) {
			employe.setPrenom(NewEmploye.getPrenom());
		}
		if (NewEmploye.getAge() != employe.getAge()) {
			employe.setAge(NewEmploye.getAge());
		}
		if (NewEmploye.getCourriel() != null) {
			employe.setCourriel(NewEmploye.getCourriel());
		}
		if (NewEmploye.getFonction() != null) {
			employe.setFonction(NewEmploye.getFonction());
		}
		if (NewEmploye.getTelephone() != employe.getTelephone()) {
			employe.setTelephone(NewEmploye.getTelephone());
		}

		if (NewEmploye.getAdresse() != null) {
			employe.setAdresse(NewEmploye.getAdresse());
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(employe);
		session.getTransaction();
		session.close();

	}

	protected void delete(Employees employe) {
		// Permet de supprimer un salarié dans la BDD
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(employe);
		session.getTransaction().commit();
		session.close();
	}

	protected List <Employees> maListe = new ArrayList<Employees>(); 
	protected static void afficherTous() {
		// NON FONCTIONNELLE //
		
		// Ici on veut afficher la liste de tous les employés de la base de données SANS faire de query à la BDD
			// Etapes : 
		// 1.On créé une liste d'objet vide qui repertoriera l'ensemble des salariés
		// 2. à chaque push dans la bdd (fonction create) on veut aussi push aussi dans la liste
		// 3. Enfin on affichera la liste : 
		
	     // Créer un ArrayList<String>

// Tentative de récupération de la liste
	    Employees.add("test1");
	    
	    int size = Employees.size();
	    Employees.add("test2");
	     for(int i = 0; i< Employees.size ;i++)
	        System.out.println(employeeList1.get(i));
	  }
		

	public static void main(String[] args) {
//		EmployeesManager manager = new EmployeesManager();
//		manager.setup();
		
// TERRAIN DE JEU POUR TESTER LES FONCTIONS

		EmployeesManager.afficherTous();
//	manager.create();
//		manager.read(1);
//		Employees employe = manager.read(1);		
//		manager.delete(employe);
//		manager.update(id, book);
//		manager.exit();

	}
}
