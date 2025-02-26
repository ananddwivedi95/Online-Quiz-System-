package com.quizmaster.repository;

import com.quizmaster.model.QuizAttempt;
import com.quizmaster.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {
    List<QuizAttempt> findByUser(User user);
}