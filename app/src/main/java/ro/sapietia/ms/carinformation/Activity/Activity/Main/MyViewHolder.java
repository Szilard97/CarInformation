package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ro.sapietia.ms.carinformation.R;

public class MyViewHolder  extends RecyclerView.ViewHolder {

    TextView nameTxt;
    ImageView img;
    TextView textViewInsurance;
    TextView textViewPTR;
    TextView textViewVignette;

    public MyViewHolder (View itemView){
        super(itemView);

        nameTxt = (TextView) itemView.findViewById(R.id.nameTxt);
        img = (ImageView) itemView.findViewById(R.id.picture);
        textViewInsurance = itemView.findViewById(R.id.textViewIsuranceModelActivity);
        textViewPTR = itemView.findViewById(R.id.textViewPTRModelActivity);
        textViewVignette = itemView.findViewById(R.id.textViewVignetteModelActivity);
    }
}
