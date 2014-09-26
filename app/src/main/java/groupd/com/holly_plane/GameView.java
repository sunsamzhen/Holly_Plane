package groupd.com.holly_plane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sunsam on 2014/9/23.
 */
public class GameView extends View {
    private Paint mPaint = new Paint();
    private Paint FreePaint = new Paint();
    private Bitmap mImage;
    private Bitmap mImage1;
    private Bitmap mImage2;
    private Bitmap boss;
    private Bitmap mPlaneHit;
    private Bitmap BMpause;
    private Bitmap BMplay;
    private Bitmap radioactive;
    private Bitmap heart;
    private Bitmap background1;
    private Bitmap background2;
    private Bitmap background3;
    private Bitmap background4;
    private Bitmap bomb1;
    private Bitmap bomb2;
    private Bitmap bomb3;
    private Bitmap bomb4;
    private Bitmap bomb5;
    private Bitmap bomb6;
    private Bitmap bomb7;
    private Bitmap bomb8;
    private Bitmap bomb9;
    private Bitmap power;
    private Bitmap boom1;
    private Bitmap boom2;
    private Bitmap boom3;
    private Bitmap boom4;
    private Bitmap boom5;
    private Bitmap boom6;
    private Bitmap boom7;
    private Bitmap boom8;
    private Bitmap boom9;
    private Bitmap boom10;
    private Bitmap boom11;
    private Bitmap boom12;
    private Bitmap boom13;
    private Bitmap boom14;
    private Bitmap boom15;

    public MediaPlayer bossbgm;
    private Point mPos = new Point(300, 80);
    private Counter mCounter = new Counter(1000);
    private tools tools = new tools();
    private Counter mGenSpiriterCounter=new Counter(500);
    private boolean isOver=true;
    private int life = 4;//生命值
    private int type;
    private int score=0;
    private boolean pause = true;
    private boolean toolisuse = true;
    private boolean hearthitten=true;
    private int sky = 0;
    private SoundPool hit;
    private int mHit;
    private SoundPool bhit;
    private int bmHit;
    private SoundPool bbhit;
    private int bbmHit;
    private SoundPool add;
    private int addM;
    private SoundPool crush;
    private int mCrush;
    private SoundPool radio;
    private int mRadio;
    private boolean bossapp=true;


    //数组列表管理Spririte
    private ArrayList<Planes> mSpiriteList = new ArrayList<Planes>();
    private ArrayList<Bitmap> planes = new ArrayList<Bitmap>();
    private ArrayList<Bitmap> hitplanes = new ArrayList<Bitmap>();
    private ArrayList<Bitmap> bombs = new ArrayList<Bitmap>();
    private ArrayList<Bitmap> toolsboom = new ArrayList<Bitmap>();
    //make Random
    private Random mRan = new Random();
    public GameView(Context context) {
        super(context);
        mImage = BitmapFactory.decodeResource(getResources(), R.drawable.plane1);
        mImage1= BitmapFactory.decodeResource(getResources(), R.drawable.plane2);
        mImage2=BitmapFactory.decodeResource(getResources(), R.drawable.plane3);
        mPlaneHit=BitmapFactory.decodeResource(getResources(),R.drawable.apple);
        bomb1=BitmapFactory.decodeResource(getResources(),R.drawable.bomb1);
        bomb2=BitmapFactory.decodeResource(getResources(),R.drawable.bomb2);
        bomb3=BitmapFactory.decodeResource(getResources(),R.drawable.bomb3);
        bomb4=BitmapFactory.decodeResource(getResources(),R.drawable.bomb4);
        bomb5=BitmapFactory.decodeResource(getResources(),R.drawable.bomb5);
        bomb6=BitmapFactory.decodeResource(getResources(),R.drawable.bomb6);
        bomb7=BitmapFactory.decodeResource(getResources(),R.drawable.bomb7);
        bomb8=BitmapFactory.decodeResource(getResources(),R.drawable.bomb8);
        bomb9=BitmapFactory.decodeResource(getResources(),R.drawable.bomb9);
        heart=BitmapFactory.decodeResource(getResources(),R.drawable.heart);
        BMpause=BitmapFactory.decodeResource(getResources(),R.drawable.paly);
        BMplay=BitmapFactory.decodeResource(getResources(),R.drawable.stop);
        radioactive=BitmapFactory.decodeResource(getResources(),R.drawable.radioactive);
        background1=BitmapFactory.decodeResource(getResources(),R.drawable.background1);
        background2=BitmapFactory.decodeResource(getResources(),R.drawable.background2);
        background3=BitmapFactory.decodeResource(getResources(),R.drawable.background3);
        background4=BitmapFactory.decodeResource(getResources(),R.drawable.background4);
        boss=BitmapFactory.decodeResource(getResources(),R.drawable.title);
        power=BitmapFactory.decodeResource(getResources(),R.drawable.power);
        boom1=BitmapFactory.decodeResource(getResources(),R.drawable.aaa);
        boom2=BitmapFactory.decodeResource(getResources(),R.drawable.bbb);
        boom3=BitmapFactory.decodeResource(getResources(),R.drawable.ccc);
        boom4=BitmapFactory.decodeResource(getResources(),R.drawable.ddd);
        boom5=BitmapFactory.decodeResource(getResources(),R.drawable.eee);
        boom6=BitmapFactory.decodeResource(getResources(),R.drawable.fff);
        boom7=BitmapFactory.decodeResource(getResources(),R.drawable.ggg);
        boom8=BitmapFactory.decodeResource(getResources(),R.drawable.hhh);
        boom9=BitmapFactory.decodeResource(getResources(),R.drawable.iii);
        boom10=BitmapFactory.decodeResource(getResources(),R.drawable.jjj);
        boom11=BitmapFactory.decodeResource(getResources(),R.drawable.kkk);
        boom12=BitmapFactory.decodeResource(getResources(),R.drawable.lll);
        boom13=BitmapFactory.decodeResource(getResources(),R.drawable.nnn);
        boom14=BitmapFactory.decodeResource(getResources(),R.drawable.mmm);
        boom15=BitmapFactory.decodeResource(getResources(),R.drawable.ooo);

        planes.add(mImage);
        planes.add(mImage1);
        planes.add(mImage2);
        planes.add(boss);
        bombs.add(bomb1);
        bombs.add(bomb2);
        bombs.add(bomb3);
        bombs.add(bomb4);
        bombs.add(bomb5);
        bombs.add(bomb6);
        bombs.add(bomb7);
        bombs.add(bomb8);
        bombs.add(bomb9);
        toolsboom.add(boom1);
        toolsboom.add(boom2);
        toolsboom.add(boom3);
        toolsboom.add(boom4);
        toolsboom.add(boom5);
        toolsboom.add(boom6);
        toolsboom.add(boom7);
        toolsboom.add(boom8);
        toolsboom.add(boom9);
        toolsboom.add(boom10);
        toolsboom.add(boom11);
        toolsboom.add(boom12);
        toolsboom.add(boom13);
        toolsboom.add(boom14);
        toolsboom.add(boom15);

        bossbgm=MediaPlayer.create(context,R.raw.bossbgm);
        hit=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mHit=hit.load(context,R.raw.hit,1);
        bhit=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        bmHit=bhit.load(context,R.raw.bighit,1);
        bbhit=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        bbmHit=bbhit.load(context,R.raw.bbhit,1);
        add=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        addM=add.load(context,R.raw.add,1);
        crush=new SoundPool(6,AudioManager.STREAM_MUSIC,100);
        mCrush=crush.load(context,R.raw.crush,1);
        radio=new SoundPool(6,AudioManager.STREAM_MUSIC,100);
        mRadio=radio.load(context,R.raw.radioactive,1);
        Game.music.SetBossplayer(context);



    }

    private void genSpirite() {
        int palanenum=1;

        if(mGenSpiriterCounter.isTimeUp()&&isOver) {
            for (int i=0;i<palanenum;i++ ) {
                if(mCounter.getTime()>=20&&mCounter.getTime()<60){
                    palanenum=2;
                }
                if(mCounter.getTime()>=60&&mCounter.getTime()<120){
                    palanenum=3;
                }
                if(mCounter.getTime()>120){
                    palanenum=4;
                }

                //随机决定x坐标
                int x = mRan.nextInt(500);
                //随机决定y坐标
                int y = -40;
                //随机决定x速度
                int vx =0;
                //随机决定y速度
                int vy =  1+mRan.nextInt(2);
                type=mRan.nextInt(1);
                if(mCounter.getTime()>=20&&mCounter.getTime()<40){
                    vy =  1+mRan.nextInt(3);
                    type=mRan.nextInt(2);
                }
                if(mCounter.getTime()>=40&&mCounter.getTime()<60){
                    vy =  1+mRan.nextInt(4);
                    type=mRan.nextInt(2);
                }
                if(mCounter.getTime()>=60&&mCounter.getTime()<70){
                    vy =  1+mRan.nextInt(5);
                    type=mRan.nextInt(3);
                }
                if(mCounter.getTime()>=70&&mCounter.getTime()<80){
                    vy =  1+mRan.nextInt(6);
                    type=mRan.nextInt(3);
                }
                if(mCounter.getTime()>=80&&mCounter.getTime()<90){
                    vy =  1+mRan.nextInt(7);
                    type=mRan.nextInt(3);
                }
                if(mCounter.getTime()>=90&&mCounter.getTime()<100){
                    vy =  1+mRan.nextInt(8);
                    type=mRan.nextInt(3);
                }
                if(mCounter.getTime()>=100&&mCounter.getTime()<120){

                    if(bossapp){

                        Game.music.PausePlayer();
                        Game.music.StartBossplayer();
                        tools.SetToolTime();
                        vy=1;
                        y=-500;
                        type=3;
                        bossapp=false;
                        x = mRan.nextInt(400);
                    }


                }
               /* if(mCounter.getTime()>=110&&mCounter.getTime()<120){
                    vy =  1+mRan.nextInt(10);
                    type=mRan.nextInt(3);
                }*/
                if(mCounter.getTime()>=120){
                    vy =  1+mRan.nextInt(5);
                    type=mRan.nextInt(1);
                }


                Log.i("type", String.valueOf(type));
                Planes spirite = new Planes(x, y, vx, vy, planes.get(type),type+1);

                mSpiriteList.add(spirite);

                if (mSpiriteList.size() > 100) {
                    mSpiriteList.remove(0);
                }





            }
        }

    }

    private void moveSpirites() {
        for (int i = 0; i < mSpiriteList.size(); i++) {
            //让对应元素移动
            mSpiriteList.get(i).move();

        }
    }

    private void drawSpirites(Canvas canvas) {
        for (int i = 0; i < mSpiriteList.size(); i++) {
            //让对应元素移动
            mSpiriteList.get(i).draw(canvas);

            if(!mSpiriteList.get(i).isalive()&&mSpiriteList.get(i).getCount()<9){
                canvas.drawBitmap(bombs.get(mSpiriteList.get(i).getCount()),mSpiriteList.get(i).getPos().x,mSpiriteList.get(i).getPos().y,null);
                mSpiriteList.get(i).countplus();
            }
            if(tools.getTools()&&tools.GetCounter()<15){

                canvas.drawBitmap(toolsboom.get(tools.GetCounter()), 0, 0, null);


                tools.CounterPP();
            }
            if (mSpiriteList.get(i).getCount()==8)
            {

            }
            if (life==4){
                canvas.drawBitmap(heart,490,12,null);
                canvas.drawBitmap(heart,440,12,null);
                canvas.drawBitmap(heart,390,12,null);
            }
            if (life==3){
                canvas.drawBitmap(heart,490,12,null);
                canvas.drawBitmap(heart,440,12,null);

            }
            if (life==2){
                canvas.drawBitmap(heart,490,12,null);

            }
            if(mSpiriteList.get(i).getPos().y>900){
                life--;
                mSpiriteList.remove(i);
                if(life<=0&&!tools.isIsbossdead()) {
                    isOver = false;
                    mSpiriteList.clear();
                    mPaint.setColor(Color.RED);
                    mPaint.setStrokeWidth(50);
                    mPaint.setTextSize(80);
                    canvas.drawText(""+score,240,400,mPaint);
                    mPaint.setStrokeWidth(40);
                    mPaint.setTextSize(60);
                    canvas.drawText("GameOver",140,500,mPaint);
                    canvas.drawText("High Score",130,560,mPaint);
                    canvas.drawText("Return To Restart",40,620,mPaint);



                }
            }
        }
    }

    private void isHitten(MotionEvent event){
        for(int count = 0 ; count<mSpiriteList.size();count++){
            float x1 = mSpiriteList.get(count).getPos().x;
            float y1 = mSpiriteList.get(count).getPos().y;
            float x2 = x1+mSpiriteList.get(count).getImSize().x;
            float y2 = y1+mSpiriteList.get(count).getImSize().y;

            if(event.getX()>x1&&event.getX()<x2&&mSpiriteList.get(count).isalive()){
                if (event.getY()>y1&&event.getY()<y2) {
                    // mSpiriteList.remove(count);

                    switch (tools.Getpower()){
                        case 1:hit.play(mHit,1,1,1,0,1);
                            break;
                        case 2:bhit.play(bmHit,1,1,1,0,1);
                            break;
                        case 3:bbhit.play(bbmHit,1,1,1,0,1);
                            break;
                        case 4:bbhit.play(bbmHit,1,1,1,0,1);
                            break;
                        case 5:bbhit.play(bbmHit,1,1,1,0,1);
                            break;
                        case 6:bbhit.play(bbmHit,1,1,1,0,1);
                            break;
                    }



                    mSpiriteList.get(count).setLife(mSpiriteList.get(count).getCurrlife()-tools.Getpower());
                    Log.i("hjg", String.valueOf(mSpiriteList.get(count).getCurrlife()));
                    if(mSpiriteList.get(count).isIsboss()) {
                        Log.i("boss", "boss");
                    }
                    if(mSpiriteList.get(count).getCurrlife()<=0) {
                        PlaneCruch(count);
                        if(mSpiriteList.get(count).isIsboss()) {
                            tools.bossdead();
                        }

                    }
                }
            }
        }

    }


    private void isPluse(MotionEvent event){

            float x1 = 10;
            float y1 = 30;
            float x2 = 56;
            float y2 = 76;

            if(event.getX()>x1&&event.getX()<x2){
                if (event.getY()>y1&&event.getY()<y2) {
                    // mSpiriteList.remove(count);


                    Log.i("hit","hit");
                    if (pause){
                        pause=false;
                    }else {
                        pause=true;
                        invalidate();

                    }


                    }
                }
            }

    private void Tools(MotionEvent event){

        float x1 = 12;
        float y1 = 900;
        float x2 = 58;
        float y2 = 946;

        if(event.getX()>x1&&event.getX()<x2&&toolisuse){
            if (event.getY()>y1&&event.getY()<y2) {
                // mSpiriteList.remove(count);

               radio.play(mRadio,1,1,1,0,1);
               toolisuse=false;
                tools.usetools();
                mSpiriteList.clear();



            }
        }
    }


    private void hitHeart(MotionEvent event,int pos){

        float x1 = 200;
        float y1 = pos;
        float x2 = 446;
        float y2 = pos+46;

        if(event.getX()>x1&&event.getX()<x2&&toolisuse){
            if (event.getY()>y1&&event.getY()<y2) {
                // mSpiriteList.remove(count);

              if(life<4){
                  life++;
                  add.play(addM,1,1,1,0,1);
              }
                hearthitten=false;
                tools.ResetHeartpos();




            }
        }
    }

    private void hitTool1(MotionEvent event,int pos){

        float x1 = 220;
        float y1 = pos;
        float x2 = 300;
        float y2 = pos+80;

        if(event.getX()>x1&&event.getX()<x2&&toolisuse){
            if (event.getY()>y1&&event.getY()<y2) {
                // mSpiriteList.remove(count);
            add.play(addM,1,1,1,0,1);
             tools.Setpower();
             tools.Tool1Hit();

            }
        }
    }

    private void hitTool2(MotionEvent event,int pos){

        float x1 = 400;
        float y1 = pos;
        float x2 = 480;
        float y2 = pos+80;

        if(event.getX()>x1&&event.getX()<x2&&toolisuse){
            if (event.getY()>y1&&event.getY()<y2) {
                // mSpiriteList.remove(count);
                add.play(addM,1,1,1,0,1);
                tools.Setpower();
                tools.Tool2Hit();
            }
        }
    }
    private void PlaneCruch(int count){
        mSpiriteList.get(count).setV(0,0);
        if (mSpiriteList.get(count).getLife()==3){
            score+=10;
        }
        if (mSpiriteList.get(count).getLife()==2){
            score+=5;
        }
        if (mSpiriteList.get(count).getLife()==1){
            score+=3;
        }
        crush.play(mCrush,1,1,1,0,1);
        mSpiriteList.get(count).setImage(mPlaneHit);

        mSpiriteList.get(count).dead();
      /*  if (count>4) {
            mSpiriteList.remove(count - 4);
        }*/



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (sky>=0&&sky<1956) {
            canvas.drawBitmap(background1, 0, -(background1.getHeight() - 960) + sky, null);
        }
        if (sky>=996&&sky<4004) {
            canvas.drawBitmap(background2, 0, -(background1.getHeight() - 960) + sky-1956, null);
        }
        if (sky>=2960&&sky<6052) {
            canvas.drawBitmap(background3, 0, -(background1.getHeight() - 960) + sky-4004, null);
        }
        if (sky>=5092&&sky<=8100) {
            canvas.drawBitmap(background4, 0, -(background1.getHeight() - 960) + sky-6052, null);
            if (sky==8100-960) {
                sky = 0;
            }
        }


        sky++;
        canvas.drawLine(0,880,540,880,mPaint);
        if (tools.isIsbossdead()){
            FreePaint.setTextSize(100);
            FreePaint.setColor(Color.GREEN);
            canvas.drawText("Free Style",50,400,FreePaint);
        }
        if(pause){
            canvas.drawBitmap(BMplay,10,30,null);
        }else {
            canvas.drawBitmap(BMpause,10,30,null);
        }
        moveSpirites();
        drawSpirites(canvas);
        genSpirite();
        mCounter.tick();
        mCounter.draw(canvas);
        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(30);
        canvas.drawText("Score:" + score, 12, 25, mPaint);
        if (toolisuse) {
            canvas.drawBitmap(radioactive, 12, 900, null);
        }
        if (mCounter.getTime()%30==0){
            hearthitten=true;
        }
        if (mCounter.getTime()%30<5&&hearthitten){



            canvas.drawBitmap(heart, 400, tools.GetHeartpos(), null);
            tools.SetHeartpos();


        }

        if (tools.GetToolTime()){
            if(tools.isTool1hit()) {
                canvas.drawBitmap(power, 220, tools.GetTool1pos(), null);
                tools.SetTool1pos();

            }
            if (tools.isTool2hit()) {
                canvas.drawBitmap(power, 400, tools.GetTool2pos(), null);
                tools.SetTool2pos();

            }
        }

        if(isOver&&pause) {
            invalidate();
        }

        if (tools.isIsbossdead()){
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isPluse(event);
                isHitten(event);
                Tools(event);
                if (tools.GetToolTime()){
                    if(tools.isTool1hit()) {
                        hitTool1(event, tools.GetTool1pos());
                    }
                    if(tools.isTool2hit()) {
                        hitTool2(event, tools.GetTool2pos());
                    }
                }
                if (mCounter.getTime()%10<5){
                    hitHeart(event,tools.GetHeartpos());

                }
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                break;
        }




        return true;
    }
}
