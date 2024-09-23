package com.TenantMate.controller;

import com.TenantMate.exception.UserNotFoundException;
import com.TenantMate.payload.UserDto;
import com.TenantMate.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @RequestMapping(path = "/users/{username}",method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUserByUsername( @PathVariable(value = "username")  String username) {
        UserDto fetchedUser=userService.findUserByUsername(username);
        if(fetchedUser==null)
            throw new UserNotFoundException("user not found ");
        return new ResponseEntity<>(fetchedUser, HttpStatus.OK);
    }
    @RequestMapping(path = "/users/id/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUserById( @PathVariable(value = "id")  int id) {
        UserDto fetchedUser=userService.findUserById(id);
        if(fetchedUser==null)
            throw new UserNotFoundException("user not found");
        return new ResponseEntity<>(fetchedUser, HttpStatus.OK);
    }

    @RequestMapping(path = "/users",method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> fetchedUsers=userService.getAllUsers();
        if(fetchedUsers==null)
            throw new UserNotFoundException("users not found");
        return new ResponseEntity<>(fetchedUsers, HttpStatus.OK);
    }

    @RequestMapping(path = "/users/activeusers",method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAllActiveUsers() {
        List<UserDto> fetchedUsers=userService.getAllActiveUsers();
        if(fetchedUsers==null)
            throw new UserNotFoundException("users not found");
        return new ResponseEntity<>(fetchedUsers, HttpStatus.OK);
    }

    @RequestMapping(path = "/users/inactiveusers",method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAllInactiveUsers() {
        List<UserDto> fetchedUsers=userService.getAllInActiveUsers();
        if(fetchedUsers==null)
            throw new UserNotFoundException("users not found");
        return new ResponseEntity<>(fetchedUsers, HttpStatus.OK);
    }

    @RequestMapping(path = "/users/update/admin/{username}",method = RequestMethod.GET)
    public ResponseEntity<UserDto> updateUserByUsernameAdmin( @PathVariable(value = "username")  String username) {
        UserDto fetchedUser=userService.findUserByUsername(username);
        if(fetchedUser==null)
            throw new UserNotFoundException("user not found");
        return new ResponseEntity<>(fetchedUser, HttpStatus.OK);
    }


    @RequestMapping(path = "/users/update/admin/{username}",method = RequestMethod.PUT)
    public ResponseEntity<UserDto> updateUserByUsernameAdmin( @PathVariable(value = "username")  String username,@Valid @RequestBody UserDto userDto) {
       UserDto updatedUserDto =userService.updateTenantAdmin(userDto,username);

        return new ResponseEntity<>(updatedUserDto, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/users/update/{username}",method = RequestMethod.PUT)
    public ResponseEntity<UserDto> updateUserByUsernameTenant( @PathVariable(value = "username")  String username,@Valid @RequestBody UserDto userDto) {
        UserDto updatedUserDto =userService.updateTenant(userDto,username);

        return new ResponseEntity<>(updatedUserDto, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/users/create",method = RequestMethod.POST)
    public ResponseEntity<UserDto> createUser( @Valid @RequestBody  UserDto userDto) {
        UserDto createdUserDto =userService.CreateUser(userDto);

        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }







}
