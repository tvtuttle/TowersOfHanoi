
package towersofhanoi;

import java.util.ArrayList;

/**
 * Model class that contains the methods to solve Towers of Hanoi
 * @author tvtuttle
 */


public class Model {
    // define variables here so they can be easily used by both recursive and
    // non-recursive classes
    private Tower[] towers;
    private int start_index;
    private int target_index;
    private int spare_index;
    private ArrayList<Integer> spare_indices;
    private int num_spares;
    String output;
    private int moves;
    private int k;
    public Model(){}// no constructor, the required solve method does that job
    
    //first solve method, initializes the Towers and Disks for the calculation
    //this is NOT a recursive method, but it will call one
    public String solve(int disk, int tower){
        moves = 0;
        // the k value determines how high spare towers should be built
        // in the process of moving disks from the start to the target
        // via trial and error the below value was determined as the most flexible
        // the concept of the "k" value was inspired by the Frame-Stewart algorithm:
        // https://en.wikipedia.org/wiki/Tower_of_Hanoi#Frame%E2%80%93Stewart_algorithm
        k = (disk/tower)*2;
        towers = new Tower[tower];
        // in first tower, fill with all disks; others will be empty
        towers[0] = new Tower(disk);
        for (int i = 1; i < tower; i++) {
            towers[i] = new Tower();
        }
        // start_index will always be 0, target will be length-1 (from first to last)
        start_index = 0;
        target_index = towers.length-1;
        spare_index = 1;
        num_spares = towers.length-2;
        spare_indices = new ArrayList();
        for (int i = 0; i < num_spares; i++) {
            spare_indices.add(i+1);
        }
        // view initial contents
        output = "";
        output += "First: \n";
        for (int i = 0; i < towers.length; i++) {
            output += "Tower " + i + ": " + towers[i]+"\n";
        }
        //send to recursive method for solution
        solve(disk, start_index, target_index, spare_indices);
        
        // view final contents
        output += "Last: \n";
        for (int i = 0; i < towers.length; i++) {
            output += "Tower " + i + ": " + towers[i]+"\n";
        }
        output+="Total moves: " + moves;
        return output;
    }
    
    // separate method for recursion purposes
    // this is for the general use case of 5-10 towers variable
    // Currently, it can solve 29 disks with 10 towers in reasonable time
    // any more than that and it has issues
    private String solve(int disks, int start, int target, ArrayList<Integer> spares){
        if (disks == 0){}//do nothing
        else if (disks == 1){
            towers[target].push(towers[start].pop());
            moves ++;
            output += "Step: \n";
            for (int i = 0; i < towers.length; i++) {
                output +=("Tower " + i + ": " + towers[i]+"\n");
            }
            return output;
        }
        else if(disks < spares.size()){
            for (int d = 0; d < disks-1; d++) {
                towers[spares.get(d)].push(towers[start].pop());
                output += "Step: \n";
            for (int i = 0; i < towers.length; i++) {
                output +=("Tower " + i + ": " + towers[i]+"\n");
            }
                moves++;
            }
            towers[target].push(towers[start].pop());
            output += "Step: \n";
            for (int i = 0; i < towers.length; i++) {
                output +=("Tower " + i + ": " + towers[i]+"\n");
            }
            moves++;
            for (int d = disks-2; d >= 0; d--) {
                towers[target].push(towers[spares.get(d)].pop());
                output += "Step: \n";
            for (int i = 0; i < towers.length; i++) {
                output +=("Tower " + i + ": " + towers[i]+"\n");
            }
                moves++;
            }
            return output;
        }
        else if(spares.size() == 1){
            //if there's only one spare, it's the same as normal towers of hanoi
            int spare = spares.remove(0);
            spares.add(target);
            solve(disks-1, start, spare, spares);
            spares.remove(0);
            solve(1, start, target, spares);
            spares.add(start);
            solve(disks-1, spare, target, spares);
        }
        else {
            // put first k into a spare location
            // then, take the spare out of spares
            int spare = spares.get(spares.size()-1);
            spares.remove(spares.size()-1);
            solve(k, start, spare, spares);
            
            if((disks-k) < 1){
                solve(0, start, target, spares);// protect against potential negatives
            }
            else {
                solve(disks-k, start, target, spares);
            }
            solve(k, spare, target, spares);
        }
        
        // final return
        return output;
    }
    
}
