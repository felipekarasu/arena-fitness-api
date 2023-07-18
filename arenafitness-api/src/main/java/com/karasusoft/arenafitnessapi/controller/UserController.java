package com.karasusoft.arenafitnessapi.controller;

import com.karasusoft.arenafitnessapi.dto.CreateUserDto;
import com.karasusoft.arenafitnessapi.dto.UserDto;
import com.karasusoft.arenafitnessapi.enums.UserStatus;
import com.karasusoft.arenafitnessapi.facade.UserFacade;
import com.karasusoft.arenafitnessapi.model.UserModel;
import com.karasusoft.arenafitnessapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserFacade userFacade;
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDto createUser(@RequestBody @Valid CreateUserDto createUserDto) {

        return modelMapper.map(userFacade.createUser(createUserDto), UserDto.class);
    }

    @GetMapping("/{uid}")
    public UserDto getUser(@PathVariable(value = "uid") String uid) {

        return modelMapper.map(userFacade.getUser(uid), UserDto.class);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {

        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/status")
    public ResponseEntity<List<UserModel>> getUserByStatus(@RequestParam(value = "status") String userStatus) {

        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllByStatus(UserStatus.valueOf(userStatus)));
    }

    /*@PutMapping
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") String id,
                                             @RequestBody @Valid UserDto userDto) {

        Optional<UserModel> optionalUser = userService.findById(id);

        if(!optionalUser.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This user doesn't exists.");
        }

        var userModel = optionalUser.get();
        BeanUtils.copyProperties(userDto, userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userModel));
    }*/

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") String id) {

        Optional<UserModel> optionalUser = userService.findById(id);

        if(!optionalUser.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This user doesn't exists.");
        }

        userService.delete(optionalUser.get());

        return ResponseEntity.status(HttpStatus.OK).body("User removed successfully.");
    }*/
}
