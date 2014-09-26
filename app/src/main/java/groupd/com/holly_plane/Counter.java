package groupd.com.holly_plane;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by sunsam on 2014/9/23.
 */
public class Counter {
    private int mTimer = 0;
    private long mNextChange = System.currentTimeMillis() + 1000;
    private int mInterval;
    private Paint mPaint = new Paint();
    private Random random=new Random();
    //如果interval大于0，固定，否则，随机；
    public Counter (int interval){
        if (interval>0){
            mNextChange = System.currentTimeMillis()+interval;
        }else {
            mNextChange=System.currentTimeMillis()+random.nextInt(500);
        }

    }

    public boolean isTimeUp(){
        if (System.currentTimeMillis()>mNextChange){
            if (mInterval>0){
                mNextChange= System.currentTimeMillis()+mInterval;
            }else {
                mNextChange = 1000+System.currentTimeMillis()+random.nextInt(500);
            }
            return true;
        }
        return false;
    }

    public void tick() {
        if (System.currentTimeMillis() > mNextChange) {
            mTimer++;
            mNextChange = System.currentTimeMillis() + 1000;
        }
    }

    public void draw(Canvas canvas) {
    /*    mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(20);

        //canvas.drawText("" + mTimer, 380, 80, mPaint);*/
    }

    public int getTime(){
        return mTimer;
    }


}
