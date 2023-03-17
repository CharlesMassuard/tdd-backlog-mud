import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TestsThing{

    @Test
    public void testVolume(){
            Thing laChose = new Thing("La Chose", 5);
            assert laChose.volume()==5; 
    }
}