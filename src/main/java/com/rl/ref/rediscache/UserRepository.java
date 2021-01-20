package com.rl.ref.rediscache;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByName(String name);


}
