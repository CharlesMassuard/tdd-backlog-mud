import java.util.ArrayList;

class Thing{
    String name;
    double poids;

    public Thing(String name){
        this.name = name;
        this.poids = 0;
    }

    public Thing(String name, double poids){
        this.name = name;
        this.poids = poids;
    }

    public double volume(){
        return this.poids;
    }

}


public class Box {

    private ArrayList<Thing> contents = new ArrayList<Thing>();
    private boolean ouvert;
    private double capacity;

    public Box(){
        this.ouvert=true;
        this.capacity=-1;
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

    public void setCapacity(double capacity){
        this.capacity = capacity;
    }

    public double capacity(){
        return this.capacity;
    }

    public boolean hasRoomFor(Thing chose){
        double poidsThing = chose.volume();
        return true;
    }
}

class ThingNotFound extends Exception{

}

class BoiteFermee extends Exception{

}

