import java.awt.Image;
import java.awt.image.BufferedImage;

public class Tester{
  //World
  public World world;
  public int width;
  public int height;

  public Robot robot;
  public Box[] box;

  BufferedImage img;
  //constructor
  public Tester(World world, Robot newRobot, Box[] newBox){
    width = world.width;
    height = world.height;
    robot = newRobot;
    box = newBox;

    img = world.getImg();
  }


  public boolean robotCollision(){
    boolean collided = false;

    return collided;
  }

  public boolean sensorTest(int x, int y){
    boolean collided = false;
    //System.out.println(img.getRGB(x,y));
    if(img.getRGB(x,y) ==-14336 || img.getRGB(x,y) == -16777216){collided = true;}
    return collided;
  }
}
