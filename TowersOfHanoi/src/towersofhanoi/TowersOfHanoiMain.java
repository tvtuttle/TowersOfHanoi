
package towersofhanoi;

/**
 * emeasurematics job interview coding challenge: towers of hanoi
 * @author tvtuttle
 */
public class TowersOfHanoiMain {

    /**
     * takes number of towers and number of disks as inputs from user
     * towers must be between 5-10, disks between 3-40
     */
    public static void main(String[] args) {
        int disks;
        int towers;
        // get towers and disks from user
        // placeholder values for now
        disks = 3;
        towers = 5;
        // create model
        Model towerModel = new Model();
        // print output of solve from model
        System.out.println(towerModel.solve(disks, towers));
    }
    
}
