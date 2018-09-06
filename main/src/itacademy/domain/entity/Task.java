package itacademy.domain.entity;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    private Long id;
    private String name;
    private String text;
    private Listener listener;
    private SystemUser systemUserId;
    private SystemUser executorId;
    private SystemUser operatorId;
    private Status status;

    public Task(Long id, String name, String text, Listener listener, SystemUser systemUserId, Status status) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.listener = listener;
        this.systemUserId = systemUserId;
        this.status = status;
    }
}