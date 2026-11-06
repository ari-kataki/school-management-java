import com.its.umbria.academy.exceptions.ITSException;
import com.sun.tools.javac.Main;
import jdk.jshell.execution.Util;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.plaf.basic.BasicTreeUI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class ITS {

    /* Elenco degli attributi
    Elenco dei metodi*/
    private static final Logger logger = LogManager.getLogger(ITS.class);

    public static void main(String[] args){
        logger.log(Level.INFO, "Avvio del programma: il metodo main è stato trovato correttamente!");

        ArrayList<SchoolClass> classes = new ArrayList<SchoolClass>();

        ArrayList<Teacher> tempTeacher = new ArrayList<Teacher>();
        tempTeacher.add(new Teacher("1", "Mario", "Gallo"));
        tempTeacher.add(new Teacher("2", "Rita", "Fontana"));
        tempTeacher.add(new Teacher("3", "Carla", "Moretti"));

        ArrayList<Student> tempStuds = new ArrayList<Student>();
        tempStuds.add(new Student("1", "Anna", "Rossi"));
        tempStuds.add(new Student("2", "Sara", "Conti"));
        tempStuds.add(new Student("3", "Elena", "Greco"));

        ArrayList<Student> tempStuds_2 = new ArrayList<Student>();
        tempStuds_2.add(new Student("1", "Luca", "Bianchi"));
        tempStuds_2.add(new Student("2", "Marco", "Verdi"));
        tempStuds_2.add(new Student("3", "Paolo", "Neri"));

        ArrayList<Subject> tempSubject = new ArrayList<Subject>();
        tempSubject.add(new Subject("1", "Italiano", 10));
        tempSubject.add(new Subject("2", "Matematica", 10));
        tempSubject.add(new Subject("3", "Inglese", 25));

        SchoolClass prima_A = new SchoolClass("Prima A", tempStuds, tempSubject, tempTeacher);
        SchoolClass prima_B = new SchoolClass("Prima B", tempStuds_2, tempSubject, tempTeacher);
        classes.add(prima_B);
        classes.add(prima_A);

        /*System.out.println("ELENCO DELLE CLASSI ");
        for(SchoolClass sc : classes)
            System.out.println("\n" + sc.toString());*/
        ArrayList<SchoolClass> classesFromJSON;

        try {
            Utils.schoolClass2JSONFile(classes);

            //verifica
            classesFromJSON = Utils.fromJSONFile2ArrayListOfSchoolClasses("elenco.json");
        } catch (ITSException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ELENCO DELLE CLASSI ");
        for(SchoolClass sc : classesFromJSON)
            System.out.println("\n" + sc.toString());


       /* Path path = Paths.get("its.txt");
        String content2Write = "Creazione file di testo: primo tentativo speriamo sia di gradimento a Anna...";

        try {

            Files.writeString(path, content2Write);
            System.out.println("File scritto con successo! (Anna non ha protestato)");


            String content2Read = Files.readString(path);

            System.out.println("--- Verifica della scrittura: leggo il file ---");
            System.out.println(content2Read);
            System.out.println("--------------------------");

        } catch (IOException e) {
            System.err.println("Errore  file: " + e.getMessage());
        }*/

        //Duck duck = new Duck(12, "M", "Giallo");


        /*int cont = 34;
        float price = 5.0f;
        String text = "Hello everybody";
        boolean onoff= true;

        Scanner scanner = new Scanner(System.in);

        Hashtable<String, Student> students = new Hashtable<String, Student>();

        Student s = new Student("1883hjd", "Davide" );
        students.put("1883hjd", s);


        Student toBeFound = students.get("Pippo");

        if(toBeFound != null)
            System.out.println("Davide individuato");
        else
            System.out.println("Davide è fuggito");


        cont = 0;
        String pss = "";
        boolean auth = true;
        Random rand = new Random(100);

        int[] values = new int[50];

        for(int i =0; i < 50; i++)
            values[i] = rand.nextInt();


        for(int i =0; i < 50; i++)
            System.out.println(values[i]);





       /* if(auth)
            System.out.println("Autenticazione avvenuta con successo");
        else
            System.out.println("Autenticazione fallita!");*/


       // text = age >=18 ? "Maggiorenne" : "Minorenne";

       // System.out.println("Secondo la nostra indagine sei: " + text);

       /* switch(age){
            case 12:
                System.out.println("Sei passato dall'infanzia all'adolescenza, mi spiace");

            case 18:
                System.out.println("Complimenti puoi guidare!");
                break;
            case 30:
                System.out.println("La vita sta peggiorando");
                break;
            case 60:
                System.out.println("Nulla piuù ci importa");
                break;
            default:
                System.out.println("La tua età non è degna di nota");
        }*/


        /*if(age >= 18 )
            System.out.println("Sei maggiorenne");
        else
            System.out.println("Sei minorenne");*/
    }
}
