
package towersofhanoi;

import java.util.ArrayList;

/**
 * Tower object: a stack (implemented via ArrayList) that contains Disk objects
 * @author tvtut
 */
public class Tower{
    private ArrayList<Disk> tower;
    
    // initializes an empty tower
    public Tower(){
        tower = new ArrayList();
    }
    
    // initializes a tower with n Disks from size 1 to n
    public Tower(int n){
        tower = new ArrayList();
        for (int i = 1; i <= n; i++) {
            tower.add(new Disk(i));
        }
    }
    
    // stack push operation, adds to end of arraylist
    public void push(Disk d){
        tower.add(d);
    }
    
    // stack pop operation, removes from end of arraylist
    public Disk pop(){
        return tower.remove(tower.size()-1);
    }
    
    // check if tower is empty
    public boolean isEmpty(){
        return tower.isEmpty();
    }
    
    @Override
    public String toString(){
        String out="";
        for (int i = 0; i < tower.size(); i++) {
            out = out + tower.get(i) + ", ";
        }
        return out;
    }
}
