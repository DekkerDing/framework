package io.github.DekkerDing.security.service.impl;

import io.github.DekkerDing.security.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service("SMS")
public class SMSServiceImpl implements IUserService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public Boolean support(String type) {
        return "SMS".equals(type);
    }
}
