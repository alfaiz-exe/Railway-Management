//This Train class is a POJO / model represents train
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;
@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
