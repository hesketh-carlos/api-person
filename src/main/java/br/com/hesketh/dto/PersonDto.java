package br.com.hesketh.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PersonDto {

    @NotBlank
    @Size(min = 10, max = 255)
    private String name;

    @NotBlank
    @Size(min = 1, max = 11)
    private String document;

    @NotBlank
    @Size(min = 1, max = 20)
    private String documenttype;

    @NotBlank
    @Size(min = 3, max = 3)
    private String documentcountry;

    @Size(min = 10, max = 255)
    private String fathername;

    @Size(min = 10, max = 255)
    private String mothername;

    @Size(min = 2, max = 3)
    private String bloodtype;

    @Size(min = 3, max = 3)
    private String birthcountry;

    @Size(min = 10, max = 255)
    private String birthcity;

    private String birthdate;

}