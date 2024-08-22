package com.example.bookstoreapi.model;

import org.springframework.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    private String password;
}