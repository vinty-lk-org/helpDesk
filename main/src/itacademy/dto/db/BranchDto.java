package itacademy.dto.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BranchDto {
  private static final String TABLE_NAME = "branches";
  private Long id;
  private String name;
}
