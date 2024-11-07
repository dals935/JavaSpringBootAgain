package com.example.jsbdev.mappings;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id")
//    private Address address;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private List<Address> addresses;

    @ManyToMany
    @JoinTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses;
}
