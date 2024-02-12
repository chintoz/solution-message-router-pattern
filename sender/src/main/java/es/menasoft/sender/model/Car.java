package es.menasoft.sender.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String id;
    private String trademark;
    private String model;
    private String year;
    private String cv;
    private Integer price;
    private String notes;
}
