package com.apps.harsh.controller;

import com.apps.harsh.model.Question;
import com.apps.harsh.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestions(@PathVariable String surveyId) {
        return surveyService.retrieveQuestions(surveyId);
    }

    // GET "/surveys/{surveyId}/questions/{questionId}"
    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveDetailsForQuestion(@PathVariable String surveyId,
                                               @PathVariable String questionId) {
        return surveyService.retrieveQuestion(surveyId, questionId);
    }

    // /surveys/{surveyId}/questions
    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<Void> addQuestionToSurvey(
            @PathVariable String surveyId, @RequestBody Question newQuestion) {

        Question question = surveyService.addQuestion(surveyId, newQuestion);

        if (question == null)
            return ResponseEntity.noContent().build();

        // Success - URI of the new resource in Response Header
        // Status - created
        // URI -> /surveys/{surveyId}/questions/{questionId}
        // question.getQuestionId()
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(question.getId()).toUri();

        // Status
        return ResponseEntity.created(location).build();
    }

}
