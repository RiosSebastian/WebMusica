package com.web.app.servis.servisImpl;


import com.web.app.dto.DTOReq.UserDTOReq;
import com.web.app.dto.DTORes.UserDTORes;
import com.web.app.entity.UserEntity;
import com.web.app.repository.UserRepository;
import com.web.app.servis.UserServis;
import com.web.app.util.UserEnum;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class UserServisImpl implements UserServis {

    private final UserRepository userRepository;

    @Override
    public UserDTORes createUser(UserDTOReq userDTOReq) {
        UserEntity userEntity = UserEntity.builder()
                .nombreUsuario(userDTOReq.nombreUsuario())
                .email(userDTOReq.email())
                .password(userDTOReq.password())
                .userEnum(UserEnum.valueOf(userDTOReq.userEnum()))
                .build();

        userEntity = userRepository.save(userEntity);
        return mapToDTORes(userEntity);
    }

    @Override
    public UserDTORes getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado con id: " + id));
        return mapToDTORes(userEntity);
    }

    @Override
    public List<UserDTORes> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToDTORes)
                .toList();
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("Usuario no encontrado con id: " + id);
        }
        userRepository.deleteById(id);
    }

    private UserDTORes mapToDTORes(UserEntity userEntity) {
        return new UserDTORes(
                userEntity.getId(),
                userEntity.getNombreUsuario(),
                userEntity.getEmail()
        );
    }
}

