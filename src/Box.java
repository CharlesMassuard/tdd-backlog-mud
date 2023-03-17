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

    /** Crée une box  */

    public Box(){
        this.ouvert=true;
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
}

class ThingNotFound extends Exception{

}

class BoiteFermee extends Exception{

}

