package config;

import model.Role;
import repository.RolesRepository;
import repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
@ComponentScan(basePackages = {"config","controller","model","repository"})
public class Main implements CommandLineRunner {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RolesRepository rolesRepository;
    public static void main(String[] args) {
            SpringApplication.run(Main.class, args);
        }

    @Override
    public void run(String... args) throws Exception {
       // rolesRepository.addRole(new Role("test"));
    //  usersRepository.addUser(1,"luci", "luci", "Vrabiescu", "Lucian", "0757715362", "mihaligabriel75@gmail.com");
    }
}