package groupd.com.holly_plane;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by sunsam on 2014/9/25.
 */
public class music {
    private MediaPlayer player;
    private MediaPlayer bossplayer;

    public void Startplayer(Context context) {
        player=MediaPlayer.create(context,R.raw.bgm);
        player.setLooping(true);
        player.start();

    }
    public void PausePlayer() {

        player.pause();

    }
    public void RelePlayer() {
        player.release();

    }

    public void SetBossplayer(Context context) {
        bossplayer=MediaPlayer.create(context,R.raw.bossbgm);



    }
    public void StartBossplayer() {


        bossplayer.start();

    }

    public void PauseBossPlayer() {

        bossplayer.pause();

    }
    public void ReleBossPlayer() {
        bossplayer.release();

    }

}
