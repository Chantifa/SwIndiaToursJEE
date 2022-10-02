package ch.swindiatours.model;
import jakarta.persistence.*;

@Entity
@Table(name = "TOUR", schema = "TOURS")
@NamedQueries({
        @NamedQuery(name = "Tour.findAll", query = "SELECT p FROM Tour p"),
        @NamedQuery(name = "Tour.findById", query = "SELECT p FROM Tour p WHERE p.id = :id"),
        @NamedQuery(name = "Tour.findByName", query = "SELECT p FROM Tour p WHERE p.name = :name"),
        @NamedQuery(name = "Tour.findByDescription", query = "SELECT p FROM Tour p WHERE p.name = :description"),
        @NamedQuery(name = "Tour.findByPrice", query = "SELECT p FROM Tour p WHERE p.price = :price")})


public class Tour {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private Double price;

    public Tour() {
    }

    public Tour(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Tour)) {
            return false;
        }

        Tour other = (Tour) object;

        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Tour: ");
        sb.append(getName()).append(" Price: ").append(getPrice().toString());

        return sb.toString();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
