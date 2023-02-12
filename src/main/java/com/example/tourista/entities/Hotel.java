package com.example.tourista.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String shortDescription;
    @Column(nullable = false)
    private String longDescription;
    @Column(nullable = false)
    private String imageLink;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String experience;
    @Column(nullable = false)
    private String pool;
    @Column(nullable = false)
    private String price;

}
