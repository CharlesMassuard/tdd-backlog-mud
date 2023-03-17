import com.google.gson.Gson;
public class gson {
    Gson gson = new Gson();
    String json = gson.toJson(new Box());
    Box box = gson.fromJson(rep_en_json, Box.class);
    
}
