import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Grid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grid extends World
{
    public int A[][] = new int[4][4];
    public Tile T[][]= new Tile[4][4];
    /**
     * Constructor for objects of class Grid.
     * 
     */

    public Grid()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(556, 600, 1);
        prepare();
    }

    

    //You've been Initialised
    public void initialise()
    {   int p,q;

        for(p=0;p<4;p++)
        {
            for(q=0;q<4;q++)
            {   
                A[p][q]=0;
                T[p][q].val = A[p][q] ;
                System.out.printf("Initialising");
            }
        }

    }
    
    //getitbro
    public Tile getTile(int i,int j)
    {
        return T[i][j];
    }
    
    
    Tile tile;
   //getitbro
    public Tile geT()
    {
        return tile;
    }
    
    public String key;
    public char ckey;
    private boolean status;
    private boolean win = false;
    private boolean dead;
    Counter count=new Counter();

    //are ya ready??
    private void prepare()
    {
        System.out.println("Initialising");
        int i=Greenfoot.getRandomNumber(4);
        int j=Greenfoot.getRandomNumber(4);
        int k=3-i;
        int l=3-j;
        //int k=Greenfoot.getRandomNumber(4);
        //int l=Greenfoot.getRandomNumber(4);

        /**while(i==k && j==l)
        {
            k=Greenfoot.getRandomNumber(4);
            l=Greenfoot.getRandomNumber(4);
        }*/
        System.out.printf("Going to Initialise");
        
        int p,q;

        for(p=0;p<4;p++)
        {
            for(q=0;q<4;q++)
            {   
                A[p][q]=0;
                T[p][q] = new Tile(A[p][q]);
                System.out.printf("Initialising");
            }
        }
        
        
        int x1=(j)*134+77;
        int y1=(i)*134+77;
        int x2=(l)*134+77;
        int y2=(k)*134+77;
       
        /**Tile tile = new Tile();
        tile.drawTile(T[i][j],2);
        tile.drawTile(T[k][l],2);*/

        //T[i][j].drawTile(2);
        //T[k][l].drawTile(2);

        T[i][j] = new Tile(2);
        T[k][l] = new Tile(2);

        //Tile tile = new Tile(2);

        addObject(T[i][j],x1,y1);
        addObject(T[k][l],x2,y2);
        A[i][j]=2;
        A[k][l]=2;
        //printmatrix();
        //B[i][j]=img;
        //B[k][l]=img;
        addObject(count,278,578);
    }

    public void act() {
        String key = Greenfoot.getKey();
        if(key!=null)
        {
        int i,j;
        System.out.println("Inside Act method");
        
        if(/**key!=null && */key.equals("left"))
        { 
            UpdateBoard('L');
            System.out.println("Key pressed = " + key);
        }

        else if(/**key != null && */key.equals("right"))
        {
            UpdateBoard('R');
            System.out.println("Key pressed = " + key);
        }

        else if(/**key != null && */key.equals("up"))
        {
            UpdateBoard('U');
            System.out.println("Key pressed = " + key);
        }

        else if(/**key != null && */key.equals("down"))
        {
            UpdateBoard('D');
            System.out.println("Key pressed = " + key);
        }

        printmatrix(); 
        dead = checkdead(); //u dead?
        System.out.println("Done checkdead");
        status = (dead || win);
        if(status==false /** key!=null*/)
        {   
            System.out.println("Inside Status is false");
            addRandom();
            //UpdateBoard('L');
        } 
        
        else if(dead)
        {System.out.println("Game Over");}
        else if(win)
        {System.out.println("You win");}  
        }
    }
    //flashthatmatrix
    public void printmatrix()
    {   int i,j;

        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    //randommmmmm
    public void addRandom()
    {
        int X[] = new int[16];
        int Y[] = new int[16];
        int r = 0;
        int i,j;
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(A[i][j]==0)
                {
                    X[r]=i;
                    Y[r]=j;
                    r++;
                }

            }
        }
        System.out.printf("r value = %d ",r);
        if(r==0)
            return;

        int rand=0;
        if(Greenfoot.getRandomNumber(10)>2)
            rand = 2;
        else
            rand = 4;

        int k = Greenfoot.getRandomNumber(r);
        A[X[k]][Y[k]] = rand; 
        T[X[k]][Y[k]] = new Tile(rand);
        //Tile R = new Tile(rand);
        System.out.printf("Random i= %d,j = %d,val=%d ",X[k],Y[k],rand);
        int x1=(Y[k])*134+77;
        int y1=(X[k])*134+77; 
        addObject(T[X[k]][Y[k]],x1,y1);
        printmatrix();
    }
    
    //You dead if you dead
    public boolean checkdead()
    {
        int i,j;
        boolean dead = true;

        for(i=0;i<4;i++) 
        {   
            for(j=0;j<4;j++)
            {   
                if(A[i][j]==0)
                    dead=false;
                else if(i!=3)
                {   if((A[i][j] == A[i+1][j]) || (A[i+1][j] == 0))
                        dead = false;

                }

                else if(j!=3)
                {   if((A[i][j] == A[i][j+1]) || (A[i][j+1] == 0))
                        dead = false;

                }

            }
        }    
        return dead;
    }
    
    //the-new-swag
    public void UpdateBoard(char c)
    {
        int i,j,k,x,y;  
        //if right key was pressed
        if(c == 'R')
        {
            for(i=0;i<4;i++)
            {
                for(j=2 ;j>=0;j--)
                {
                    if(A[i][j]!=0)
                    {   k=j; 
                        while(k<3)
                        { 
                            x=(k+1)*134+77;
                            y=(i)*134+77;
                            if(A[i][k+1]==0)
                            {   A[i][k+1]=A[i][k];
                                T[i][k+1].drawTile(A[i][k+1]);
                                addObject(T[i][k+1],x,y);

                                A[i][k]=0;
                                removeObjects(getObjectsAt(x-134,y,Tile.class));
                                //T[i][k]=null;
                                if(A[i][k+1]==2048)
                                    win = true;
                                k++;

                            }

                            else if(A[i][k]==A[i][k+1])
                            {
                                A[i][k+1]*=2;
                                T[i][k+1].drawTile(A[i][k+1]);
                                addObject(T[i][k+1],x,y);

                                count.add(A[i][k+1]);
                                A[i][k]=0;
                                //removeObject(T[i][k]);
                                removeObjects(getObjectsAt(x-134,y,Tile.class));
                                //T[i][k]=null;
                                if(A[i][k+1]==2048)
                                    win = true;
                                k++;

                            }
                            
                            else
                                k++;
                        }
                    }

                }
            }
        }

        if(c == 'L')
        {
            for(i=0;i<4;i++)
            {
                for(j=1;j<=3;j++)
                {
                    if(A[i][j]!=0)
                    { k=j; 
                        while(k>0)
                        {
                            x=(k-1)*134+77;
                            y=(i)*134+77;
                            if(A[i][k-1]==0)
                            {   A[i][k-1]=A[i][k];
                                //T[i][k-1]= new Tile(A[i][k-1]);
                                //addObject(new Tile(A[i][k-1]),x,y);
                                //Tile tile = getTile(i,k-1);
                                T[i][k-1].drawTile(A[i][k-1]);
                                addObject(T[i][k-1],x,y);
                                //T[i][k-1].setLocation(x,y);
                                
                                A[i][k]=0;
                                removeObjects(getObjectsAt(x+134,y,Tile.class));
                                //T[i][k]=null;

                                if(A[i][k-1]==2048)
                                    win = true;

                                k--;
                            }

                            else if(A[i][k]==A[i][k-1])
                            {
                                A[i][k-1]*=2;
                                count.add(A[i][k-1]);
                                //T[i][k-1]=new Tile(A[i][k-1]);
                                //Tile tile = getTile(i,k-1);
                                T[i][k-1].drawTile(A[i][k-1]);
                                addObject(T[i][k-1],x,y);
                                //T[i][k-1].setLocation(x,y);

                                A[i][k]=0;
                                removeObjects(getObjectsAt(x+134,y,Tile.class));
                                // T[i][k]=null;
                                if(A[i][k-1]==2048)
                                    win = true;

                                k--;
                            }
                            else
                                k--;
                        }
                    }

                }
            }
        }    

        if(c == 'U')
        {
            for(i=1;i<=3;i++)
            {
                for(j=3;j>=0;j--)
                {
                    if(A[i][j]!=0)
                    {    k=i; 
                        while(k>0)
                        { 
                            x=(j)*134+77;
                            y=(k-1)*134+77;
                            if(A[k-1][j]==0)
                            {   A[k-1][j]=A[k][j];
                                T[k-1][j].drawTile(A[k-1][j]);
                                addObject(T[k-1][j],x,y);

                                A[k][j]=0;
                                //removeObject(T[k][j]);
                                removeObjects(getObjectsAt(x,y+134,Tile.class));
                                //T[k][j]=null;
                                if(A[i][k-1]==2048)
                                    win = true;

                                k--;
                            }

                            else if(A[k][j]==A[k-1][j])
                            {
                                A[k-1][j]*=2;
                                count.add(A[k-1][j]);
                                T[k-1][j].drawTile(A[k-1][j]);
                                addObject(T[k-1][j],x,y);

                                A[k][j]=0;
                                //removeObject(T[k][j]);
                                removeObjects(getObjectsAt(x,y+134,Tile.class));
                                //T[k][j]=null;

                                if(A[i][k-1]==2048)
                                    win = true;

                                k--;

                            }
                            else
                                k--;
                        }
                    }

                }
            }
        }

        if(c == 'D')
        {
            for(i=2;i>=0;i--)
            {
                for(j=0;j<4;j++)
                {
                    if(A[i][j]!=0)
                    {   k=i; 
                        while(k<3)
                        { 
                            x=(j)*134+77;
                            y=(k+1)*134+77;
                            if(A[k+1][j]==0)
                            {   A[k+1][j]=A[k][j];
                                T[k+1][j].drawTile(A[k+1][j]);
                                addObject(T[k+1][j],x,y);

                                A[k][j]=0;
                                //removeObject(T[k][j]);
                                removeObjects(getObjectsAt(x,y-134,Tile.class));
                                //T[k][j]=null;
                                if(A[k+1][j]==2048)
                                    win = true;

                                k++;
                            }

                            else if(A[k][j]==A[k+1][j])
                            {
                                A[k+1][j]*=2;
                                count.add(A[k+1][j]);
                                T[k+1][j].drawTile(A[k+1][j]);
                                addObject(T[k+1][j],x,y);

                                A[k][j]=0;
                                //removeObject(T[k][j]);
                                removeObjects(getObjectsAt(x,y-134,Tile.class));
                                //T[k][j]=null;
                                if(A[i][k+1]==2048)
                                    win = true;

                                k++;
                            }  
                            else 
                                k++;
                        }
                    }
                }
            }
        }   
    }

}
