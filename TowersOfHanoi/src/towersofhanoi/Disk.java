
package towersofhanoi;

/**
 * Disk object: contains a size value
 * @author tvtut
 */
public class Disk {
    int size;
    
    public Disk(){size = 0;} // shouldn't be used
    public Disk(int i){
        size = i;
    }
    
    @Override
    public String toString(){
        return "Disk " + size;
    }
}
