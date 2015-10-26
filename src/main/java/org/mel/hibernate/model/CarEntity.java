package org.mel.hibernate.model;


import javax.persistence.*;

@Entity
@Table(name = "car")
@NamedNativeQueries({
        @NamedNativeQuery(name = "CarEntity.findCarByCompany",
                query = "SELECT carId, company, model, price"
                        + " FROM car"
                        + " WHERE company = ?",
                resultClass = CarEntity.class)
})
public class CarEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "carId")
    private Long id;

    @Column(name = "company")
    private String company;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Long price;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }



}