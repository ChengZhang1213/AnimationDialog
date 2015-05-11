package com.chengzhang.android.animationdialog;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import com.chengzhang.alert.AnimationAlertDialog;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_test_dialog = (Button) findViewById(R.id.btn_test_dialog);
        btn_test_dialog.setOnClickListener(this);
    }

    int i;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test_dialog:
//                title_dialog();
//                title_content_dialog();
//                error_dialog();
//                success_dialog();
//                delete_dialog();
//                cancel_confirm_dialog();
//                image_dialog();
                progress_dialog();
                break;
            default:
                break;
        }
    }

    private void progress_dialog() {
        final AnimationAlertDialog alertDialog = new AnimationAlertDialog(this, AnimationAlertDialog.PROGRESS_TYPE);
        alertDialog.setTitleText("Loading...")
                .setCancelable(false);
        alertDialog.show();
        new CountDownTimer(800 * 7, 800) {
            public void onTick(long millisUntilFinished) {
                // you can change the progress bar color by ProgressHelper every 800 millis
                i++;
                switch (i){
                    case 0:
                        alertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.blue_btn_bg_color));
                        break;
                    case 1:
                        alertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_50));
                        break;
                    case 2:
                        alertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                        break;
                    case 3:
                        alertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_20));
                        break;
                    case 4:
                        alertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_blue_grey_80));
                        break;
                    case 5:
                        alertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.warning_stroke_color));
                        break;
                    case 6:
                        alertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                        break;
                }
            }

            public void onFinish() {
                i = -1;
                alertDialog.setTitleText("Success!")
                        .setConfirmText("OK")
                        .changeAlertType(AnimationAlertDialog.SUCCESS_TYPE);
            }
        }.start();
    }

    private void image_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this,AnimationAlertDialog.CUSTOM_IMAGE_TYPE);
        alertDialog.setTitleText("Image");
        alertDialog.setContentText("this is image alert");
        alertDialog.setCustomImage(R.mipmap.ic_launcher);
        alertDialog.show();
    }

    private void cancel_confirm_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this,AnimationAlertDialog.WARNING_TYPE);
        alertDialog.setTitleText("Are you sure?");
        alertDialog.setContentText("you will do some important thing?");
        alertDialog.setCancelText("No,cancel");
        alertDialog.setConfirmText("Yes,delete ");
        alertDialog.showCancelButton(true);
        alertDialog.setCancelClickListener(new AnimationAlertDialog.OnAnimationAlertClickListener() {
            @Override
            public void onClick(AnimationAlertDialog animationAlertDialog) {
                animationAlertDialog.setTitleText("Cancelled!")
                        .setContentText("Your imaginary file is safe :)")
                        .setConfirmText("OK")
                        .showCancelButton(false)
                        .setCancelClickListener(null)
                        .setConfirmClickListener(null)
                        .changeAlertType(AnimationAlertDialog.ERROR_TYPE);
            }
        });
        alertDialog.setConfirmClickListener(new AnimationAlertDialog.OnAnimationAlertClickListener() {
            @Override
            public void onClick(AnimationAlertDialog animationAlertDialog) {
                animationAlertDialog.setTitleText("Deleted!")
                        .setContentText("Your imaginary file has been deleted!")
                        .setConfirmText("OK")
                        .setConfirmClickListener(null)
                        .showCancelButton(false)
                        .changeAlertType(AnimationAlertDialog.SUCCESS_TYPE);

            }
        });
        alertDialog.show();
    }

    private void delete_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this,AnimationAlertDialog.WARNING_TYPE);
        alertDialog.setTitleText("Are you sure?");
        alertDialog.setContentText("you will do some important thing?");
        alertDialog.setConfirmClickListener(new AnimationAlertDialog.OnAnimationAlertClickListener() {
            @Override
            public void onClick(AnimationAlertDialog animationAlertDialog) {
                animationAlertDialog.setTitleText("Deleted!")
                        .setContentText("Your imaginary file has been deleted!")
                        .setConfirmText("OK")
                        .setConfirmClickListener(null)
                        .changeAlertType(AnimationAlertDialog.SUCCESS_TYPE);

            }
        });
        alertDialog.show();
    }

    private void success_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this,AnimationAlertDialog.SUCCESS_TYPE);
        alertDialog.setTitleText("SUCCESS");
        alertDialog.setContentText("congratulations!!!");
        alertDialog.show();
    }

    private void error_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this,AnimationAlertDialog.ERROR_TYPE);
        alertDialog.setTitleText("ERROR");
        alertDialog.setContentText("something went wrong");
        alertDialog.show();
    }

    private void title_content_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this);
        alertDialog.setTitleText("Are you OK");
        alertDialog.setContentText("I'm fine !!!");
        alertDialog.show();
    }

    private void title_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this);
        alertDialog.setTitleText("Are you OK");
        alertDialog.setCancelable(true);
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }
}
