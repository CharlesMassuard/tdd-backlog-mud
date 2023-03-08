import java.util.ArrayList;

class Thing{
    String name;
    public Thing(String name){
    this.name = name;
    }
}

public class Box {

    ArrayList<String> contents = new ArrayList<String>();

    public Box(){
        System.out.println("Box créée");
    }

    public void add(String truc){
        this.contents.add(truc);
    }
}
