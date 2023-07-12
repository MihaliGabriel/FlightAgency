package repository;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int addUser(User user) {
        return jdbcTemplate.update("INSERT INTO Users (ref_role, username, password) values (?, ?, ?)", user.getRef_role(),  user.getUsername(), user.getPassword());
    }
    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM Users", BeanPropertyRowMapper.newInstance(User.class));
    }
    public User findById(Long id) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM Users WHERE id=?", BeanPropertyRowMapper.newInstance(User.class), id);
        return user;
    }

    public int deleteUserById(long id) {
        return jdbcTemplate.update("DELETE FROM Users WHERE id=?", id);
    }

    public int updateUser(User user) {
        return jdbcTemplate.update("UPDATE Users SET ref_role =?, username =?, password =? where id =?", user.getRef_role(), user.getUsername(), user.getPassword(), user.getId());
    }
}
