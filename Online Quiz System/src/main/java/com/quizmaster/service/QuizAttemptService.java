package com.quizmaster.service;

import com.quizmaster.model.Quiz;
import com.quizmaster.model.QuizAttempt;
import com.quizmaster.model.User;
import com.quizmaster.repository.QuizAttemptRepository;
import com.quizmaster.security.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizAttemptService {
    private final QuizAttemptRepository attemptRepository;
    private final QuizService quizService;

    public QuizAttemptService(QuizAttemptRepository attemptRepository, QuizService quizService) {
        this.attemptRepository = attemptRepository;
        this.quizService = quizService;
    }

    public QuizAttempt startQuiz(Long quizId) {
        Quiz quiz = quizService.getQuiz(quizId);
        User user = getCurrentUser();

        QuizAttempt attempt = new QuizAttempt();
        attempt.setQuiz(quiz);
        attempt.setUser(user);
        attempt.setStartedAt(LocalDateTime.now());
        attempt.setCompleted(false);

        return attemptRepository.save(attempt);
    }

    public QuizAttempt submitQuiz(Long attemptId, QuizAttempt submittedAttempt) {
        QuizAttempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new RuntimeException("Attempt not found"));

        attempt.setAnswers(submittedAttempt.getAnswers());
        attempt.setScore(calculateScore(attempt));
        attempt.setCompleted(true);
        attempt.setCompletedAt(LocalDateTime.now());

        return attemptRepository.save(attempt);
    }

    public List<QuizAttempt> getUserAttempts() {
        return attemptRepository.findByUser(getCurrentUser());
    }

    private User getCurrentUser() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User user = new User();
        user.setId(userPrincipal.getId());
        return user;
    }

    private Integer calculateScore(QuizAttempt attempt) {
        // Implement score calculation logic based on correct answers
        return 0; // Placeholder
    }
}