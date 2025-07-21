package br.com.fcxlabs.hermes.services;

import br.com.fcxlabs.hermes.entities.Localization;
import br.com.fcxlabs.hermes.repositories.LocalizationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class LocalizationService {
    private LocalizationRepository localizationRepository;
    private ObjectMapper objectMapper;

    public LocalizationService(LocalizationRepository localizationRepository, ObjectMapper objectMapper) {
        this.localizationRepository = localizationRepository;
        this.objectMapper = objectMapper;
    }

    public void saveLocalization(String payload) throws JsonProcessingException {
        Localization localization = this.objectMapper.readValue(payload, Localization.class);
        localizationRepository.save(localization);
    }

    public Localization getLastLocalizationByTrackerId(Long trackerId) {
        return localizationRepository.findAll()
                .stream()
                .filter(localization -> localization.getId().equals(trackerId))
                .reduce((first, second) -> second)
                .orElseThrow(() -> new RuntimeException("No localization found for tracker ID: " + trackerId));
    }
}
