
package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple JavaBean domain object representing a visit.
 *
 * @author Ken Krebs
 */
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    /**
     * Holds value of property date.
     */
    @Column(name = "visit_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
  	@JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
    

    /**
     * Holds value of property description.
     */
    @NotEmpty
    @Column(name = "description")
    private String description;

    /**
     * Holds value of property pet.
     */
    @ManyToOne
    @JoinColumn(name = "pet_id")
    @JsonIgnore
    private Pet pet;


    /**
     * Creates a new instance of Visit for the current date
     */
    public Visit() {
        this.date = new LocalDate();
    }


    /**
     * Getter for property date.
     *
     * @return Value of property date.
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Setter for property date.
     *
     * @param date New value of property date.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getter for property description.
     *
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for property description.
     *
     * @param description New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for property pet.
     *
     * @return Value of property pet.
     */
    public Pet getPet() {
        return this.pet;
    }

    /**
     * Setter for property pet.
     *
     * @param pet New value of property pet.
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

}
