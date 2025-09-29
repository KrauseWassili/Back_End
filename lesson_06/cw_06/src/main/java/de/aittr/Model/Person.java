package de.aittr.Model;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode //
public class Person {
    private final String name;
    private String email;
    private final int age;
    @Singular
    private List<String> nicknames;

}
