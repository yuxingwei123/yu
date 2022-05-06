package org.example.dao;

import org.example.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    public List<User> findAll() throws IOException;
    public User findById(int id);
    public void delete(int id);
    public void insert(User user);
    public void update(User user);
}
