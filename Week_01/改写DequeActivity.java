package com.leetode.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Deque;
import java.util.LinkedList;

public class 改写DequeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Deque<String> deque = new LinkedList<String>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        Log.i("mydeque1", String.valueOf(deque));

        String str = deque.peekFirst();
        Log.i("mydeque", "str=" + str);
        System.out.println(str);
        Log.i("mydeque2", String.valueOf(deque));
        System.out.println(deque);

        while (deque.size() > 0){
//            System.out.println(deque.removeFirst());
            Log.i("mydeque", String.valueOf(deque.removeFirst()));
        }

        System.out.println(deque);
        Log.i("mydeque3", String.valueOf(deque));

    }
}