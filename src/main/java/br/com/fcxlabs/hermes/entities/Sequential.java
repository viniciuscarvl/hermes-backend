package br.com.fcxlabs.hermes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "sequentials")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sequential {
    @Id
    private int id;
    @OneToOne
    private Vehicle vehicle;
    @OneToMany
    private List<Order> orders;
    private boolean fineshed;
}
