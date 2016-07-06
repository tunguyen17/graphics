import java.awt.Image;
import java.awt.image.BufferedImage;

public class Sensor{
  //Fields
  Robot robot;

  double relativeHeading;

  int maxDistance = 100;
  int sensorBar;

  Tester tester;

  int distance;

  //constructor
  //newrelativeHeading with respect to the robot
  public Sensor(Robot newRobot, double newrelativeHeading, Tester newTester){
    robot = newRobot;
    sensorBar = 0;
    relativeHeading = newrelativeHeading;
    tester = newTester;
  }

  //Getter
  public int getEndpointX(){
    return (int) (robot.getX() + maxDistance*Math.cos(relativeHeading+robot.getHeading()) + 0.5);
  }

  public int getEndpointY(){
    return (int) (robot.getY() + maxDistance*Math.sin(relativeHeading+robot.getHeading()) + 0.5);
  }

  //If distance is 5, the robot is the closest to the wall
  public int[] detect(){
    distance = maxDistance;
    sensorBar = 0;
    int xPos2 = getEndpointX();
    int yPos2 = getEndpointY();

    for(int i = 0; i < 100; i++){
      xPos2 = (int) (robot.getX() + (maxDistance-i)*Math.cos(relativeHeading+robot.getHeading()) + 0.5);
      yPos2 = (int) (robot.getY() + (maxDistance-i)*Math.sin(relativeHeading+robot.getHeading()) + 0.5);
      if(tester.sensorTest(xPos2, yPos2)){
        distance = 100 - i;
        sensorBar = 1;
        break;
      }
    }

    return new int[]{sensorBar, distance};
  }

}
