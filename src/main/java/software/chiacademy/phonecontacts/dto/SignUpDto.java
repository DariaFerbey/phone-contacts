package software.chiacademy.phonecontacts.dto;

import lombok.Data;

import java.util.List;

@Data
public class SignUpDto {
    private String name;
    private List<String> emails;
    private List<String> phones;
    private String password;
}
