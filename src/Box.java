import java.util.ArrayList;

class Thing{
    String name;
    double poids;

    /**
     * Créer un Thing à partir d'un nom
     * @param name Le nom de l'objet 
     */
    public Thing(String name){
        this.name = name;
        this.poids = 0;
    }

    /**
     * Créer un Thing à partir d'un nom et de son poids 
     * @param name Le nom de l'objet 
     * @param poids Le poids de l'objet
     */
    public Thing(String name, double poids){
        this.name = name;
        this.poids = poids;
    }

    /**
     * Retourne son poids
     * @return Le poids de l'objet
     */
    public double volume(){
        return this.poids;
    }

}


public class Box {

    private ArrayList<Thing> contents = new ArrayList<Thing>();
    private boolean ouvert;
    private double capacity;

    /** Crée une box  */

    public Box(){
        this.ouvert=true;
        this.capacity=-1;
        System.out.println("Box créée");
        
    }

    /** Ajoute un objet à la boite 
     * @param truc L'objet qui représente ce que l'on veut rajouter
     */
    public void add(Thing truc){
        if (this.ouvert){
            this.contents.add(truc);
        }

    }

    /**
     * Retourne un booléén qui correspond à si l'objet est dans la boite
     * @param thing Représente l'objet que l'on veut rechercher
     * @return true si l'objet est dans la boite, false sinon
     */
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

    /** Ouvre la boîte */

    public void open(){
        this.ouvert=true;
    }

    /** Ferme la boîte */
    public void close(){
        this.ouvert=false;
    }

    /**
     * Retourne si la boite est ouverte ou pas
     * @return Un bouléen qui est à true si la boite est ouverte, false sinon
     */
    public boolean isOpen(){
        return this.ouvert;
    }

    /**
     * 
     * @return
     * @throws BoiteFermee 
     */
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
        double capaciteBoite = this.capacity();
        if(capaciteBoite == -1){ //si la boite a une capacité de -1 alors sa capacité est illimitée
            return true;
        }
        if(poidsThing <= capaciteBoite){
            return true;
        }
        return false;
    }

    public boolean actionAdd(Thing chose){
        return true;
    }
}

class ThingNotFound extends Exception{

}

class BoiteFermee extends Exception{

}

class BoitePleine extends Exception{

}

