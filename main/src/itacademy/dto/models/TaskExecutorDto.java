package itacademy.dto.models;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
public class   TaskExecutorDto {

    private Long taskId;
    private String taskName;
    private String text;
    private Long systemUserId;
    private String systemUserName;
    private String systemUserFamily;
    private Long subdivisionId;
    private String subdivisionName;
    private Long statusId;
    private String statusName;
    private Long executorId;
    private Long operatorId;

    public TaskExecutorDto(Long taskId, String taskName, String text, Long systemUserId, String systemUserName, String systemUserFamily, Long subdivisionId, String subdivisionName, Long statusId, String statusName, Long executorId, Long operatorId) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.text = text;
        this.systemUserId = systemUserId;
        this.systemUserName = systemUserName;
        this.systemUserFamily = systemUserFamily;
        this.subdivisionId = subdivisionId;
        this.subdivisionName = subdivisionName;
        this.statusId = statusId;
        this.statusName = statusName;
        this.executorId = executorId;
        this.operatorId = operatorId;
    }

    public TaskExecutorDto(Long taskId, Long statusId) {
        this.taskId = taskId;
        this.statusId = statusId;
    }


}