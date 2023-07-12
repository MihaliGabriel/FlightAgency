package controller;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.RolesRepository;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RolesController {
    @Autowired
    RolesRepository rolesRepository;

    @GetMapping("/roles")
    private ResponseEntity<List<Role>> getAllRoles() {
        try {
            List<Role> roles = new ArrayList<Role>();
            roles = rolesRepository.getRoles();
            if(roles.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/roles")
    private ResponseEntity<Role> createRole(@RequestBody Role role) {
        try {
            rolesRepository.addRole(role);
            return new ResponseEntity<>(role, HttpStatus.OK);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/roles/{id}")
    private ResponseEntity<String> deleteRole(@PathVariable("id") Long id) {
        try {
            rolesRepository.deleteRoleById(id);
            return new ResponseEntity<>("Role deleted succesfully", HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>("Cannot delete role", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/roles/{id}")
    private ResponseEntity<Role> updateRole(@PathVariable("id") Long id, @RequestBody Role role) {
        try {
            role.setId(id);
            rolesRepository.updateRole(role);
            return new ResponseEntity<>(role, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/roles/{id}")
    private ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
        Role role = rolesRepository.getRoleById(id);
        if(role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(role, HttpStatus.OK);
        }
    }
}
