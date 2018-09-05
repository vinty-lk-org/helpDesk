package itacademy.domain.entity;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Problem {
    private Long id;
    private String name;

    public Problem(Long id) {
        this.id = id;
    }

    public Problem(String name) {
        this.name = name;
    }
}