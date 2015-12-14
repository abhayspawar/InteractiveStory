package com.abhayapps.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abhayapps.interactivestory.R;


public class MainActivity extends ActionBarActivity {

    private EditText mFieldName;
    private Button mStartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFieldName = (EditText) findViewById(R.id.NameEditText);
        mStartButton = (Button) findViewById(R.id.startbutton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mFieldName.getText().toString();
                StartStory(name);
            }
        });
    }
        private void StartStory(String name){
        Intent intent =new Intent(this,StoryActivity.class);
        intent.putExtra(getString(R.string.key_name),name);
        startActivity(intent);
        }

    @Override
    protected void onResume() {
        super.onResume();
        //mFieldName.setText("");
    }
}
