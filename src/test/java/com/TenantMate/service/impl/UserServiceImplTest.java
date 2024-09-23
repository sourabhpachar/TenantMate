package com.TenantMate.service.impl;

import com.TenantMate.payload.UserDto;
import com.TenantMate.repository.UserRepository;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserRepository repository;

    @Autowired
    UserServiceImpl userService;

UserDto userDto=new UserDto("navjo","sdf",900993,"asfasdf",2134123,null,"afgafg2342sfg",3,true,"vijay pg 1",7500,"sd@gnnaxfjjjjvjsdffgsfsefal.ocvm");

    void createUser(@Valid UserDto userDto6)
    {
     UserDto userdto =userService.CreateUser( userDto6);
        System.out.println(userdto.toString());
    }

    @Test
            void duunni() {
        createUser(userDto);
    }


    @Test
     void findUserByIdMethodTest( )
    {

      UserDto userDto=userService.findUserById(1);
        System.out.println(userDto);
    }

    @Test
    void getAllusersMethodTest( )
    {

       List< UserDto> userDtos=userService.getAllUsers();
        System.out.println(userDtos);
    }

    @Test
    void getAllActiveusersMethodTest( )
    {

        List< UserDto> userDtos=userService.getAllActiveUsers();
        System.out.println(userDtos);
    }

    @Test
    void getAllInActiveusersMethodTest( )
    {

        List< UserDto> userDtos=userService.getAllInActiveUsers();
        System.out.println(userDtos);
    }

    @Test
    void updateTenantAdminTest()
    {

        UserDto userDto= new UserDto("navjot singh sidhu","sdf",900993,"asfasdf",2134123,null,"afgafg2342sfg",3,true,"vijay pg 1",7500,"sd@gnnasdffgsfal.ocvm");
        UserDto updatedUserDto=userService.updateTenantAdmin(userDto,userDto.getEmail());
        System.out.println(updatedUserDto);
    }

    @Test
    void updateTenantTest()
    {
        String userName="sd@gnnasdffgsfal.ocvm";
        UserDto userDto= new UserDto("bathinda se hai",124234245,235346);
        UserDto updatedUserDto=userService.updateTenantAdmin(userDto,userName);
        System.out.println(updatedUserDto);
    }

@Test
  void   findUserByUsername(){
    UserDto userDto=userService.findUserByUsername("sd@gnnasdffgsfal.ocvm");
    System.out.println(userDto);
}

        



}