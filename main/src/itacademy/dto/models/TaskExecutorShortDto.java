package itacademy.dto.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor

@Builder
public class TaskExecutorShortDto {

    private Long idTask;
    private String taskName;
    private String userName;
    private String userFamily;
    private String subdivision;
    private String status;

    public TaskExecutorShortDto(Long idTask, String taskName, String userName, String userFamily, String subdivision, String status) {
        this.idTask = idTask;
        this.taskName = taskName;
        this.userName = userName;
        this.userFamily = userFamily;
        this.subdivision = subdivision;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Страница{" +
                "Номер=" + idTask +
                ", Имя='" + taskName + '\'' +
                ", userName='" + userName + '\'' +
                ", userFamily='" + userFamily + '\'' +
                ", subdivision='" + subdivision + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}