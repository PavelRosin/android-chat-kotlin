package edu_chat.android.com.edu_chat.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

import chat.edu.edu_chat.R;


/**
 * Created by mingdimao on 6/23/17.
 * Edu.Chat Inc.
 */

public class SelectPicPopupWindow extends PopupWindow {
    private final View MenuView;

    public SelectPicPopupWindow(@NonNull Activity context, View.OnClickListener itemOnCliCk) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        MenuView = inflater.inflate(R.layout.alert_dialog, null);
        Button btn_take_photo = MenuView.findViewById(R.id.btn_take_photo);
        Button btn_pick_photo = MenuView.findViewById(R.id.btn_pick_photo);
        Button btn_cancel = MenuView.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        btn_pick_photo.setOnClickListener(itemOnCliCk);
        btn_take_photo.setOnClickListener(itemOnCliCk);
        this.setContentView(MenuView);
        this.setWidth(LayoutParams.MATCH_PARENT);
        this.setHeight(LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.AnimBottom);
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        this.setBackgroundDrawable(dw);
        MenuView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, @NonNull MotionEvent motionEvent) {
                int height = MenuView.findViewById(R.id.pop_layout).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
    }
}
