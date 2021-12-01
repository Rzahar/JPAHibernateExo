package entities;

import javax.persistence.*;

@Entity
@Table(name = "salaries")
public class Employees {
	// On génère les éléments d'un salarié qui reprend les éléments de la BDD
	private long id;
	private String nom;
	private String prenom;
	private String courriel;
	private int age;
	private String fonction;
	private long telephone;
	private String adresse;

	public Employees() {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.courriel = courriel;
		this.age = age;
		this.fonction = fonction;
		this.telephone = telephone;
		this.adresse = adresse;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long l) {
		this.telephone = l;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
