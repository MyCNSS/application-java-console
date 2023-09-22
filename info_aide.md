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
```JAVA
    AdminDao adminDao = new AdminImpl();
    Agent agent = Agent.builder()
            .email("uanemaro216@gmail.com")
            .password("Marouane216@")
            .nom("Bouchettoy")
            .prenom("MarouaneUpdate")
            .build();
    boolean resultat = adminDao.modiferAgent(agent);
    if (resultat == true){
        System.out.println("updated");
    }else {
        System.out.println("dont in database");
    }
```JAVA
    AdminDao adminDao = new AdminImpl();
    Agent agent = Agent.builder()
            .email("uanemaro216@gmail.com")
            .password("Marouane216@")
            .nom("Bouchettoy")
            .prenom("MarouaneUpdate")
            .build();
    boolean resultat = adminDao.ajoutAgent(agent);
    if (resultat == true){
        System.out.println("added");
    }else {
        System.out.println("in database");
    }
```
```JAVA
    AdminDao adminDao = new AdminImpl();

    boolean resultat = adminDao.supprissionAgent("uanemaro89@gmail.com");
    if (resultat == true){
        System.out.println("deleted");
    }else {
        System.out.println("dont in database");
    }
```
```JAVA
    AdminDao adminDao = new AdminImpl();
    adminDao.affichageAgent().forEach(System.out::println);
```
```JAVA
    import java.util.prefs.Preferences;
    
    public class ExempleLocalStorage {
        public static void main(String[] args) {
            // Obtenez le nœud de préférences de l'utilisateur pour votre application
            Preferences preferences = Preferences.userNodeForPackage(ExempleLocalStorage.class);
    
            // Stockez des données dans le stockage local
            preferences.put("nom_utilisateur", "john_doe");
            preferences.putInt("age", 30);
            preferences.putBoolean("est_connecte", true);
    
            // Récupérez les données du stockage local
            String nomUtilisateur = preferences.get("nom_utilisateur", "valeur_par_defaut_si_non_trouvee");
            int age = preferences.getInt("age", 0);
            boolean estConnecte = preferences.getBoolean("est_connecte", false);
    
            // Affichez les données récupérées
            System.out.println("Nom d'utilisateur : " + nomUtilisateur);
            System.out.println("Âge : " + age);
            System.out.println("Est connecté : " + estConnecte);
        }
    }
```
```JAVA
        Preferences preferences = Preferences.userNodeForPackage(Main.class);
        AdminDao adminDao = new AdminImpl();
        Admin admin = Admin.builder()
                .email("uanemaro216@gmail.com")
                .password("Marouane216@")
                .build();
        admin = adminDao.login(admin);
        preferences.put("EMAIL", admin.getEmail());
        preferences.put("NOM", admin.getNom());
        preferences.put("PRENOM", admin.getPrenom());
        preferences.putInt("ID", admin.getId());

        String EMAIL = preferences.get("EMAIL", "null");
        String NOM = preferences.get("NOM", "null");
        String PRENOM = preferences.get("PRENOM", "null");
        int ID = preferences.getInt("ID", -1);

        System.out.println(EMAIL);
        System.out.println(PRENOM);
        System.out.println(NOM);
        System.out.println(ID);
```
```JAVA
import java.util.Random;

public class CodeGenerator {

    public static int generateRandomCode() {
        // Créez une instance de la classe Random
        Random rand = new Random();

        // Générez un code de 6 chiffres en utilisant la méthode nextInt()
        // La valeur maximale (999999) garantit un code de 6 chiffres.
        int code = rand.nextInt(999999);

        // Assurez-vous que le code a toujours 6 chiffres en ajoutant des zéros à gauche si nécessaire
        String codeString = String.format("%06d", code);

        // Convertissez le code en int et renvoyez-le
        return Integer.parseInt(codeString);
    }

    public static void main(String[] args) {
        int randomCode = generateRandomCode();
        System.out.println("Code généré : " + randomCode);
    }
}
```
```JAVA
    int randomCode = helpers.generateCode();
    System.out.println("Code généré : " + randomCode);
```