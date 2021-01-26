package com.rl.ref.rediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public User add(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/all")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        Optional<User> optCustomer = userRepository.findById(id.toString());
        if (optCustomer.isPresent())
            return optCustomer.get();
        else
            return null;
    }

/*    @GetMapping("user/{name}")
    public User findByName(@PathVariable("name") String name) {
        //Todo fix this with user name
        User optCustomer = userRepository.findById((name)).get();
      return optCustomer;
    }*/
}
