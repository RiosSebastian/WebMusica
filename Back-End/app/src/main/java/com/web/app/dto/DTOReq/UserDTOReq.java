package com.web.app.dto.DTOReq;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

public record UserDTOReq(
                          @NonNull
                          @Size(min = 3, max = 20)
                          String nombreUsuario,
                          //@NonNull
                          //@Size(min = 4, message = "La contraseña debe tener al menos 8 caracteres")
                          //@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=])(?=\\S+$).{8,}$",
                          //message = "La contraseña debe contener al menos un dígito, una letra minúscula, una letra mayúscula y un carácter especial.")
                           String password,
                          @NonNull
                          @Email
                          String email,
                          String userEnum) {
}
