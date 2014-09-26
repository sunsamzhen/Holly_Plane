package groupd.com.holly_plane;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Created by sunsam on 2014/9/23.
 */
public class Planes {

    //Position
    private Point mPos = new Point();
    //Graphic
    private Bitmap mImage;
    //speed
    private Point mV = new Point();
    //Gravity
    private Point mA = new Point();
    //Size
    private Point mSize = new Point();

    private int life;

    private int currlife;

    private boolean alive=true;

    private boolean isboss=false;



    private int piccount=0;


    //Move
    public void move() {
        //Cal X
        mPos.x += mV.x;
        //Cal Y
        mPos.y += mV.y;

        mV.x +=  mA.x;
        mV.y += mA.y;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(mImage, mPos.x, mPos.y, null);
    }

    public  Point getPos() {
        return new Point(mPos.x, mPos.y);
    }

    public void setPos(int x, int y) {
        mPos.x = x;
        mPos.y = y;
    }

    public Point getV() {
        return new Point(mV.x, mV.y);
    }

    public Point getImSize() {
        return new Point(mSize.x, mSize.y);
    }

    public int getLife(){
        return life;
    }


    public int getCurrlife(){
        return currlife;
    }

    public void dead(){
        alive=false;
    }

    public boolean isalive(){
        return alive;
    }


    public void setLife(int l){
        //life=l;
        currlife=l;
    }

    public void setV(int vx, int vy) {
        mV.x = vx;
        mV.y = vy;
    }

    public void setImage(Bitmap image) {
        mImage = image;

        mSize.x = mImage.getWidth();
        mSize.y = mImage.getHeight();
    }


    public Planes(int x, int y, int vx, int vy, Bitmap image,int life1) {
        setPos(x, y);
        setV(vx, vy);
        setImage(image);

        setLife(life1);
        if(life1==4)
        {
            setLife(300);
            isboss=true;

        }
         life=life1;
    }

    public boolean isIsboss(){
        return isboss;
    }

    public void countplus() {
        piccount++;
    }
    public int getCount(){
        return piccount;
    }
}
