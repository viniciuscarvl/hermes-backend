package br.com.fcxlabs.hermes.repositories;

import br.com.fcxlabs.hermes.entities.Sequential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequentialRepository extends JpaRepository<Sequential, Long> {
}
