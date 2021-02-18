package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user")

@NamedQuery(name = "user.findAll", query = "SELECT u FROM User u") 
public class User implements Serializable {
		
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		// Atributos del usuario
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "first_name")
		private String firstname;
		
		
		@Column(name = "last_name")
		private String lastname;
		
		
		@Column(name = "age")
		private Integer age;
		
		
		@Column(name = "nif")
		private String nif;
		
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "married", insertable = true)
		private Boolean married;
		
		

		
		// Constructor vacío
		public User () {}
		
		// Constructor lleno
		public User (Long id, String firstname, String lastname, Integer age, String nif, String email, String password, Boolean married ) {
			
		}

		
		
		// Getters & Setters
				
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		
		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		
		public String getNif() {
			return nif;
		}

		public void setNif(String nif) {
			this.nif = nif;
		}


		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		


		public Boolean getMarried() {
			return married;
		}

		public void setMarried(Boolean married) {
			this.married = married;
		}

		
		// ToString
		@Override
		public String toString() {
			return "Usuario [nº: " + id + ", con nombre " + firstname + ", y apellido " + lastname + ", de " + age + " años de edad, con NIF "
					+ nif + ". El email registrado es " + email + ", con contraseña " + password + ". En estos momentos el usuario " + married + "casado.]";
		}
		
		
		private static boolean insession;

		public static boolean isInsession() {
			return insession;
		}

		public static void setInsession(boolean insession) {
			User.insession = insession;
		}

		public void setUser(User attribute) {
			// TODO Auto-generated method stub
			
		}

	
		
		
}
