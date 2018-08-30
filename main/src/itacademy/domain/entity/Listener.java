package itacademy.domain.entity;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Listener {
    private Long id;
    private String name;

    public Listener(String name) {
        this.name = name;
    }

    public Listener(Long id) {
        this.id = id;
    }
}
