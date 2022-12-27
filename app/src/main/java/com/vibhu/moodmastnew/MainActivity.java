package com.vibhu.moodmastnew;
// Never use media player if file size is less than 1mb because it has more latency than soundpool. (looping gap);
// Compelled to use sound pool along with media player because soundPool play timing is only 5 sec for bigger file.
//Exported project on gitHub on 27/12/2022

import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView mBottomNavigation;
    private ViewPager viewPager;

    public static  MediaPlayer mediaPlayerSeagull;
    public static MediaPlayer mediaPlayerWave;

    private RelativeLayout relativeLayoutMain;

//    public static int streamIdSeagull;
    public static int streamIdCampfire;
    public static int streamIdWave;
    public static int streamIdRain;

    public static float volumeSeagull = 0.5f;
    public static float volumeCampfire = 0.5f;
    public static float volumeWave = 0.5f;
    public static float volumeRain = 0.5f;

    public static LinearLayout controller;
    private LinearLayout autoPlay;
    public static ToggleButton btnPlayPause;

 //----------For soundPool(formally used media player but had so many latency while looping the audio file-------------------
    public static SoundPool soundPool;

//    public static int soundPoolSeagull;
    public static int soundPoolCampfire;
//    public static int soundPoolWave;
    public static int soundPoolRain;


//-----------For fragments----------------------
    public static boolean seagull = false;
    public static boolean campfire = false;
    public static boolean waves = false;
    public static boolean rain = false;
    public static boolean storm = false;
    public static boolean boat = false;
    public static boolean rowboat = false;
    public static boolean guitar = false;
    public static int verify;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.prussian_blue_1)));

        mBottomNavigation = findViewById(R.id.buttom_navigation);
        mBottomNavigation.setOnNavigationItemSelectedListener(this);

        AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();

        soundPool = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(audioAttributes).build();
//        soundPoolRainObj = new SoundPool.Builder().setMaxStreams(10).setAudioAttributes(audioAttributes).build();

//        soundPoolSeagull = soundPool.load(this,R.raw.seagull,1);
        soundPoolCampfire = soundPool.load(this,R.raw.campfire,1);
//        soundPoolWave = soundPool.load(this,R.raw.waves,1);
        soundPoolRain = soundPool.load(this,R.raw.rain,1);


         mediaPlayerSeagull = MediaPlayer.create(this,R.raw.seagull);
         mediaPlayerWave = MediaPlayer.create(this,R.raw.waves);

        relativeLayoutMain = findViewById(R.id.rlMain);

        controller = findViewById(R.id.controller);
        autoPlay = findViewById(R.id.autoPlay);
        viewPager = findViewById(R.id.view_pager);
        btnPlayPause = findViewById(R.id.soundsButton);

        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mViewPagerAdapter);
        viewPager.setOffscreenPageLimit(2);


        controller.setVisibility(View.GONE);







        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mBottomNavigation.getMenu().findItem(R.id.menu_seaside).setChecked(true);
                        Objects.requireNonNull(getSupportActionBar()).setTitle("Seaside");
                        relativeLayoutMain.setBackgroundColor(getResources().getColor(R.color.prussian_blue_0));
                        controller.setBackgroundResource(R.drawable.controller_shape);
                        autoPlay.setBackgroundResource(R.drawable.controller_shape);
                        mBottomNavigation.setBackgroundColor(getResources().getColor(R.color.prussian_blue_1));
                        getWindow().setNavigationBarColor(getResources().getColor(R.color.prussian_blue_1));
                        getWindow().setStatusBarColor(getResources().getColor(R.color.prussian_blue_1));
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.prussian_blue_1)));
                        break;
                    case 1:
                        mBottomNavigation.getMenu().findItem(R.id.menu_city).setChecked(true);
                        Objects.requireNonNull(getSupportActionBar()).setTitle("City");
                        relativeLayoutMain.setBackgroundColor(getResources().getColor(R.color.arsenic_0));
                        controller.setBackgroundResource(R.drawable.controller_shape_city);
                        autoPlay.setBackgroundResource(R.drawable.controller_shape_city);
                        mBottomNavigation.setBackgroundColor(getResources().getColor(R.color.arsenic_1));
                        getWindow().setNavigationBarColor(getResources().getColor(R.color.arsenic_1));
                        getWindow().setStatusBarColor(getResources().getColor(R.color.arsenic_1));
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.arsenic_1)));
                        break;
                    case 2:
                        mBottomNavigation.getMenu().findItem(R.id.menu_jungle).setChecked(true);
                        Objects.requireNonNull(getSupportActionBar()).setTitle("Jungle");
                        break;
                    case 3:
                        mBottomNavigation.getMenu().findItem(R.id.menu_countryside).setChecked(true);
                        Objects.requireNonNull(getSupportActionBar()).setTitle("Countryside");
                        break;
                    case 4:
                        mBottomNavigation.getMenu().findItem(R.id.menu_asia).setChecked(true);
                        Objects.requireNonNull(getSupportActionBar()).setTitle("South Asia");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });





        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!btnPlayPause.isChecked()){

                    stopSeagull();
                    stopWave();
                    stopCampfire(streamIdCampfire);
//                    stopWaves(streamIdWave);
                    stopRain(streamIdRain);

                } else {



                    if(seagull){
                        playSeagull();
                    }

                    if(campfire){
                        streamIdCampfire = playCampfire();
                    }

                    if(waves){
//                        streamIdWave = playWaves();
                    playWave();
                    }


                    if(rain){
                       streamIdRain =  playRain();
                    }

                }
            }
        });








    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_frame_layout, fragment);
            ft.commit();
            return true;
        }
        return false;
    }


    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.menu_seaside:
                viewPager.setCurrentItem(0);
                break;
            case R.id.menu_city:
                viewPager.setCurrentItem(1);
                break;
            case R.id.menu_jungle:
                viewPager.setCurrentItem(2);
                break;
            case R.id.menu_countryside:
                viewPager.setCurrentItem(3);
                break;
            case R.id.menu_asia:
                viewPager.setCurrentItem(4);
                break;
        }
        return true;
    }









    public  static void playSeagull(){
        mediaPlayerSeagull.start();

//        return soundPool.play(soundPoolSeagull,volumeSeagull,volumeSeagull,0,-1,1);
    }

    public static int playCampfire(){
        return soundPool.play(soundPoolCampfire,volumeCampfire,volumeCampfire,0,-1,1);
    }

    public static void playWave(){
        mediaPlayerWave.start();
//       return soundPool.play(soundPoolWave,volumeWave,volumeWave,0,-1,1);
    }

    public static int playRain(){
        return soundPool.play(soundPoolRain,volumeRain,volumeRain,0,-1,1);
    }




    public static void loopSeagull(){
        mediaPlayerSeagull.setLooping(true);
    }
    public static void loopWave(){
        mediaPlayerWave.setLooping(true);
    }




    public static void stopSeagull(){
        mediaPlayerSeagull.pause();
    }

    public static void stopCampfire(int streamId){
        soundPool.stop(streamId);
    }

    public static void stopWave(){
//        soundPool.stop(streamId);
        mediaPlayerWave.pause();
    }

    public static void stopRain(int streamId){
        soundPool.stop(streamId);
    }





    public static void volumeSeagull(){
        mediaPlayerSeagull.setVolume(volumeSeagull,volumeSeagull);
    }


    public static void volumeCampfire(){
        soundPool.setVolume(streamIdCampfire,volumeCampfire,volumeCampfire);
    }

    public static void volumeWave(){
//        soundPool.setVolume(streamIdWave,volumeWave,volumeWave);

        mediaPlayerWave.setVolume(volumeWave,volumeWave);
    }

    public static void volumeRain(){
        soundPool.setVolume(streamIdRain,volumeRain,volumeRain);
    }




    public static void setPlayPauseToDefault(){
        if(!btnPlayPause.isChecked()){
            btnPlayPause.setChecked(true);
        }
    }



}
