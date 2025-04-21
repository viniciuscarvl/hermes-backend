package br.com.fcxlabs.hermes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "SEQUENTIALS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sequential {
    @Id
    private Long id;
    @OneToOne
    private Vehicle vehicle;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;
    private boolean finished;
}
