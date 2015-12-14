package com.abhayapps.interactivestory.model;

/**
 * Created by abhay on 12-04-2015.
 */
public class Choice {
    public String mText;
    public int mNextPage;

    public Choice(String text,int nextPage){
        mText=text;
        mNextPage=nextPage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
