package com.web.app.servis;

import com.web.app.dto.DTOReq.UserDTOReq;
import com.web.app.dto.DTORes.UserDTORes;

import java.util.List;

public interface UserServis {
    UserDTORes createUser(UserDTOReq userDTOReq);
    UserDTORes getUserById(Long id);
    List<UserDTORes> getAllUsers();
    void deleteUser(Long id);

}
