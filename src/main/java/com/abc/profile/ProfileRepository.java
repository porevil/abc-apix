package com.abc.profile;

import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * Created by cadet on 1/23/2018 AD.
 */
public interface ProfileRepository extends MongoRepository<Profile, Long>{

    Profile findByUserId(String userId);


}
