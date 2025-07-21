package br.com.fcxlabs.hermes.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "LOCALIZATIONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocalization;
    private Long id;
    private String name;
    private LocalDateTime dateTime;
    private Double latitude;
    private Double longitude;
}
