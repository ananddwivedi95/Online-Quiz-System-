package com.quizmaster.controller;

import com.quizmaster.model.QuizAttempt;
import com.quizmaster.service.QuizAttemptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attempts")
public class QuizAttemptController {
    private final QuizAttemptService attemptService;

    public QuizAttemptController(QuizAttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @PostMapping("/start/{quizId}")
    public ResponseEntity<?> startQuiz(@PathVariable Long quizId) {
        return ResponseEntity.ok(attemptService.startQuiz(quizId));
    }

    @PostMapping("/submit/{attemptId}")
    public ResponseEntity<?> submitQuiz(
            @PathVariable Long attemptId,
            @RequestBody QuizAttempt attempt) {
        return ResponseEntity.ok(attemptService.submitQuiz(attemptId, attempt));
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserAttempts() {
        return ResponseEntity.ok(attemptService.getUserAttempts());
    }
}