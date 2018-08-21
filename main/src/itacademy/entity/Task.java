package itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
