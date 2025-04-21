package br.com.fcxlabs.hermes.repositories;

import br.com.fcxlabs.hermes.entities.Sequential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequentialRepository extends JpaRepository<Sequential, Long> {
}
