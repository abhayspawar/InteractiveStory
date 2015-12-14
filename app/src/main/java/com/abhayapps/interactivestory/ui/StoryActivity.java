package com.abhayapps.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.abhayapps.interactivestory.R;
import com.abhayapps.interactivestory.model.Page;
import com.abhayapps.interactivestory.model.Story;


public class StoryActivity extends ActionBarActivity {

    public static final String TAG=StoryActivity.class.getSimpleName();

    private Story mStory=new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoiceButton1;
    private Button mChoiceButton2;
    private String mName;
    private Page mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent=getIntent();
        mName=intent.getStringExtra("name");
        Log.d(TAG,mName);

        mImageView=(ImageView) findViewById(R.id.storyImageView);
        mTextView=(TextView) findViewById(R.id.storyTextView);
        mChoiceButton1=(Button) findViewById(R.id.choiceButton1);
        mChoiceButton2=(Button) findViewById(R.id.choiceButton2);

        loadpage(0);
    }

    private void loadpage(int choice) {
        mCurrentPage = mStory.getPage(choice);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);

        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);

        if (mCurrentPage.isFinalPage()) {
            mChoiceButton1.setVisibility(View.INVISIBLE);
            mChoiceButton1.setText("");
            mChoiceButton2.setText("Play Again");
            mChoiceButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else {
            mChoiceButton1.setText(mCurrentPage.getChoice1().getText());
            mChoiceButton2.setText(mCurrentPage.getChoice2().getText());

            mChoiceButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int NextPage = mCurrentPage.getChoice1().getNextPage();
                    loadpage(NextPage);
                }
            });
            mChoiceButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int NextPage = mCurrentPage.getChoice2().getNextPage();
                    loadpage(NextPage);
                }
            });
        }
    }
}
