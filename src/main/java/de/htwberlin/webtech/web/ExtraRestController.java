package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.ExtraService;
import de.htwberlin.webtech.web.api.Extra;
import de.htwberlin.webtech.web.api.ExtraManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ExtraRestController {

    private final ExtraService extraService;

    public ExtraRestController(ExtraService extraService) {
        this.extraService = extraService;
    }


    @GetMapping(path= "/api/v1/extras")
    public ResponseEntity<List<Extra>> fetchExtras(){
        return ResponseEntity.ok(extraService.findAll());
    }

    @PostMapping(path = "/api/v1/extras")
    public ResponseEntity<Void> createExtra(@RequestBody ExtraManipulationRequest request) throws URISyntaxException {
        var extra = extraService.create(request);
        URI uri = new URI("/api/v1/extras/" + extra.getId());
        return ResponseEntity.created(uri).build();
    }
}
