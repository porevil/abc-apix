package com.abc.domain;

import com.abc.account.AccountInfoService;
import com.abc.profile.Profile;
import com.abc.profile.ProfileRepository;
import com.abc.profile.ProfileService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

/**
 * Created by cadet on 1/23/2018 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileTests {

/*
    @Autowired
    ProfileService service;
*/
    @Mock
    private ProfileService service;
    /*
    @Test
    public void findEqualId(){

        Profile pf = new Profile();
        // fetch an individual customer


        pf = profileRepository.findByUserId("789456125");
        assertEquals("789456125",pf.getUserId());
    }
≈*/
    @Test
    public void findUserId(){

        //ProfileService service = new ProfileService();
        Profile pf = service.getProfileByUserId("123456789012340");
        //assertEquals("123456789012340",pf.getUserId());

    }

}
