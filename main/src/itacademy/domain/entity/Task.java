package itacademy.domain.entity;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor

public class Task {
    private Long id;
    private String name;
    private TargetOfJob targetOfJobId;
    private String text;
    private SystemUser systemUserId;
    private SystemUser executorId;
    private SystemUser operatorId;

    public Task(Long id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Task(Long id, String name, String text, SystemUser systemUserId) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.systemUserId = systemUserId;
    }

    public Task(Long id, String name, TargetOfJob targetOfJobId, String text, SystemUser systemUserId, SystemUser executorId, SystemUser operatorId) {
        this.id = id;
        this.name = name;
        this.targetOfJobId = targetOfJobId;
        this.text = text;
        this.systemUserId = systemUserId;
        this.executorId = executorId;
        this.operatorId = operatorId;


    }
}
