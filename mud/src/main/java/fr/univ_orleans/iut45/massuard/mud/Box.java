package fr.univ_orleans.iut45.massuard.mud;

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
    public Thing(double poids){
        this.poids = poids;
    }

    public void setName(String nom){
        this.name = nom;
    }

    public String getName(){
        return this.name;
    }

    /**
     * Retourne son poids
     * @return Le poids de l'objet
     */
    public double volume(){
        return this.poids;
    }

    /**
     * Vérifie si l'objet a le nom passé en paramètre
     * @param nom Le nom à vérifier
     * @return true si l'objet a le nom passé en paramètre, false sinon
     */
    public boolean hasName(String nom){
        if(this.getName().equals(nom)){
            return true;
        }
        return false;
    }

    /**
     * Vérifie si deux objets sont égaux
     * @param obj L'objet à comparer
     * @return true si les objets sont égaux, false sinon
     */
    @Override
    public boolean equals(Object obj){
        if(obj==null){return false;}
        if(obj==this){return true;}
        if(obj instanceof Box){
            Thing b = (Thing) obj;
            return b.getName().equals(this.getName()) && b.volume() == this.volume();
        }
        return false;
    }

}


public class Box {

    private ArrayList<Thing> contents;
    private boolean ouvert;
    private double capacity;

    /** Crée une box  */

    public Box(){
        this.contents = new ArrayList<Thing>();
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
     * Retourne ce qui est contenu dans la boite
     * @return Un string représentant ce qu'il y a dans la boite
     * @throws BoiteFermee si la boite est fermée
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
            return "La boite est vide !"; //lever une exception (demander au professeur pour savoir comment lever différentes exceptions dans une seule méthode)
        }
        throw new BoiteFermee();
    }

    /**
     * Permet de définir une capacité à une boite 
     * @param capacity La capacité que l'on souhaite donné à la boite
     */
    public void setCapacity(double capacity){
        this.capacity = capacity;
    }

    /**
     * Retourne la capacité de la boite
     * @return La capacité de la boite
     */
    public double capacity(){
        return this.capacity;
    }

    /**
     * Retourne si la boite a la place pour un objet
     * @param chose L'objet que l'on veut rajouter
     * @return true si la boite a la place, false sinon
     */
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

    /**
     * Permet d'ajouter un objet à la boite
     * @param chose L'objet que l'on veut rajouter
     * @return true si l'objet a été rajouté, false sinon
     * @throws BoitePleine si la boite est pleine
     */
    public boolean actionAdd(Thing chose) throws BoitePleine{
        if(this.isOpen()){
            boolean placeSuffisante = this.hasRoomFor(chose);
            if(placeSuffisante){
                this.add(chose);
                if(this.capacity()!=-1){
                    this.capacity -= chose.volume();
                }
                return true;
            }
            throw new BoitePleine();
        }
        return false; //lever une exception (demander au professeur pour savoir comment lever différentes exceptions dans une seule méthode)
    }

    /**
     * Cherche un objet dans la boite
     * @param nom Le nom de l'objet que l'on cherche
     * @return L'objet si il est trouvé, null sinon
     * @throws ThingNotFound si l'objet n'est pas trouvé
     */
    public Thing find(String nom) throws ThingNotFound{
        if(this.isOpen()){
            for(Thing chose : this.contents){
                if(chose.getName().equals(nom)){
                    return chose;
                }
            }
            throw new ThingNotFound();
        }
        return null; //lever une exception (demander au professeur pour savoir comment lever différentes exceptions dans une seule méthode)
    }

    public static Box fromJson(InputStream stream) throws FileNotFoundException{
        InputStreamReader r = new InputStreamReader(stream);
        Gson gson = new Gson();
        Box b = gson.fromJson(r, classOfT:Box.class);
        return b;
    }
}

class ThingNotFound extends Exception{

}

class BoiteFermee extends Exception{

}

class BoitePleine extends Exception{

}

