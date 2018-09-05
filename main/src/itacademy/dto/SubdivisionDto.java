package itacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubdivisionDto implements Serializable {
  private static final long serialVersionUID = -1693953400106934438L;
  private Long id;
  private String name;

  public SubdivisionDto(String name) {
    this.name = name;
  }
}
