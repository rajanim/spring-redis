package com.rl.ref.rediscache;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class UserController2 {

    private final UserRepository userRepository;

    @Autowired
    public UserController2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId) {
        log.info("Getting user with ID {}.", userId);
        return userRepository.findById(userId).get();
    }

    @CachePut(value = "users", key = "#user.id")
    @PutMapping("/update")
    public User updatePersonByID(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @CacheEvict(value = "users", allEntries = true)
    @DeleteMapping("/{userId}")
    public void deleteUserByID(@PathVariable String userId) {
        log.info("deleting person with id {}", userId);
        userRepository.deleteById(userId);
    }
}
