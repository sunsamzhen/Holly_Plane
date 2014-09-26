package groupd.com.holly_plane;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by sunsam on 2014/9/25.
 */
public class tools {
    private boolean toolstaic=false;
    private int counter=0;
    private int posy=0;
    private Bitmap mImage;
    private int power=1;
    private boolean isTooltim=false;
    private boolean tool1hit=true;
    private boolean tool2hit=true;
    private boolean isbossdead=false;
    private int tool1pos=-80;
    private int tool2pos=-80;

    public void usetools() {
        toolstaic=true;

    }

    public boolean getTools(){
        return toolstaic;
    }

    public void CounterPP(){
        counter++;
    }

    public int GetCounter(){
        return counter;
    }

    public void SetHeartpos(){
        posy++;
    }
    public void ResetHeartpos(){
        posy=0;
    }
    public int GetHeartpos(){

        return posy;

    }

    public void SetTool1pos(){
        tool1pos+=5;
    }

    public int GetTool1pos(){

        return tool1pos;

    }

    public void SetTool2pos(){
        tool2pos+=8;
    }

    public int GetTool2pos(){

        return tool2pos;

    }

    public void setImage(Bitmap image) {
        mImage = image;


    }

    public Bitmap getImage() {
        return mImage;


    }

    public void Setpower(){
        power++;
    }

    public int Getpower(){
        return power;
    }

    public void SetToolTime(){
        isTooltim=true;
    }

    public boolean GetToolTime(){
        return isTooltim;
    }

    public void Tool1Hit(){
        tool1hit=false;
    }

    public boolean isTool1hit(){
        return tool1hit;
    }
    public void Tool2Hit(){
        tool2hit=false;
    }

    public boolean isTool2hit(){
        return tool2hit;
    }

    public void bossdead(){
        isbossdead=true;
    }

    public boolean isIsbossdead(){
        return isbossdead;
    }



}
