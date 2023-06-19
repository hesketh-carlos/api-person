package br.com.hesketh.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PersonDto {
    private Long id;
    private String name;
}