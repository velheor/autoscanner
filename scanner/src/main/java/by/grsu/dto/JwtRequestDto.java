package by.grsu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequestDto implements Serializable {
    private static final long serialVersionUID = 2636936156391265891L;
    private String username;
    private String password;
}
