
package towersofhanoi;

import java.util.Scanner;

/**
 * Towers of Hanoi coding challenge main file
 * @author tvtuttle
 */
public class TowersOfHanoiMain {

    /**
     * This is the main file, run this to start the program
     * takes number of towers and number of disks as inputs from user
     * towers must be between 5-10, disks between 3-40
     * Objective: move all disks from the first tower to the last tower, observing
     * the traditional rules of Towers of Hanoi
     */
    public static void main(String[] args) {
        int disks;
        int towers;
        // get towers and disks from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of disks(3-40):");
        disks = sc.nextInt();
        while(disks < 3 || disks > 40){
            System.out.println("Illegal Input. Please try again(3-40):");
            disks = sc.nextInt();
        }
        System.out.println("Please enter the number of towers(5-10)");
        towers = sc.nextInt();
        while(towers<5||towers>10){
            System.out.println("Illegal Input. Please try again(5-10)");
            towers = sc.nextInt();
        }
        // create model, initializes Tower and Disk objects
        Model towerModel = new Model();
        // print output of solve from model
        System.out.println(towerModel.solve(disks, towers));
    }
    
}
