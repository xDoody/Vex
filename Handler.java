package vex;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class Handler {
    public LinkedList<GameObject> object = new LinkedList<>();
    public void tick()
    {
    for(int i=0;i<object.size();i++)
        {
            GameObject tempObject = object.get(i);
            
            tempObject.tick();
        }
    }
    
    public void setX(float x){
    for(int i=0;i<object.size();i++){
        GameObject tempObject=object.get(i);
        
        tempObject.setX(x);
    }
    }
    public void sety(float y){
    for(int i=0;i<object.size();i++){
        GameObject tempObject=object.get(i);
        
        tempObject.setY(y);
    }
    }
    public void setVelY(float y)
    {
    for(int i=0;i<object.size();i++){
        GameObject tempObject=object.get(i);
        
        tempObject.setVelY(y);
    }
    }
    
    
    public void fly()
    {
        for(int i=0;i<object.size();i++){
            GameObject tempObject=object.get(i);
            tempObject.setVelY(tempObject.getVelY()*-1);
        }
    }
    
    public int countDrops()
    {
    return object.size();
    }
    
    
    
    public void render(Graphics2D g)
    {
    for(int i=0;i<object.size();i++)
    {
        GameObject tempObject= object.get(i);
        tempObject.render(g);
    }
    }
    public void addObject(GameObject object)
    {
    this.object.add(object);
    }
    public void removeObject(GameObject object)
    {
    this.object.remove(object);
    }
    
    public void CutInHalf()
    {
        for(int i=0;i<object.size();i++)
    {
        GameObject tempObject= object.get(i);
        removeObject(tempObject);
    }
    }
    
}