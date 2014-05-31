package foodServer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.mindrot.jbcrypt.BCrypt;

@Entity(name="USER")
@Table(name="USER")
@NamedQueries({
	//NamedQuery zur Auflistung aller Artikel
	@NamedQuery(name = User.FIND_USER_BY_USERNAME,
            query = "SELECT u " +
		            "FROM USER u " + 
		            "WHERE u.username = :" + User.PARAM_USERNAME)})
public class User implements Serializable{
	
	



	/**
	 * 
	 */
	private static final long serialVersionUID = -2845529237999069720L;
	
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	
	public static final String PARAM_USERNAME = "Username";
	
	public static final String FIND_USER_BY_USERNAME = "findUserByUserName";
	
	public User(){}
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	

	/**
	 * @return the username
	 */
	@Id
	@Column(name="Username")
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param id the id to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the name
	 */
	@Column(name="FirstName")
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param name the name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	@Column(name="LastName")
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	@Column(name="Password")
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */

	/**
	 * @param candidate
	 * @return true, if password candidate matches bcrypt hashed password 
	 */
	public boolean passwortCorrect(String candidate) {
		return BCrypt.checkpw(candidate, this.password);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password + "]";
	}
}
