/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towersofhanoi;

/**
 * Model class that contains the methods to solve towers of hanoi
 * @author tvtuttle
 */
public class Model {
    private Tower[] towers;
    private int start_index;
    private int target_index;
    String output;
    public Model(){}
    public Model(int disk, int tower){
        // create array of Tower objects
        towers = new Tower[tower];
        // in first tower, fill with all disks; others will be empty
        towers[0] = new Tower(disk);
        for (int i = 1; i < tower; i++) {
            towers[i] = new Tower();
        }
        // start_index will always be 0, target will be length-1 (from first to last)
        start_index = 0;
        target_index = towers.length-1;
        // view initial contents
        System.out.println("First:");
        for (int i = 0; i < towers.length; i++) {
            System.out.println("Tower " + i + ": " + towers[i]);
        }
    }
    
    //solve method, where the magic happens
    //this is NOT a recursive method, it should call one tho
    public String solve(int disk, int tower){
        towers = new Tower[tower];
        // in first tower, fill with all disks; others will be empty
        towers[0] = new Tower(disk);
        for (int i = 1; i < tower; i++) {
            towers[i] = new Tower();
        }
        // start_index will always be 0, target will be length-1 (from first to last)
        start_index = 0;
        target_index = towers.length-1;
        // view initial contents
        output = "";
        output += "First: \n";
        for (int i = 0; i < towers.length; i++) {
            output += "Tower " + i + ": " + towers[i]+"\n";
        }
        //send to recursive method for solution
//        solve(disk, start_index, target_index);
        
        
        // below code is only for solving 3-tower problems, for experience and understanding
        if (towers.length == 3){
            output += solve3(disk, 0, 2, 1);
        }
        // below code will be for solving 5 to 10-tower problems, as requested
        // the concept should be similar to 3-tower in terms of the recursion
        // however, there will be more specific cases to process
        // with 3-tower, there was 1 start, 1 target, and 1 spare
        // with 5-10 tower, there is still 1 start, 1 target, but 3-8 spares
        // thus, when starting with disks <= spare locations, as in 3tower, it's easy
        // note that ideally, the recursed function will have number of disks and
        // number of towers as the parameters, so those will be changed
        // basically, the more towers added, the more spares there are
        
        // now, in 3tower, you solved 1 to n-1, then moved n to dest, then solved 1 to n-1 onto n
        // it should be the same in manytower, only the method for 1 to n-1 is different
        // when there are multiple spare towers, we want them at an even height
        // to get the best and fastest result
        
        // just as in 3tower, base case is just moving from start to target
        
        // view final contents
        output += "Last: \n";
        for (int i = 0; i < towers.length; i++) {
            output += "Tower " + i + ": " + towers[i]+"\n";
        }
        return output;
    }
    
    // separate method for recursion purposes
    // this is for the general use case of 5-10 towers variable
//    private void solve(int disks, int start, int target){
//        if (disks == 1){
//            towers[target].push(towers[start].pop());
//            String out = "Step: \n";
//            for (int i = 0; i < towers.length; i++) {
//                System.out.println("Tower " + i + ": " + towers[i]);
//            }
//            return out;
//        }
//        // insert recursion here
//        // final return
//        String out = "Step: \n";
//        for (int i = 0; i < towers.length; i++) {
//            System.out.println("Tower " + i + ": " + towers[i]);
//        }
//        return out;
//    }
    
    // separate method for recursion purposes
    // note that this is just for testing a specific case with 3 towers,
    // to promote understanding of the problem
    private String solve3(int num_disks, int start_index, int target_index, int spare_index){
        Tower start_tower = towers[start_index];
        Tower target_tower = towers[target_index];
        Tower spare_tower = towers[spare_index];
        if (num_disks == 1){
            target_tower.push(start_tower.pop());
            output += "Step: \n";
            for (int i = 0; i < towers.length; i++) {
                output +=("Tower " + i + ": " + towers[i]+"\n");
            }
        }
        else { // using recursive to repeatedly solve a simpler problem
            solve3(num_disks-1, start_index, spare_index, target_index);
            solve3(1, start_index, target_index, spare_index);
            solve3(num_disks-1, spare_index, target_index, start_index);
        }
        
        return output;
    }
}
