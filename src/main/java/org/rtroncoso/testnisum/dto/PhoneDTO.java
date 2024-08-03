package org.rtroncoso.testnisum.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PhoneDTO {

    @NotEmpty(message = "El numero es requerido.")
    private String number;
    @NotEmpty(message = "El codigo ciudad es requerido.")
    private String citycode;
    @NotEmpty(message = "El codigo pais es requerido.")
    private String countrycode;
}
