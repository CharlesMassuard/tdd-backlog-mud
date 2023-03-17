import java.util.ArrayList;

class Thing{
    String name;
    public Thing(String name){
        this.name = name;
    }
}

public class Box {

    private ArrayList<Thing> contents = new ArrayList<Thing>();
    private boolean ouvert;

    
    public Box(){
        this.ouvert=true;
        System.out.println("Box créée");
        
    }

    public void add(Thing truc){
        if (this.ouvert){
        this.contents.add(truc);
        }

    }

    public boolean contient(Thing thing){
        return this.contents.contains(thing);
    }

    public boolean remove(Thing thing) throws ThingNotFound{
        if(this.contient(thing)){
            for(int i = 0; i<this.contents.size(); ++i){
                if(this.contents.get(i).equals(thing)){
                    this.contents.remove(i);
                    return true;
                }
            }
        }
        throw new ThingNotFound(); //lève l'exception        
    }

    public void open(){
        this.ouvert=true;
    }

    public void close(){
        this.ouvert=false;
    }

    public boolean isOpen(){
        return this.ouvert;
    }

    public String actionLook() throws BoiteFermee{
        if(this.isOpen()){
            if(this.contents.size()>0){
                String retour = "La boite contient : ";
                for(Thing truc : this.contents){
                    retour += truc.name+" ";
                }
            return retour;
            }
            return "La boite est vide !";
        }
        throw new BoiteFermee();
    }
}

class ThingNotFound extends Exception{

}

class BoiteFermee extends Exception{

}

