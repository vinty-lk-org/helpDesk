package itacademy.dto.models;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
    private String name;
    private Long listenerId;
    private String text;
    private Long systemUserId;
    private Long statusId;

    public TaskDto(TaskDto build) {
        this.name = build.getName();
        this.listenerId = build.getListenerId();
        this.text = build.getText();
        this.systemUserId = build.getSystemUserId();
        this.statusId = build.getStatusId();
    }
}