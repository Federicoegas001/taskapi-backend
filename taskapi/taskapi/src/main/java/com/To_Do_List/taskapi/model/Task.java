package com.To_Do_List.taskapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Data
@Entity
@DynamicUpdate // Esto hace que mandes a la base de datos solo los campos que cambniaste
//Imaginá que tenés un formulario con 10 campos y solo cambiaste el nombre.
//
//Sin @DynamicUpdate → mandás los 10 campos aunque 9 sean iguales
//Con @DynamicUpdate → mandás solo el campo que cambió
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Column(nullable = false)
    private String title;

    private String description;

    @NotNull(message = "El título es obligatorio")
    @Column(nullable = false)
    private Boolean completed = false;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}