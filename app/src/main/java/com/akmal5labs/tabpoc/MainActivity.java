package com.akmal5labs.tabpoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cc_container)
    TextView mCcContainer;
    @BindView(R.id.paypal_container)
    TextView mPaypalContainer;
    @BindView(R.id.rv)
    RecyclerView rvString;

    private Unbinder unbinder;
    private boolean mIsDown;
    private int whichClicked; // 0 = none, 1 = cc, 2 = paypal
    private List<String> mListOne;
    private List<String> mListTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        rvString.setVisibility(View.GONE);
        slideUp();
        mIsDown = false;
    }

    private void setupOne() {
        mListOne = new ArrayList<>();
        mListOne.add("one");
        mListOne.add("one");
        mListOne.add("one");

        Adapter adapter = new Adapter(mListOne);
        rvString.setAdapter(adapter);
        rvString.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupTwo() {
        mListTwo = new ArrayList<>();
        mListTwo.add("two");
        mListTwo.add("two");
        mListTwo.add("two");

        Adapter adapter = new Adapter(mListTwo);
        rvString.setAdapter(adapter);
        rvString.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick(R.id.cc_container)
    void onCC() {
        if (whichClicked == 0 || whichClicked == 1) {
            setupOne();
        }
        rvString.setVisibility(View.VISIBLE);
        if (mIsDown) {
            slideUp();
            mIsDown = false;
            whichClicked = 0;
        } else {
            slideDown();
            mIsDown = true;
            whichClicked = 1;
        }

    }

    @OnClick(R.id.paypal_container)
    void onPaypal() {
        if (whichClicked == 0 || whichClicked == 2) {
            setupTwo();
        }
        rvString.setVisibility(View.VISIBLE);
        if (mIsDown) {
            slideUp();
            mIsDown = false;
            whichClicked = 0;
        } else {
            slideDown();
            mIsDown = true;
            whichClicked = 2;
        }
    }

    private void slideDown() {
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        rvString.startAnimation(slide_down);
    }

    private void slideUp() {
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        rvString.startAnimation(slide_up);
    }
}
