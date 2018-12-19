package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static ro.sapietia.ms.carinformation.R.layout.*;

public class MyAdapter  extends RecyclerView.Adapter<MyViewHolder> {

    Context c;

    ArrayList<Car> cars;

    public MyAdapter (Context c, ArrayList<Car> cars){

        this.c = c;
        this.cars = cars;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View v = LayoutInflater.from(c).inflate(model, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int pozition){

        Car s =cars.get(pozition);

        holder.nameTxt.setText(s.getName());
        holder.img.setImageResource(s.getImage() );
    }

    @Override

    public int getItemCount(){
        return  cars.size();
    }
}
