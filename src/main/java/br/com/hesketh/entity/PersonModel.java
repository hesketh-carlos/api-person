package br.com.hesketh.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "person", schema = "public")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "document", nullable = false, length = 20)
    private String document;

    @Column(name = "documenttype", nullable = false, length = 20)
    private String documenttype;

    @Column(name = "documentcountry", nullable = false, length = 20)
    private String documentcountry;

    @Column(name = "fathername", nullable = true, length = 255)
    private String fathername;

    @Column(name = "mothername", nullable = true, length = 255)
    private String mothername;

    @Column(name = "bloodtype", nullable = true, length = 3)
    private String bloodtype;

    @Column(name = "birthcountry", nullable = true, length = 3)
    private String birthcountry;

    @Column(name = "birthcity", nullable = true, length = 255)
    private String birthcity;

    @Column(name = "birthdate", nullable = false)
    private LocalDateTime birthdate;

    @Column(name = "registrationdate", nullable = false)
    private LocalDateTime registrationdate;



}
