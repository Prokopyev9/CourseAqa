package models;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class People {
    private String name;
    private Integer age;
    private String sex;
}
