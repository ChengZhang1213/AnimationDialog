#Dialog 样式#

----------

depends on project 
                       https://github.com/pnikosis/materialish-progress and https://github.com/pedant/sweet-alert-dialog
                      
                       
        
----------

**traditional dialog**
	
只含有title的dialog

	private void title_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this);
        alertDialog.setTitleText("Are you OK");
        alertDialog.setCancelable(true);
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }

**Content dialog**

含有title和Content的dialog
	
	private void title_content_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this);
        alertDialog.setTitleText("Are you OK");
        alertDialog.setContentText("I'm fine !!!");
        alertDialog.show();
    }
**Error dialog**
	
当出现error 需要警告用户时使用

	private void error_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this,AnimationAlertDialog.ERROR_TYPE);
        alertDialog.setTitleText("ERROR");
        alertDialog.setContentText("something went wrong");
        alertDialog.show();
    }
**Success dialog**

提醒用户操作成功

	private void success_dialog() {
        AnimationAlertDialog alertDialog = new AnimationAlertDialog(this,AnimationAlertDialog.SUCCESS_TYPE);
        alertDialog.setTitleText("SUCCESS");
        alertDialog.setContentText("congratulations!!!");
        alertDialog.show();
    }
**Delete dialog**

删除操作时，提醒用户

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
	
**Progress dialog**

加载dialog,可以在下载的时候使用，metiral 效果

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
