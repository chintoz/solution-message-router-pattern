package es.menasoft.sender.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
    private String surname;
    private String phone;
    private Integer age;
    private String notes;
    private String address;
    private String gender;
}
