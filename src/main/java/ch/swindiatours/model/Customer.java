package ch.swindiatours.model;
import jakarta.annotation.Resource;
import jakarta.persistence.*;

@NamedQueries({
        @NamedQuery(name = "customer.getAll", query = "SELECT customer FROM Customer customer"),
        @NamedQuery(name = "customer.getById", query = "SELECT customer FROM Customer customer WHERE customer.userId = :id"),
        @NamedQuery(name = "customer.getByUsername", query = "SELECT customer FROM Customer customer WHERE customer.username = :username"),
        @NamedQuery(name = "customer.getByPassword", query = "SELECT customer FROM Customer customer WHERE customer.password = :password"),
        @NamedQuery(name = "customer.getByFristName", query = "SELECT customer FROM Customer customer WHERE customer.firstName = :firstname"),
        @NamedQuery(name = "customer.getByLastName", query = "SELECT customer FROM Customer customer WHERE customer.lastName = :lasttname"),
        @NamedQuery(name = "customer.getByEmail", query = "SELECT customer FROM Customer customer WHERE customer.email = :email")
})

@Entity
@Table(name = "Customer")
@Resource(name = "jdbc/swindiatours")
public class Customer {
    private Long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}