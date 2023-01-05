package io04.trainschedule.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class User {
    private final Integer id;
    @NotEmpty
    private final String name;
    //private final String password;
    private final String email;

}
