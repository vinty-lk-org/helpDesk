package itacademy.domain.entity;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Task {
    private Long id;
    private String name;
    private TargetOfJob targetOfJobId;
    private String text;
    private SystemUser systemUserId;
    private SystemUser executorId;
    private SystemUser operatorId;
}
