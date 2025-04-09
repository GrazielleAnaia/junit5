package com.grazielleanaia.junit5.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "registrationDate")
    private LocalDateTime registrationDate;

    @Column(name = "update")
    private LocalDateTime update;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "residence_id", referencedColumnName = "id")
    private ResidenceEntity residence;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(document, that.document) &&
                Objects.equals(registrationDate, that.registrationDate) &&
                Objects.equals(update, that.update);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, document, registrationDate, update);
    }


}
