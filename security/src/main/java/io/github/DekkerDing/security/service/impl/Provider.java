package io.github.DekkerDing.security.service.impl;

import io.github.DekkerDing.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Provider {

    @Autowired
    private List<IUserService> userServices;

    public IUserService select(String type){
        return userServices.stream().filter(p -> p.support(type)).findFirst().orElse(null);
    }
}
