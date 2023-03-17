import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;
public class BricolageGson{

    public void Ecrire(){
        Gson gson = new Gson();
        String rep_en_json = gson.toJson(new Box());
        Box box = gson.fromJson(rep_en_json, Box.class);
        FileWriter fw = new FileWriter("./out/monfic.txt");
        fw.write("Bonjour tout le monde");
    }
}

    

