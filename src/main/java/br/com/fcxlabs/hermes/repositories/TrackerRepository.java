package br.com.fcxlabs.hermes.repositories;

import br.com.fcxlabs.hermes.entities.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackerRepository extends JpaRepository<Tracker, Long> {
}
