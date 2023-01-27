package com.example.recyclerviewtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity  extends AppCompatActivity {

    private LinkedList<String> mWordList;
    private int mwordListSize;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private FloatingActionButton floatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWordList = new LinkedList<>();
        mwordListSize = 0;

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mAdapter = new WordListAdapter(this,mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.getAdapter().notifyItemInserted(mwordListSize);

        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + mwordListSize++);
        }


        floatButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWordList.add(" + Word " + String.valueOf(mwordListSize));
                mRecyclerView.getAdapter().notifyItemInserted(mwordListSize);
                mRecyclerView.smoothScrollToPosition(mwordListSize);
                mwordListSize++;
            }
        });
    }
}