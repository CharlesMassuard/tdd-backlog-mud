import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;
public class BricolageGson{

    /** Permet d'écrire dans un fichier */
    public void Ecrire(){
        Gson gson = new Gson();
        String rep_en_json = gson.toJson(new Box());
        Box box = gson.fromJson(rep_en_json, Box.class);
        FileWriter fw = new FileWriter("./out/monfic.txt");
        fw.write("Bonjour tout le monde");
    }

    /** Permet de lire dans un fichier */
    
    public void Lire(){
        Gson gson = new Gson();
        FileReader fr = new FileReader("./out/monfic.txt");
        String rep_en_json = gson.toJson(fr);
        Box box = gson.fromJson(rep_en_json, Box.class);
        
    }

}

    

