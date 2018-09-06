package itacademy.dto.models;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String name;
    private String text;


    public TaskDto(TaskDto build) {
        this.name = build.getName();
        this.text = build.getText();
    }
}
