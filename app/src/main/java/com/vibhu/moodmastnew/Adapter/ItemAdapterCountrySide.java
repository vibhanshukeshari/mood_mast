package com.vibhu.moodmastnew.Adapter;
//Sharing on Github
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.slider.Slider;
import com.vibhu.moodmastnew.Model.ItemList;
import com.vibhu.moodmastnew.R;

public class ItemAdapterCountrySide extends RecyclerView.Adapter<ItemAdapterCountrySide.mViewHolder>{

    public ItemList[] dataList;
    int initiator = 0;
    public static boolean seagull = false;
    public static boolean campfire = false;
    public static boolean waves = false;
    public static boolean rain = false;
    public static boolean storm = false;
    public static boolean boat = false;
    public static boolean rowboat = false;
    public static boolean guitar = false;

    public static int verify;


    public ItemAdapterCountrySide(ItemList[] dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());



        View mView = inflater.inflate(R.layout.single_row_item,parent,false);

        return new mViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

        final ItemList dataPosition = dataList[position];
        final boolean[] imageViewWasClicked = {true};

//
//        holder.characterTextView.setText(dataList[position].getTextView());
//        holder.characterImageView.setImageResource(dataList[position].getImageId());
//
//        holder.characterSlider.setVisibility(View.INVISIBLE);
//
//        holder.characterSlider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
//            @Override
//            public void onStartTrackingTouch(@NonNull Slider slider) {
////              today is 07/07/22 prime minister is arrived in varanasi no Fea.
//            }
//
//            @Override
//            public void onStopTrackingTouch(@NonNull Slider slider) {
//
//                if (holder.getAdapterPosition() == 0){
//                    // vibhu's trick // others use float math log etc.
//                    volumeSeagull(slider.getValue()/100);
//                }
//
//                if(holder.getAdapterPosition() == 1){
//                    volumeCampfire(slider.getValue()/100);
//                }
//
//                if(holder.getAdapterPosition() == 2){
//                    volumeWaves(slider.getValue()/100);
//                }
//
//            }
//        });
//

//        holder.characterSlider.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(position == 0){
//                    mediaPlayerSeagull.setVolume();
//                }



//            }
//        });

//        holder.characterImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//                if(imageViewWasClicked[0] ) {
//
//
//                    if(initiator == 0){
//                        controllerFadeIn(controller);
//                        initiator++;
//                    }
//
//
//
//
////     ---------------------play--------------------------
//
//                    verify = holder.getAdapterPosition();
//
//                    if(verify == 0){
//
//                        if(btnPlayPause.isChecked()){
//
//                            playSeagull();
//                            loopSeagull();
//
//                        }
//
//                        seagull = true;
//                    }
//
//                    if(verify == 1 ){
//
//                        if (btnPlayPause.isChecked()){
//
//                            playCampfire();
//                            loopCampfire();
//
//                        }
//
//                        campfire = true;
//                    }
//
//                    if(verify == 2){
//
//                        if(btnPlayPause.isChecked()){
//
//                            playWaves();
//                            loopWaves();
//                        }
//                        waves = true;
//                    }
//                    if(verify == 3){
//
//                        rain = true;
//                    }
//                    if (verify == 4){
//
//                        storm = true;
//                    }
//                    if (verify == 5){
//
//                        boat = true;
//                    }
//                    if (verify == 6){
//
//                        rowboat = true;
//                    }
//                    if(verify == 7){
//
//                        guitar = true;
//                    }
//
////         -----------------------------------------------------------
//
//                    holder.cardView.setStrokeWidth(4);
//                    holder.cardView.setStrokeColor(view.getResources().getColor(R.color.white));
//                    holder.characterSlider.setVisibility(View.VISIBLE);
//                    holder.characterTextView.setVisibility(View.INVISIBLE);
//
//                    imageViewWasClicked[0] = false;
//
//                } else{
//
//                    int verify = holder.getAdapterPosition();
//
//
//                    if(verify == 0){
//
//                        stopSeagull();
//                        seagull = false;
//
//                    }
//
//                    if(verify == 1){
//
//                        stopCampfire();
//                        campfire = false;
//
//                    }
//
//                    if(verify == 2){
//
//                        stopWaves();
//                        waves = false;
//
//                    }
//                    if(verify == 3){
//
//                        rain = false;
//                    }
//                    if (verify == 4){
//
//                        storm = false;
//                    }
//                    if (verify == 5){
//
//                        boat = false;
//                    }
//                    if (verify == 6){
//
//                        rowboat = false;
//                    }
//                    if(verify == 7){
//
//                        guitar = false;
//                    }
//
//                    holder.cardView.setStrokeWidth(0);
//                    holder.characterSlider.setVisibility(View.INVISIBLE);
//                    holder.characterTextView.setVisibility(View.VISIBLE);
//
//
//                    if(seagull || campfire || waves || rain || storm || boat || rowboat || guitar) {
//                        // Don't do any thing. vibhu
//
//                    } else {
//
//                        controllerFadeOut(controller);
//                        initiator = 0;
//
//                        setPlayPauseToDefault();
//
//                    }
//
//                    imageViewWasClicked[0] = true;
//                }
//
//
//            }
//        });
//
//
//
    }

    @Override
    public int getItemCount() {
        return dataList.length;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {

        TextView characterTextView;
        ImageView characterImageView;
        Slider characterSlider;
        MaterialCardView cardView;



        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            characterImageView = itemView.findViewById(R.id.imageView);
            characterTextView = itemView.findViewById(R.id.textView);
            characterSlider = itemView.findViewById(R.id.slider);
            cardView = itemView.findViewById(R.id.card_view);



        }
    }



    private void controllerFadeOut(final LinearLayout layout){

        Animation fadeOut = new AlphaAnimation(1,0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(500);

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                layout.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        layout.startAnimation(fadeOut);

    }

    private void controllerFadeIn(LinearLayout layout){
        Animation fadeIn = new AlphaAnimation(0,1);
        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setDuration(500);

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                layout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {



            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        layout.startAnimation(fadeIn);

    }







}
