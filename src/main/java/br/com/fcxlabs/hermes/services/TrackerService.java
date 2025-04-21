package br.com.fcxlabs.hermes.services;

import br.com.fcxlabs.hermes.dtos.tracker.saveTrackerRequest;
import br.com.fcxlabs.hermes.entities.Tracker;
import br.com.fcxlabs.hermes.repositories.TrackerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrackerService {
    private TrackerRepository trackerRepository;

    public TrackerService(TrackerRepository trackerRepository) {
        this.trackerRepository = trackerRepository;
    }

    public Tracker findById(Long id) {
        return trackerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tracker not found"));
    }

    public Tracker saveTracker(saveTrackerRequest request) {
        Tracker tracker = new Tracker();
        tracker.setName(request.name());
        return trackerRepository.save(tracker);
    }
}
