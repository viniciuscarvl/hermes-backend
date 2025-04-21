package br.com.fcxlabs.hermes.controllers;

import br.com.fcxlabs.hermes.dtos.tracker.saveTrackerRequest;
import br.com.fcxlabs.hermes.services.TrackerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/trackers")
public class TrackerController {
     private TrackerService trackerService;

     public TrackerController(TrackerService trackerService) {
         this.trackerService = trackerService;
     }

     @PostMapping
     public ResponseEntity<?> saveTracker(@RequestBody saveTrackerRequest request) {
         return ResponseEntity.ok(trackerService.saveTracker(request));
     }
}
