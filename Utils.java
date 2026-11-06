import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.its.umbria.academy.exceptions.ITSException;
import com.sun.tools.javac.Main;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {

    private static final Logger logger = LogManager.getLogger(Utils.class);

    public static void schoolClass2JSONFile(ArrayList<SchoolClass> elements) throws ITSException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("elenco.json")) {
            gson.toJson(elements, writer);
            System.out.println("File JSON creato con successo!");
        } catch (IOException e) {
            //e.printStackTrace();
            logger.log(Level.ERROR, e.getMessage());
            logger.log(Level.ERROR, e);
            throw new ITSException("ERRORE nella costruzione del file JSON", e);
        }
    }

    public static ArrayList<SchoolClass> fromJSONFile2ArrayListOfSchoolClasses(String jsonFileName) throws ITSException{

        Gson gson = new Gson();
        ArrayList<SchoolClass> schoolClasses = null;

        try (FileReader reader = new FileReader(jsonFileName)) {
            Type listType = new TypeToken<ArrayList<SchoolClass>>() {
            }.getType();

            schoolClasses = gson.fromJson(reader, listType);

        } catch (IOException e) {
            //System.err.println("Errore durante la lettura del file: " + e.getMessage());
            logger.log(Level.ERROR, e.getMessage());
            logger.log(Level.ERROR, e);
            throw new ITSException("ERRORE nella lettura del file JSON", e);
        }
        return schoolClasses;
    }
}
