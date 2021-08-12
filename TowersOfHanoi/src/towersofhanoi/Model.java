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
    public Model(){}
    public Model(int d, int t){}
    
    //solve function, where the magic happens
    public String solve(int disk, int tower){
        // create array of Tower objects
        towers = new Tower[tower];
        // in first tower, fill with all disks; others will be empty
        towers[0] = new Tower(disk);
        for (int i = 1; i < tower; i++) {
            towers[i] = new Tower();
        }
        // view initial contents
        System.out.println("First:");
        for (int i = 0; i < towers.length; i++) {
            System.out.println("Tower " + i + ": " + towers[i]);
        }
        
        // below code is only for solving 3-tower problems, for experience and understanding
        if (towers.length == 3){
            solve3(disk, 0, 2, 1);
        }
        
        // below code will be for solving 5 to 10-tower problems, as requested
        // the concept should be similar to 3-tower in terms of the recursion
        // however, there will be more specific cases to process
        // view final contents
        System.out.println("Last:");
        for (int i = 0; i < towers.length; i++) {
            System.out.println("Tower " + i + ": " + towers[i]);
        }
        return "WIP";
    }
    
    // separate method for recursion purposes
    // note that this is just for testing a specific case with 3 towers,
    // to promote understanding of the problem
    private void solve3(int num_disks, int start_index, int target_index, int spare_index){
        Tower start_tower = towers[start_index];
        Tower target_tower = towers[target_index];
        Tower spare_tower = towers[spare_index];
        if (num_disks == 1){
            target_tower.push(start_tower.pop());
        }
        else {
            solve3(num_disks-1, start_index, spare_index, target_index);
            solve3(1, start_index, target_index, spare_index);
            solve3(num_disks-1, spare_index, target_index, start_index);
        }
        System.out.println("Step:");
        for (int i = 0; i < towers.length; i++) {
            System.out.println("Tower " + i + ": " + towers[i]);
        }
    }
}
