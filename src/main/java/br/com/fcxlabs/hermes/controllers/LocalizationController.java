package br.com.fcxlabs.hermes.controllers;

import br.com.fcxlabs.hermes.services.LocalizationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping(path = "/api/v1/localizations")
public class LocalizationController {
    private LocalizationService localizationService;

    public LocalizationController(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public SseEmitter sseEmitter() {
        SseEmitter emitter = new SseEmitter();
        new Thread(() -> {
            try {
                while (true) {
                    var localization = localizationService.getLastLocalizationByTrackerId(1L);
                    emitter.send(localization);
                    Thread.sleep(5000);
                }
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        }).start();
        return emitter;
    }
}
