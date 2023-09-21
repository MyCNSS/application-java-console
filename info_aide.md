```JAVA
    import org.mindrot.jbcrypt.BCrypt;

    public class PasswordHashingExample {
        public static void main(String[] args) {
            // Mot de passe en clair que vous voulez crypter
            String password = "monMotDePasseSecret";
    
            // Générez un sel (salt) aléatoire
            String salt = BCrypt.gensalt();
    
            // Utilisez BCrypt pour hacher le mot de passe avec le sel
            String hashedPassword = BCrypt.hashpw(password, salt);
    
            // Le mot de passe crypté peut maintenant être stocké dans votre base de données
            System.out.println("Mot de passe crypté : " + hashedPassword);
    
            // Vous pouvez également vérifier un mot de passe saisi par l'utilisateur
            String inputPassword = "motDePasseSaisiParUtilisateur";
            if (BCrypt.checkpw(inputPassword, hashedPassword)) {
                System.out.println("Mot de passe correct");
            } else {
                System.out.println("Mot de passe incorrect");
            }
        }
    }
```
```JAVA
    Connection con = DBconnection.getConnection();
```