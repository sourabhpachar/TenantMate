package com.TenantMate.Services;

import com.TenantMate.payload.UserDto;

import java.util.List;

public interface UserService {

    public UserDto CreateUser(UserDto userDto);
    public UserDto findUserById(Integer id);
    public List<UserDto> getAllActiveUsers();

    UserDto updateTenantAdmin(UserDto userDto, String username);

    UserDto updateTenant(UserDto userDto, String username);

    public List<UserDto> getAllUsers();
    public List<UserDto> getAllInActiveUsers();





}
