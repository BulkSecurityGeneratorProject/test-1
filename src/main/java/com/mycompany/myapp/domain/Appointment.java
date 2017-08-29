package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Appointment.
 */
@Entity
@Table(name = "appointment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "appointment")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date_time", nullable = false)
    private ZonedDateTime dateTime;

    @Size(min = 2, max = 20)
    @Column(name = "jhi_label", length = 20)
    private String label;

    @NotNull
    @Column(name = "is_recurring", nullable = false)
    private Boolean isRecurring;

    @Lob
    @Column(name = "notes")
    private String notes;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Customer customer;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Activity activityBooked;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Location location;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private User provider;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public Appointment dateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLabel() {
        return label;
    }

    public Appointment label(String label) {
        this.label = label;
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean isIsRecurring() {
        return isRecurring;
    }

    public Appointment isRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
        return this;
    }

    public void setIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    public String getNotes() {
        return notes;
    }

    public Appointment notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Appointment customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Activity getActivityBooked() {
        return activityBooked;
    }

    public Appointment activityBooked(Activity activity) {
        this.activityBooked = activity;
        return this;
    }

    public void setActivityBooked(Activity activity) {
        this.activityBooked = activity;
    }

    public Location getLocation() {
        return location;
    }

    public Appointment location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getProvider() {
        return provider;
    }

    public Appointment provider(User user) {
        this.provider = user;
        return this;
    }

    public void setProvider(User user) {
        this.provider = user;
    }
    // jhipster-needle-entity-add-getters-setters - Jhipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Appointment appointment = (Appointment) o;
        if (appointment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), appointment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "id=" + getId() +
            ", dateTime='" + getDateTime() + "'" +
            ", label='" + getLabel() + "'" +
            ", isRecurring='" + isIsRecurring() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
