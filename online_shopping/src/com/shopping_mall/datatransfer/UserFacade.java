package com.shopping_mall.datatransfer;

import com.shopping_mall.entity.User;
import com.shopping_mall.mapper.UserMapper;

public class UserFacade {
    public UserDTO getUser(int id) {
        User user = UserMapper.findUserById(id);
        UserDTO dto = UserAssembler.createUserDTO(user);
        return dto;
    }
    public void updateUser(UserDTO userDTO) {
        UserAssembler.updateUser(userDTO);
    }
    public String getUserJSON(int id) {
        User user = UserMapper.findUserById(id);
        UserDTO dto = UserAssembler.createUserDTO(user);
        return UserDTO.serialize(dto);
    }
    public void updateUserJSON(String json) {
        UserDTO userDTO = UserDTO.deserialize(json);
        UserAssembler.updateUser(userDTO);
    }
}
