// Subcategory.java

package com.example.springbootproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "subcategory")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] imageBytes;

    private String image;

    @ManyToOne
    @JoinColumn(name = "id_categorie", nullable = false)
    private Category category;

    

    // Constructors
    public Subcategory() {
    }

    public Subcategory(String name, String image, Category category) {
        this.name = name;
        this.image = image;
        this.category = category;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
