package itacademy.dto.views;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class TaskViewUserDto {
    private Long id;
    private String name;
   private Long systemUserId;
   private String listinerName;
   private String statusName;
}
