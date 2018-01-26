package com.abc.profile;

import com.abc.profile.Profile;
import com.abc.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**s
 * Created by cadet on 1/23/2018 AD.
 */
@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Profile getProfileByUserId(String userId){
        Profile profile = profileRepository.findByUserId(userId);
        return profile;

    }



}
