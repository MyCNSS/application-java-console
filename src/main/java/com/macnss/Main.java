package com.macnss;

import com.macnss.DBconnection.DBconnection;
import com.macnss.Model.*;
import com.macnss.dao.*;
import com.macnss.helpers.*;

import java.sql.Connection;
import java.util.Scanner;
import java.util.prefs.Preferences;

import static com.macnss.helpers.helpers.*;
import static com.macnss.helpers.helpers.getVertClairColor;

public class Main {

    public static void main(String[] args) {

        AdminDao adminDao = new AdminImpl();
        AgentDao agentDao = new AgentImpl();
        CategorieDao categorieDao = new CategorieImpl();
        ConsultationMedicaleDao consultationMedicaleDao = new ConsultationMedicaleImpl();
        DossierDao dossierDao = new DossierImpl();
        MedicamentDao medicamentDao = new MedicamentImpl();
        PatientDao patientDao = new PatientImpl();
        TypeConsultationDao typeConsultationDao = new TypeConsultationImpl();

        Preferences preferences = Preferences.userNodeForPackage(Main.class);

        Scanner scanner = new Scanner(System.in);
        int choix;
        int id;
        String email;
        String password;
        String nom;
        String prenom;
        String matrecule;
        int status;
        int CM;
        int M;

        int randomCode;
        String body;
        String subject;

        do {
            preferences.put("EMAIL", "null");
            preferences.put("NOM", "null");
            preferences.put("PRENOM", "null");
            preferences.put("MATRECULE", "null");
            preferences.putInt("ID", -1);

            System.out.println(createTable("", ""));
            System.out.println(createTable("Menu", getRougeClairColor()));
            System.out.println(createTable("", ""));
            System.out.println(createTable("1.Vous Etes Admin", getVertClairColor()));
            System.out.println(createTable("2.Vous Etes Agent", getVertClairColor()));
            System.out.println(createTable("3.Vous Etes Patient", getVertClairColor()));
            System.out.println(createTable("0.Quitter", getVertClairColor()));
            System.out.println(createTable("", ""));

            System.out.print("Enterez votre choix (0-3): ");
            choix = scanner.nextInt();
            scanner.nextLine();
            clearConsole(28);

            switch (choix) {
                case 1:
                    int codeConfirmation;
                    System.out.println("Entrer votre email");
                    email=scanner.nextLine();

                    System.out.println("Entrer votre password");
                    password=scanner.nextLine();

                    randomCode = helpers.generateCode();
                    body = "Code généré : " + randomCode;
                    subject = "Confirmer votre email";
                    helpers.sendMail(body,subject,email);

                    System.out.println("Le code de confirmation de confirmation est envoyer a votre adresse mail");
                    System.out.println("Entrer votre code de confirmation");
                    codeConfirmation=scanner.nextInt();
                    scanner.nextLine();
                    if (codeConfirmation == randomCode){
                        Admin admin = Admin.builder()
                                .email(email)
                                .password(password)
                                .build();
                        admin = adminDao.login(admin);
                        if (admin.getId() == -1){
                            System.out.println("votre email ou votre password est invalid");
                            break;
                        }
                        preferences.put("EMAIL", admin.getEmail());
                        preferences.put("NOM", admin.getNom());
                        preferences.put("PRENOM", admin.getPrenom());
                        preferences.putInt("ID", admin.getId());

                        clearConsole(30);

                        System.out.println(createTable("", ""));
                        System.out.println(createTable("Menu", getRougeClairColor()));
                        System.out.println(createTable("", ""));
                        System.out.println(createTable("1.Afficher les Agents", getVertClairColor()));
                        System.out.println(createTable("2.Ajouter un Agent", getVertClairColor()));
                        System.out.println(createTable("3.Modifier un Agent", getVertClairColor()));
                        System.out.println(createTable("4.Supprimer un Agent", getVertClairColor()));
                        System.out.println(createTable("0.Quitter", getVertClairColor()));
                        System.out.println(createTable("", ""));

                        System.out.print("Enterez votre choix (0-4): ");
                        choix = scanner.nextInt();
                        scanner.nextLine();
                        clearConsole(30);

                        switch (choix){
                            case 1:
                                System.out.println(createTableAgents("empty1"));
                                System.out.println(createTableAgents("List des Agents"));
                                System.out.println(createTableAgents("empty2"));
                                System.out.println(createTrAgents());
                                System.out.println(createTableAgents("empty2"));
                                adminDao.affichageAgent().forEach(System.out::println);
                                System.out.println(createTableAgents("empty2"));
                                break;
                            case 2:
                                System.out.println(createTableAgents("empty1"));
                                System.out.println(createTableAgents("Ajouter un Agent"));
                                System.out.println(createTableAgents("empty1"));
                                System.out.println("Entrer Email D'Agent");
                                email=scanner.nextLine();

                                System.out.println("Entrer Password D'Agent");
                                password=scanner.nextLine();

                                System.out.println("Entrer Nom D'Agent");
                                nom=scanner.nextLine();

                                System.out.println("Entrer Prenom D'Agent");
                                prenom=scanner.nextLine();

                                Agent agent = Agent.builder()
                                        .email(email)
                                        .password(password)
                                        .nom(nom)
                                        .prenom(prenom)
                                        .build();
                                boolean resultat = adminDao.ajoutAgent(agent);
                                if (resultat == true){
                                    System.out.println("Agent a ete ajoute");
                                }else {
                                    System.out.println("Cet agent se trouve dans la base donnee");
                                }
                                break;
                            case 3:
                                System.out.println(createTableAgents("empty1"));
                                System.out.println(createTableAgents("Modifier un Agent"));
                                System.out.println(createTableAgents("empty1"));

                                System.out.println("Entrer Email D'Agent");
                                email=scanner.nextLine();

                                System.out.println("Entrer Password D'Agent");
                                password=scanner.nextLine();

                                System.out.println("Entrer Nom D'Agent");
                                nom=scanner.nextLine();

                                System.out.println("Entrer Prenom D'Agent");
                                prenom=scanner.nextLine();

                                agent = Agent.builder()
                                        .email(email)
                                        .password(password)
                                        .nom(nom)
                                        .prenom(prenom)
                                        .build();
                                resultat = adminDao.modiferAgent(agent);
                                if (resultat == true){
                                    System.out.println("Agent est modife");
                                }else {
                                    System.out.println("Agent ne se trouve pas dans la base de donnee");
                                }
                                break;
                            case 4:
                                System.out.println(createTableAgents("empty1"));
                                System.out.println(createTableAgents("Supprimer un Agent"));
                                System.out.println(createTableAgents("empty1"));
                                System.out.println("Entrer Email D'Agent");
                                email=scanner.nextLine();

                                resultat = adminDao.supprissionAgent(email);
                                if (resultat == true){
                                    System.out.println("Agent Supprimer");
                                }else {
                                    System.out.println("Agent ne se trouve pas dans la base de donnee");
                                }
                                break;
                            case 0:
                                System.out.println("Fermeture du programme.");
                                break;
                            default:
                                System.out.println("Choix invalide. Selectionnez un choix valide.");
                                break;
                        }
                    }else {
                        System.out.println("Le code de confirmation est non valide");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Entrer votre email");
                    email=scanner.nextLine();

                    System.out.println("Entrer votre password");
                    password=scanner.nextLine();

                    randomCode = helpers.generateCode();
                    body = "Code généré : " + randomCode;
                    subject = "Confirmer votre email";
                    helpers.sendMail(body,subject,email);

                    System.out.println("Le code de confirmation de confirmation est envoyer a votre adresse mail");
                    System.out.println("Entrer votre code de confirmation");
                    codeConfirmation=scanner.nextInt();
                    scanner.nextLine();
                    if (codeConfirmation == randomCode){
                        Agent agent = Agent.builder()
                                .email(email)
                                .password(password)
                                .build();
                        agent = agentDao.login(agent);

                        if (agent.getId() == -1){
                            System.out.println("votre email ou votre password est invalid");
                            break;
                        }

                        preferences.put("EMAIL", agent.getEmail());
                        preferences.put("NOM", agent.getNom());
                        preferences.put("PRENOM", agent.getPrenom());
                        preferences.putInt("ID", agent.getId());


                        clearConsole(30);

                        System.out.println(createTable("", ""));
                        System.out.println(createTable("Menu", getRougeClairColor()));
                        System.out.println(createTable("", ""));
                        System.out.println(createTable("1.Afficher les dossiers", getVertClairColor()));
                        System.out.println(createTable("2.Ajouter un Dossier", getVertClairColor()));
                        System.out.println(createTable("3.Modifier un Dossier", getVertClairColor()));
                        System.out.println(createTable("4.Supprimer un Dossier", getVertClairColor()));
                        System.out.println(createTable("5.comfirmer un Dossier", getVertClairColor()));
                        System.out.println(createTable("0.Quitter", getVertClairColor()));
                        System.out.println(createTable("", ""));

                        System.out.print("Enterez votre choix (0-5): ");
                        choix = scanner.nextInt();
                        scanner.nextLine();
                        clearConsole(30);

                        switch (choix){
                            case 1:
                                System.out.println(createTrDossiers("sans1"));
                                System.out.println(createTrDossiers("List des Dossiers"));
                                System.out.println(createTrDossiers("sans2"));
                                System.out.println(createTrDossiers("sans3"));
                                System.out.println(createTrDossiers("sans2"));
                                agentDao.affichageDossier().forEach(System.out::println);
                                System.out.println(createTrDossiers("sans2"));
                                break;
                            case 2:
                                System.out.println(createTableAgents("empty1"));
                                System.out.println(createTableAgents("Ajouter un Dossier"));
                                System.out.println(createTableAgents("empty1"));

                                System.out.println("Entrer Matrecule de Patient");
                                matrecule=scanner.nextLine();

                                System.out.println(createTrMedicamentConsultationMedicale("sans1"));
                                System.out.println(createTrMedicamentConsultationMedicale("List des Consultations Medicales"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans3"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));
                                consultationMedicaleDao.affichageConsultationMedicales().forEach(System.out::println);
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));

                                System.out.println("Entrer Id de Consultation Medicale");
                                CM=scanner.nextInt();
                                scanner.nextLine();


                                System.out.println(createTrMedicamentConsultationMedicale("sans1"));
                                System.out.println(createTrMedicamentConsultationMedicale("List des Medicaments"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans3"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));
                                medicamentDao.affichageMedicaments().forEach(System.out::println);
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));

                                System.out.println("Entrer Id de Medicament");
                                M=scanner.nextInt();
                                scanner.nextLine();

                                float prix_retour = dossierDao.calculeDossier(M, CM);
                                Dossier dossier = Dossier.builder()
                                        .prix_retour(prix_retour)
                                        .matrecule(matrecule)
                                        .id_a(preferences.getInt("ID", -1))
                                        .id_m(M)
                                        .id_cm(CM)
                                        .build();
                                boolean resultat = agentDao.ajoutDossier(dossier);
                                if (resultat == true){
                                    System.out.println("Le dossier est ajoute");
                                }else {
                                    System.out.println("Le dossier n'est pas ajoute");
                                }
                                break;
                            case 3:
                                System.out.println(createTrDossiers("sans1"));
                                System.out.println(createTrDossiers("Modifier un Dossier"));
                                System.out.println(createTrDossiers("sans1"));

                                clearConsole(2);

                                System.out.println("Entrer Matrecule de Patient");
                                matrecule=scanner.nextLine();

                                System.out.println(createTrDossiers("sans1"));
                                System.out.println(createTrDossiers("List des Dossiers"));
                                System.out.println(createTrDossiers("sans2"));
                                System.out.println(createTrDossiers("sans3"));
                                System.out.println(createTrDossiers("sans2"));
                                patientDao.voirHistorique(matrecule,0).forEach(System.out::println);
                                System.out.println(createTrDossiers("sans2"));

                                System.out.println("Entrer Id de Dossier");
                                id=scanner.nextInt();
                                scanner.nextLine();

                                System.out.println(createTrMedicamentConsultationMedicale("sans1"));
                                System.out.println(createTrMedicamentConsultationMedicale("List des Consultations Medicales"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans3"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));
                                consultationMedicaleDao.affichageConsultationMedicales().forEach(System.out::println);
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));

                                System.out.println("Entrer Id de Consultation Medicale");
                                CM=scanner.nextInt();
                                scanner.nextLine();


                                System.out.println(createTrMedicamentConsultationMedicale("sans1"));
                                System.out.println(createTrMedicamentConsultationMedicale("List des Medicaments"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans3"));
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));
                                medicamentDao.affichageMedicaments().forEach(System.out::println);
                                System.out.println(createTrMedicamentConsultationMedicale("sans2"));

                                System.out.println("Entrer Id de Medicament");
                                M=scanner.nextInt();
                                scanner.nextLine();

                                prix_retour = dossierDao.calculeDossier(M, CM);
                                dossier = Dossier.builder()
                                        .id(id)
                                        .prix_retour(prix_retour)
                                        .matrecule(matrecule)
                                        .id_a(preferences.getInt("ID", -1))
                                        .id_m(M)
                                        .id_cm(CM)
                                        .build();
                                resultat = agentDao.modifierDossier(dossier);
                                if (resultat == true){
                                    System.out.println("Le dossier est modifie");
                                }else {
                                    System.out.println("Le dossier n'est pas modifie");
                                }

                                break;
                            case 4:
                                System.out.println(createTrDossiers("sans1"));
                                System.out.println(createTrDossiers("Supprimer un Dossier"));
                                System.out.println(createTrDossiers("sans1"));

                                clearConsole(2);

                                System.out.println(createTrDossiers("sans1"));
                                System.out.println(createTrDossiers("List des Dossiers"));
                                System.out.println(createTrDossiers("sans2"));
                                System.out.println(createTrDossiers("sans3"));
                                System.out.println(createTrDossiers("sans2"));
                                agentDao.affichageDossier().forEach(System.out::println);
                                System.out.println(createTrDossiers("sans2"));

                                System.out.println("Entrer Id de Dossier");
                                id=scanner.nextInt();
                                scanner.nextLine();

                                resultat = agentDao.supprisionDossier(id);
                                if (resultat == true){
                                    System.out.println("Le dossier est modifie");
                                }else {
                                    System.out.println("Le dossier n'est pas modifie");
                                }
                                break;
                            case 5:
                                System.out.println(createTrDossiers("sans1"));
                                System.out.println(createTrDossiers("List des Dossiers"));
                                System.out.println(createTrDossiers("sans2"));
                                System.out.println(createTrDossiers("sans3"));
                                System.out.println(createTrDossiers("sans2"));
                                agentDao.affichageDossier().forEach(System.out::println);
                                System.out.println(createTrDossiers("sans2"));

                                System.out.print("Enterez Id de Dossier");
                                id = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println(createTable("", ""));
                                System.out.println(createTable("comfirmer un Dossier", getRougeClairColor()));
                                System.out.println(createTable("", ""));
                                System.out.println(createTable("-1.Refusé", getVertClairColor()));
                                System.out.println(createTable("0.En attente", getVertClairColor()));
                                System.out.println(createTable("1.Validé", getVertClairColor()));
                                System.out.println(createTable("", ""));

                                System.out.print("Enterez votre choix (-1,0,1): ");
                                status = scanner.nextInt();
                                scanner.nextLine();

                                resultat = agentDao.comfirmationDossier(id,status);
                                if (resultat == true){
                                    System.out.println("status est modifie");
                                }else {
                                    System.out.println("status n'est pas modifie");
                                }
                                break;
                            case 0:
                                System.out.println("Fermeture du programme.");
                                break;
                            default:
                                System.out.println("Choix invalide. Selectionnez un choix valide.");
                        }
                    }else {
                    System.out.println("Le code de confirmation est non valide");
                    break;
                }
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Fermeture du programme.");
                    break;
                default:
                    System.out.println("Choix invalide. Selectionnez un choix valide.");
            }
            preferences.put("EMAIL", "null");
            preferences.put("NOM", "null");
            preferences.put("PRENOM", "null");
            preferences.put("MATRECULE", "null");
            preferences.putInt("ID",-1);

            if (choix != 0){
                System.out.print("Voulez-vous continuer? (1 = Oui, 0 = Non): ");
                choix = scanner.nextInt();
                clearConsole(30);
            }
        } while (choix != 0);
        System.out.println("Soyez les bienvenus !");
    }
}