package itacademy.dto.models;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder

public class ExecutorAppointDto {
private Long id;
private String name;
private String family;

    public ExecutorAppointDto(Long id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }
}