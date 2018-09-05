package itacademy.generic.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TargetOfJobDto {
  private static final String TABLE_NAME = "listeners";
  private Long id;
  private String name;
}
