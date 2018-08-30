package itacademy.domain.entity;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Task {
    private Long id;
    private String name;
    private String text;
    private TypeOfJob typeOfJob;
    private Listener targetOfJobId;
    private SystemUser systemUserId;
    private SystemUser executorId;
    private SystemUser operatorId;

}
