package se.bahram.cloudnative.siteclickservice.click.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.bahram.cloudnative.siteclickservice.click.models.Click;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class ClickController {

    @PostMapping("/")
    protected ResponseEntity<Click> click(@RequestBody Click click) {
        // TODO: Validation
        if (isValid(click)) {
            return ResponseEntity.ok(click);
        }
        return ResponseEntity.badRequest().build();
    }

    private boolean isValid(Click click) {
        if (click == null) {
            return false;
        }
        return !Objects.isNull(click.getClientCode()) && !Objects.isNull(click.getActualClickTime()) && !Objects.isNull(click.getAdCode()) && !Objects.isNull(click.getHostUrl());
    }
}
