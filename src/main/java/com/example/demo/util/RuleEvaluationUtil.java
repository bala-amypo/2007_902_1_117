// package com.example.demo.util;

// import java.util.List;

// public class RuleEvaluationUtil {

//     private RuleEvaluationUtil() {}

//     // Generic rule check (no LoginEvent dependency)
//     public static boolean hasMultipleFailures(List<Boolean> loginResults) {
//         long failedCount = loginResults.stream()
//                 .filter(success -> !success)
//                 .count();
//         return failedCount >= 3;
//     }
// }
