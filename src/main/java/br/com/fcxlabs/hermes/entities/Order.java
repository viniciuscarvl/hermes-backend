package br.com.fcxlabs.hermes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private Long id;
    private boolean delivered;
}
