package itacademy.domain.entity;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class TargetOfJob {
    private Long id;
    private String name;

    public TargetOfJob(String name) {
        this.name = name;
    }
}
