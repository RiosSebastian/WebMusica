package com.web.app.dto.DTORes;

import lombok.Builder;

@Builder
public record UserDTORes(Long id,
                          String nombreUsuario,
                         String email) {
}
