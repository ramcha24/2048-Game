import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    public int val;
    //immaconstruct
    public Tile(int value)
    {
        this.val=value;
        if(val!=0)
            drawTile(val);
    }
    
    public void act() 
    {

    }
  
    //Draw Tile depending on the value sum.
    public void drawTile(int value)
    {
       switch(value)
        {
            case 2:
            {
                setImage("2.jpg");
                break;
            }
            case 4:
            {
                setImage("4.jpg");
                break;
            }
            case 8:
            {
                setImage("8.jpg");
                break;
            }
            case 16:
            {
                setImage("16.jpg");
                break;
            }
            case 32:
            {
                setImage("32.jpg");
                break;
            }
            case 64:
            {
                setImage("64.jpg");
                break;
            }
            case 128:
            {
                setImage("128.jpg");
                break;
            }
            case 256:
            {
                setImage("256.jpg");
                break;
            }
            case 512:
            {
                setImage("512.jpg");
                break;
            }
            case 1024:
            {
                setImage("1024.jpg");
                break;
            }
            case 2048:
            {
                setImage("2048.jpg");
                break;
            }
            default:
            {}
        }
       
    }
     
}
