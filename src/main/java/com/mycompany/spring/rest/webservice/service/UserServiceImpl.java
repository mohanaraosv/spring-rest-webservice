package com.mycompany.spring.rest.webservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.mycompany.spring.rest.webservice.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<User>       users;

    static {
        users = populateDummyUsers();
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public User findById(final long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByName(final String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveUser(final User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    @Override
    public void updateUser(final User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    @Override
    public void deleteUserById(final long id) {

        for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public boolean isUserExist(final User user) {
        return findByName(user.getName()) != null;
    }

    private static List<User> populateDummyUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(counter.incrementAndGet(), "Sam", 30, 70000));
        users.add(new User(counter.incrementAndGet(), "Tom", 40, 50000));
        users.add(new User(counter.incrementAndGet(), "Jerome", 45, 30000));
        users.add(new User(counter.incrementAndGet(), "Silvia", 50, 40000));
        return users;
    }

    @Override
    public void deleteAllUsers() {
        users.clear();
    }

}
