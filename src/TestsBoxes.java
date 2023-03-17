import org.junit.*;
import static org.junit.Assert.assertEquals;


public class TestsBoxes{

        @Test
        public void testBoxCreate() {
                Box b = new Box();
        }

        /** On veut pouvoir mettre des trucs dedans */

        @Test
        public void testBoxAdd(){
                Box b=new Box();
                b.add(new Thing("truc1"));
                b.add(new Thing("truc2"));
        }

        @Test
        public void testBoxContient(){
                Box b = new Box();
                Thing thing = new Thing("Je suis un super Thing");
                assert !b.contient(thing);
                b.add(thing);
                assert b.contient(thing);
        }

        @Test
        public void testBoxRemove(){
                Box b = new Box();
                Thing thing = new Thing("Je suis un super Thing");
                b.add(thing);
                try{
                        b.remove(thing);
                } catch(ThingNotFound error)
                {
                        System.out.println("N'est pas présent dans la box");
                }
                assert !b.contient(thing);
        }     

        @Test
        public void testActionLook(){
                Box b = new Box();
                try{
                        assert b.actionLook().equals("La boite est vide !");
                } catch(BoiteFermee error)
                {
                        System.out.println("La boite est fermée !");
                }
                Thing thing = new Thing("Je suis un super Thing");
                b.add(thing);
                try{
                        assert b.actionLook().equals("La boite contient : Je suis un super Thing ");
                } catch(BoiteFermee error)
                {
                        System.out.println("La boite est fermée !");
                }
                Thing chose = new Thing("Je suis la Chose");
                b.add(chose);
                try{
                        assert b.actionLook().equals("La boite contient : Je suis un super Thing Je suis la Chose ");
                } catch(BoiteFermee error)
                {
                System.out.println("La boite est fermée !");
                }
        }

        @Test
        public void testCapacity(){
                Box b = new Box();
                assert b.capacity() == -1;
                b.setCapacity(9);
                assert b.capacity() == 9;
        }

        @Test
        public void testHasRoomFor(){
                Box b = new Box();
                b.setCapacity(5);
                Thing laChose = new Thing("La chose", 4);
                Thing souris = new Thing("souris", 5);
                Thing mickey = new Thing("Mickey", 7);
                assert b.hasRoomFor(laChose);
                assert b.hasRoomFor(souris);
                assert !b.hasRoomFor(mickey);
                Box box = new Box();
                box.setCapacity(-1);
                Thing grominet = new Thing("Grominet", 8);
                assert box.hasRoomFor(grominet);
        }
}