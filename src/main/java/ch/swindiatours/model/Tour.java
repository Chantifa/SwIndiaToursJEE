package ch.swindiatours.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "Tour")
@NamedQueries({
        @NamedQuery(name = "tour.findAll", query = "SELECT p FROM Tour p"),
        @NamedQuery(name = "tour.findById", query = "SELECT p FROM Tour p WHERE p.tourId = :id"),
        @NamedQuery(name = "tour.findByTitle", query = "SELECT p FROM Tour p WHERE p.title = :name"),
        @NamedQuery(name = "tour.findByDescription", query = "SELECT p FROM Tour p WHERE p.description = :description"),
        @NamedQuery(name = "tour.findByPrice", query = "SELECT p FROM Tour p WHERE p.price = :price")})

public class Tour {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tourId")
    @NotNull
    private Long tourId;
    @Column(name = "title")
    @NotNull
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Lob
    @Column(name = "img")
    private byte[] img;



    public Tour() {
    }
    public Long getId() {
        return tourId;
    }

    public void setId(Long tourId) {
        this.tourId = tourId;
    }

    public String getTitel() {
        return title;
    }

    public void setTitel(String title){
        this.title= title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourId != null ? tourId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Tour)) {
            return false;
        }

        Tour other = (Tour) object;

        return !((this.tourId == null && other.tourId != null) || (this.tourId != null && !this.tourId.equals(other.tourId)));
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Tour: ");
        sb.append(getTitel()).append(" Price: ").append(getPrice().toString());

        return sb.toString();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public byte[] getImg() {
        return img;
    }
    public void setImg(byte[] img) {
        this.img = img;
    }
}
