package br.com.fcxlabs.hermes.repositories;

import br.com.fcxlabs.hermes.entities.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization,Long> {
}
