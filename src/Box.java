import java.util.ArrayList;

class Thing{
    String name;
    public Thing(String name){
        this.name = name;
    }
}

public class Box {

    ArrayList<Thing> contents = new ArrayList<Thing>();

    public Box(){
        System.out.println("Box créée");
    }

    public void add(Thing truc){
        this.contents.add(truc);
    }
}
