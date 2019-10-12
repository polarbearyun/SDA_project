package com.shopping_mall.datatransfer;

import com.shopping_mall.entity.Address;
import com.shopping_mall.entity.User;
import com.shopping_mall.mapper.AddressMapper;
import com.shopping_mall.mapper.UserMapper;

import java.util.List;

public class UserAssembler {

    public static UserDTO createUserDTO(User user) {

        UserDTO result = new UserDTO();

        int id = user.getId();
        String name = user.getName();
        String email = user.getEmail();
        String phone = user.getPhone();
        String password = user.getPassword();
        int type = user.getType();

        Address address = user.getAddress();
        String address_detail = address.getAddress();
        String state = address.getState();
        String post_code = address.getPost_code();

        result.setId(id);
        result.setName(name);
        result.setEmail(email);
        result.setPhone(phone);
        result.setPassword(password);
        result.setType(type);
        result.setAddress(address_detail);
        result.setState(state);
        result.setPost_code(post_code);

        return result;
    }

    public static void updateUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());
        user.setType(userDTO.getType());


        Address address = new Address();
        String address_detail = userDTO.getAddress();
        String state = userDTO.getState();
        String post_code = userDTO.getPost_code();
        address.setAddress(address_detail);
        address.setState(state);
        address.setPost_code(post_code);


        UserMapper mapper = new UserMapper();
        mapper.update(user);
    }
}
