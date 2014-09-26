package groupd.com.holly_plane;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Game extends Activity {
    //public MediaPlayer player;
    public static music music = new music();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //player.release();
        music.RelePlayer();
        music.ReleBossPlayer();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //player.pause();
        music.PausePlayer();

        music.PauseBossPlayer();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameView view = new GameView(this);
        setContentView(view);
        music.Startplayer(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
