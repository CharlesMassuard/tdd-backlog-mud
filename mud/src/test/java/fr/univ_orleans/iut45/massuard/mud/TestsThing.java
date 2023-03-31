import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TestsThing{

    @Test
    public void testVolume(){
            Thing laChose = new Thing(5);
            assert laChose.volume()==5; 
    }

    @Test
    public void testSetName(){
        Thing laChose = new Thing(5);
        laChose.setName("La Chose");
        assert laChose.getName().equals("La Chose");
    }

    @Test
    public void testHasName(){
        Thing laChose = new Thing("La Chose");
        assert laChose.hasName("La Chose");
        assert !laChose.hasName("Mercredi");
    }
}