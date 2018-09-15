package itacademy.dto.models;

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
public class BranchDto implements Serializable {

  private static final long serialVersionUID = -2924089612664407591L;

  private Long id;
  private String name;
  private String address;

  public BranchDto(String name, String address) {
    this.name = name;
    this.address = address;
  }
}