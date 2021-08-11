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
    public Model(){}
    public Model(int d, int t){}
    
    //solve function, where the magic happens
    public String solve(int disk, int tower){
        // create array of Tower objects
        Tower[] towers = new Tower[tower];
        // in first tower, fill with all disks; others will be empty
        towers[0] = new Tower(disk);
        for (int i = 1; i < tower; i++) {
            towers[i] = new Tower();
        }
        // view initial contents
        for (int i = 0; i < towers.length; i++) {
            System.out.println("Tower " + i + ": " + towers[i]);
        }
        return "WIP";
    }
}
