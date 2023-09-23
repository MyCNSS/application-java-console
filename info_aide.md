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
```JAVA
    import javax.mail.*;
    import javax.mail.internet.InternetAddress;
    import javax.mail.internet.MimeMessage;
    import java.util.Properties;

    public class Email {
        final static String IMG = "<img src=\"https://www.mapcasablanca.ma/map/uploads/2021/06/CNSS-3.jpg\" alt=\"logo\" width=\"100\" height=\"100\">";
        public static Boolean sendMail(String body,String subject ,String email) {
            final String username = "user@gmail.com";
            final String password = "password";
            Properties properties = System.getProperties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port","25");
            properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
            properties.put("mail.smtp.starttls.enable", "true");
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                message.setSubject(subject);
                message.setText(body);
                Transport.send(message);
                return true;
            } catch (MessagingException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
```
````JAVA
    int randomCode = helpers.generateCode();
    String body = "Code généré : " + randomCode;
    String subject = "Confirmer votre email";
    String email = "uanemaro216@gmail.com";
    boolean resultat = helpers.sendMail(body,subject,email);
    if (resultat == true){
        System.out.println("sended");
    } else {
        System.out.println("note Sended");
    }
````
````JAVA
    DossierDao dossierDao = new DossierImpl();
    float prix_retour = dossierDao.calculeDossier(1, 2);
    System.out.println(prix_retour);
````
````JAVA
    DossierDao dossierDao = new DossierImpl();
    float prix_retour = dossierDao.calculeDossier(1, 2);
    AgentDao agentDao = new AgentImpl();
    Dossier dossier = Dossier.builder()
            .prix_retour(prix_retour)
            .matrecule("BouMar2022")
            .id_a(1)
            .id_m(1)
            .id_cm(2)
            .build();
    boolean resultat = agentDao.ajoutDossier(dossier);
    if (resultat == true){
        System.out.println("added");
    }else {
        System.out.println("not added");
    }
````
````JAVA
    DossierDao dossierDao = new DossierImpl();
    float prix_retour = dossierDao.calculeDossier(1, 2);
    AgentDao agentDao = new AgentImpl();
    Dossier dossier = Dossier.builder()
            .id(1)
            .prix_retour(prix_retour)
            .matrecule("BouMar2022")
            .id_a(1)
            .id_m(1)
            .id_cm(2)
            .build();
    boolean resultat = agentDao.modifierDossier(dossier);
    if (resultat == true){
        System.out.println("updated");
    }else {
        System.out.println("not updated");
    }
````
`````JAVA
    AgentDao agentDao = new AgentImpl();
    boolean resultat = agentDao.supprisionDossier(2);
    if (resultat == true){
        System.out.println("deleted");
    }else {
        System.out.println("not deleted");
    }
`````
`````JAVA
    AgentDao agentDao = new AgentImpl();
    boolean resultat = agentDao.comfirmationDossier(2,1);
    if (resultat == true){
        System.out.println("status updated");
    }else {
        System.out.println("not status updated");
    }
`````
````JAVA
    Preferences preferences = Preferences.userNodeForPackage(Main.class);
    AgentDao agentDao = new AgentImpl();
    Agent agent = Agent.builder()
            .email("uanemaro216@gmail.com")
            .password("Marouane216@")
            .build();
    agent = agentDao.login(agent);
    preferences.put("EMAIL", agent.getEmail());
    preferences.put("NOM", agent.getNom());
    preferences.put("PRENOM", agent.getPrenom());
    preferences.putInt("ID", agent.getId());

    String EMAIL = preferences.get("EMAIL", "null");
    String NOM = preferences.get("NOM", "null");
    String PRENOM = preferences.get("PRENOM", "null");
    int ID = preferences.getInt("ID", -1);

    System.out.println(EMAIL);
    System.out.println(PRENOM);
    System.out.println(NOM);
    System.out.println(ID);
````