
package towersofhanoi;

/**
 * Disk object: contains a size value
 * @author tvtuttle
 */
public class Disk {
    private int size;
    
    public Disk(){size = 0;} // shouldn't be used
    public Disk(int i){
        size = i;
    }
    
    public int getSize(){
        return size;
    }
    
    @Override
    public String toString(){
        return "Disk " + size;
    }
}
