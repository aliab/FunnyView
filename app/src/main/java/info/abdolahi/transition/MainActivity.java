package info.abdolahi.transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity{

    ViewGroup viewGroup;
    private View s1, s2, s3, s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SmileFace(this));

//        viewGroup = (ViewGroup) findViewById(R.id.viewgroup);
//        viewGroup.setOnClickListener(this);
//
//        s1 = findViewById(R.id.s1);
//        s2 = findViewById(R.id.s2);
//        s3 = findViewById(R.id.s3);
//        s4 = findViewById(R.id.s4);


    }

//    @Override
//    public void onClick(View v) {
//        TransitionManager.beginDelayedTransition(viewGroup, new Fade());
//        toggleVisibiliy(s1, s2, s3, s4);
//    }
//
//    public static void toggleVisibiliy(View...views) {
//
//        for (View view : views) {
//            boolean isVisible = view.getVisibility() == View.VISIBLE;
//            view.setVisibility(isVisible?View.INVISIBLE:View.VISIBLE);
//        }
//    }

}
