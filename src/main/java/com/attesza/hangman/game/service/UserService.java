package com.attesza.hangman.game.service;

import com.attesza.hangman.game.service.IServices.IUserServices;
import com.attesza.hangman.game.user.User;
import com.sun.security.auth.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class UserService implements IUserServices {

    @Override
    public User currentUser() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        log.info("USER: "+ user);
        return user;
    }

    public boolean isLoggedIn() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User;
    }
}
