package edu_chat.android.com.edu_chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import chat.edu.edu_chat.R.drawable;

/**
 * Created by yuandali on 7/24/16.
 * Edu.Chat Inc.
 */

public class ContactSideBar extends View {

    @NonNull private final Paint paint = new Paint();
    @NonNull private final String[] alphabet = {
            "A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X",
            "Y", "Z", "#"
    };
    private int currentChosenAlphabetIndex = -1;
    @Nullable private TextView textViewDialog;
    @Nullable private onLetterTouchedChangeListener onLetterTouchedChangeListener;

    public ContactSideBar(final Context context) {
        super(context);
    }

    public ContactSideBar(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public ContactSideBar(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTextViewDialog(@Nullable final TextView textViewDialog) {
        this.textViewDialog = textViewDialog;
    }

    @Override
    public boolean dispatchTouchEvent(@NonNull final MotionEvent event) {
        final float touchYPos = event.getY();
        final int preChosenAlphabetIndex = this.currentChosenAlphabetIndex;
        final onLetterTouchedChangeListener listener = this.onLetterTouchedChangeListener;
        final int currentTouchIndex = (int) (touchYPos / (float) this.getHeight() * (float) this
                .alphabet
                .length);

        if (event.getAction() == MotionEvent.ACTION_UP) {
            this.setBackgroundColor(Color.WHITE);
            this.currentChosenAlphabetIndex = -1;
            this.invalidate();
            if (this.textViewDialog != null) {
                this.textViewDialog.setVisibility(View.GONE);
            }
        } else {
            this.setBackgroundResource(drawable.sidebar_background);
            if (currentTouchIndex != preChosenAlphabetIndex) {
                if (currentTouchIndex >= 0 && currentTouchIndex < this.alphabet.length) {
                    if (listener != null) {
                        listener.onTouchedLetterChange(this.alphabet[currentTouchIndex]);
                    }

                    if (this.textViewDialog != null) {
                        this.textViewDialog.setText(this.alphabet[currentTouchIndex]);
                        this.textViewDialog.setVisibility(View.VISIBLE);
                    }

                    this.currentChosenAlphabetIndex = currentTouchIndex;
                    this.invalidate();
                }
            }
        }
        return true;
    }

    @Override
    protected void onDraw(@NonNull final Canvas canvas) {
        super.onDraw(canvas);

        final int viewHeight = this.getHeight();
        final int viewWidth = this.getWidth();
        final int heightPerAlphabet = viewHeight / this.alphabet.length;
        // Draw indexes
        for (int i = 0; i < this.alphabet.length; i++) {
            this.paint.setColor(Color.rgb(34, 66, 99));
            this.paint.setTypeface(Typeface.DEFAULT_BOLD);
            this.paint.setTextSize(20.0F);
            this.paint.setAntiAlias(true);
            // Differenciate the chosen indexes
            if (this.currentChosenAlphabetIndex == i) {
                this.paint.setColor(Color.parseColor("#3399FF"));
                this.paint.setFakeBoldText(true);
            }
            final float xPos = (float) (viewWidth / 2) - this.paint.measureText(this.alphabet[i])
                    / 2.0F;
            final float yPos = (float) (heightPerAlphabet * i + heightPerAlphabet);
            canvas.drawText(this.alphabet[i], xPos, yPos, this.paint);
            this.paint.reset();
        }
    }

    public void setOnLetterTouchedChangeListener(
            @Nullable final onLetterTouchedChangeListener onLetterTouchedChangeListener) {
        this.onLetterTouchedChangeListener = onLetterTouchedChangeListener;
    }

    public interface onLetterTouchedChangeListener {
        void onTouchedLetterChange(String letterTouched);
    }

}
