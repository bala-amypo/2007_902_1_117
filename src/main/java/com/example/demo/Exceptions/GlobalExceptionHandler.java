// package com.example.demo.exception;

// import org.springframework.http.*;
// import org.springframework.web.bind.annotation.*;

// @ControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//     }

//     @ExceptionHandler(IllegalArgumentException.class)
//     public ResponseEntity<String> handleBadRequest(Exception ex) {
//         return ResponseEntity.badRequest().body(ex.getMessage());
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<String> handleGeneric(Exception ex) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
//     }
// }
