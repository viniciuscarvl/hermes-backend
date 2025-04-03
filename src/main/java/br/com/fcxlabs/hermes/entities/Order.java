package br.com.fcxlabs.hermes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Order {
    @Id
    private int id;
}
