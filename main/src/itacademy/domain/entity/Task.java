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

    public Task(long t_id, String t_name, SystemUser t_system_user_id, Listener l_name, Status s_name) {
        this.id = t_id;
        this.name = t_name;
        this.systemUserId = t_system_user_id;
        this.listener = l_name;
        this.status = s_name;
    }

    public Task(String name, Listener listener, String text,  SystemUser systemUserId, Status status) {
        this.name = name;
        this.listener = listener;
        this.text = text;
        this.systemUserId = systemUserId;
        this.status = status;
    }
}