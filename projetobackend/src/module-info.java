import java.util.ArrayList;
import java.util.List;

// Usuário
class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

// Gerenciamento de operações relacionadas aos usuários
class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    // Adicionar usuário
    public void addUser(User user) {
        users.add(user);
    }

    // Buscar usuário pelo e-mail
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    // Remover usuário pelo e-mail
    public void removeUserByEmail(String email) {
        User userToRemove = null;
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                userToRemove = user;
                break;
            }
        }
        if (userToRemove != null) {
            users.remove(userToRemove);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando o serviço de usuário
        UserService userService = new UserService();

        // Adicionando alguns usuários fictícios
        userService.addUser(new User("Alice", "alice@example.com", "123456"));
        userService.addUser(new User("Bob", "bob@example.com", "password"));
        userService.addUser(new User("Charlie", "charlie@example.com", "qwerty"));

        // Busca de usuário por e-mail
        User foundUser = userService.getUserByEmail("bob@example.com");
        if (foundUser != null) {
            System.out.println("Usuário encontrado: " + foundUser);
        } else {
            System.out.println("Usuário não encontrado.");
        }

        // Removendo um usuário
        userService.removeUserByEmail("bob@example.com");

        // Tentando encontrar o usuário removido
        foundUser = userService.getUserByEmail("bob@example.com");
        if (foundUser != null) {
            System.out.println("Usuário encontrado: " + foundUser);
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
