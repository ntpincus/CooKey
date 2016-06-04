package edu.ucsb.cs185.carlygracelarsson.cookey;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;



public class InstructionStep extends RelativeLayout {

    public InstructionStep(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        View myView = inflater.inflate(R.layout.instruction_step, this);
    }
}
