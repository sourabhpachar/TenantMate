package com.TenantMate.service.impl;

import com.TenantMate.entity.User;
import com.TenantMate.payload.UserDto;
import com.TenantMate.repository.UserRepository;
import com.TenantMate.service.UserService;
import jakarta.validation.Valid;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper mapper;


    public UserDto CreateUser(@Valid UserDto userDto){
        User newUser=this.dtoToUser(userDto);
       User savedUser =userRepository.save(newUser);
        return UserToDto(savedUser);
    }

    public UserDto findUserById (Integer id){
        Optional<User> findUser =userRepository.findById(id);

        return UserToDto(findUser.orElse(null));
    }

    public UserDto findUserByUsername(String email){
        User  findUser =userRepository.findByEmail(email);

        return UserToDto(findUser);
    }

    @Override
    public List<UserDto> getAllActiveUsers() {
        List<User> activeUsers=userRepository.findAll();
        List<UserDto>activeUsersDto;
        activeUsersDto= activeUsers.stream().filter(user -> user.isActive()).map(user ->this.UserToDto(user)).collect(Collectors.toList());
        return activeUsersDto;
    }


    @Override
    public List<UserDto> getAllInActiveUsers() {
        List<User> inActiveUsers=userRepository.findAll();
        List<UserDto>inActiveUsersDto;
        inActiveUsersDto= inActiveUsers.stream().filter(user -> !(user.isActive())).map(user ->this.UserToDto(user)).collect(Collectors.toList());
        return inActiveUsersDto;
    }



    @Override
    public UserDto updateTenantAdmin(UserDto userDto, String username) {
        User user=userRepository.findByEmail(username);
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setPhoneNo(userDto.getPhoneNo());
        user.setIdProof(userDto.getIdProof());
        user.setEmergencyContactNumber(userDto.getEmergencyContactNumber());
        user.setLeavingDate(userDto.getLeavingDate());
        user.setRoomNo(userDto.getRoomNo());
        user.setAccessCardDetails(userDto.getAccessCardDetails());
        user.setActive(userDto.isActive());
        user.setRoomNo(userDto.getRoomNo());
        user.setPropertyName(userDto.getPropertyName());
        user.setEmail(userDto.getEmail());
       User savedUser= userRepository.save(user);
       UserDto savedUserDto=this.UserToDto(savedUser);
       return savedUserDto;

    }

    @Override
    public UserDto updateTenant(UserDto userDto, String username) {

        User user=userRepository.findByEmail(username);
        user.setAddress(userDto.getAddress());
        user.setPhoneNo(userDto.getPhoneNo());
        user.setEmergencyContactNumber(userDto.getEmergencyContactNumber());
        User savedUser= userRepository.save(user);
        UserDto savedUserDto=this.UserToDto(savedUser);
        return savedUserDto;

    }


    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers=userRepository.findAll();
        List<UserDto>allUsersDto;
       allUsersDto= allUsers.stream().map(user ->this.UserToDto(user)).collect(Collectors.toList());
       return allUsersDto;
    }

    public User dtoToUser(UserDto userDto){
        User user=mapper.map(userDto,User.class);
       return user;
    }
    public UserDto UserToDto(User user){
        if(user==null)
            return null;

        UserDto userDto=mapper.map(user,UserDto.class);
        return userDto;
    }




}
