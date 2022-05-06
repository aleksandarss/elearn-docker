package com.acalic.elearndocker.api;

import com.acalic.elearndocker.repo.Fibonacci;
import com.acalic.elearndocker.service.RogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "fib")
public class RogueResource {

    private final RogueService rogueService;

    @GetMapping(path = "{n}")
    public ResponseEntity<?> getFibonacci(@PathVariable("n") int n) {
        Fibonacci fibRes = new Fibonacci(rogueService.fib(n));
        return ResponseEntity.ok().body(fibRes);
    }


}
