package groupd.com.holly_plane;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MyActivity extends Activity {

    private Button button_start;
    private Button button_about;
    private Button button_exit;
    private MediaPlayer mediaPlayer;
    private MediaPlayer player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        button_start= (Button) findViewById(R.id.button);
        button_about= (Button) findViewById(R.id.button2);
        button_exit= (Button) findViewById(R.id.button3);
        mediaPlayer=MediaPlayer.create(this,R.raw.bgm2);
        player=MediaPlayer.create(this,R.raw.espada);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();
                Intent intent = new Intent(MyActivity.this,Game.class);
                startActivity(intent);

            }
        });

        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();
                Intent intent = new Intent(MyActivity.this,About.class);
                startActivity(intent);
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.seekTo(0);
        mediaPlayer.start();
    }
}
