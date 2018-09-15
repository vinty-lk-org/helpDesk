package itacademy.dto.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Builder
public class TaskOperatorShortDto {

    private Long idTask;
    private String taskName;
    private String userName;
    private String userFamily;
    private String subdivision;
    private String status;

    public TaskOperatorShortDto(Long idTask, String taskName, String userName, String userFamily, String subdivision, String status) {
        this.idTask = idTask;
        this.taskName = taskName;
        this.userName = userName;
        this.userFamily = userFamily;
        this.subdivision = subdivision;
        this.status = status;
    }
}