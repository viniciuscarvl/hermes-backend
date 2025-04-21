package br.com.fcxlabs.hermes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRACKERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
}
