package com.e_vangelio.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ErrorResponse {
    private String message;
}