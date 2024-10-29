package org.ntnu.idi.idatt2105.project.entity.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ntnu.idi.idatt2105.project.entity.question.QuestionChoice;
import org.ntnu.idi.idatt2105.project.entity.quiz.CompletedQuiz;

/** Class representing a user answer in the application. */
@Getter
@Setter
@Entity
@Table(name = "user_answers")
@NoArgsConstructor
@Schema(description = "A user answer to a question.")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The user answer id, autogenerated by the database.")
    private Long answerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "completed_quiz_id")
    @Schema(description = "The completed quiz the answer belongs to.")
    private CompletedQuiz completedQuiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_choice_id")
    @Schema(description = "The choice the user answered.")
    private QuestionChoice questionChoice;
}
