package com.luv2code.spring_boot_library.requestmodels;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequest {

    private Double rating;

    private Long bookId;

    private Optional<String> reviewDescription;
}
