package org.rtroncoso.testnisum.dto;

import lombok.Data;
import org.rtroncoso.testnisum.utils.Constants;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class RegisterUserDTO {

    @NotEmpty(message = "El nombre es requerido.")
    private String name;
    @NotEmpty(message = "El email es requerido.")
    @Email(regexp = Constants.EMAIL_PATTERN, message = "El email es invalido.")
    private String email;
    @NotEmpty(message = "El password es requerido.")
    private String password;

    @Valid
    private List<PhoneDTO> phones;
}
