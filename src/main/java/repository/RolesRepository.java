package repository;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RolesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Role> getRoles() {
        System.out.println("test");
        return jdbcTemplate.query("SELECT * FROM Roles", BeanPropertyRowMapper.newInstance(Role.class));
    }
    public int addRole(Role role) {
        return jdbcTemplate.update("INSERT INTO Roles (name) values (?)", role.getName());
    }
    public Role getRoleById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Roles where id=?", BeanPropertyRowMapper.newInstance(Role.class), id);
    }

    public int updateRole(Role role) {
        return jdbcTemplate.update("UPDATE Roles SET name=? where id=?", role.getName(), role.getId());
    }

    public int deleteRoleById(Long id) {
        return jdbcTemplate.update("DELETE FROM Roles where id=?", id);
    }
}
