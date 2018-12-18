package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import ro.sapietia.ms.carinformation.R;

public class ItemInformation extends Activity implements View.OnClickListener {

    private ImageView profile_image;
    private ImageView camera;

    private String userChoosenTask;
    private int REQUEST_CAMERA= 0, SELECT_FILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            setContentView(R.layout.activity_item_information);
            setUI();
            seUITEXT();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void seUITEXT() {
    }

    private void setUI(){
        profile_image = (ImageView) findViewById(R.id.imageViewPhotoItemInformation);
        camera = (ImageView)findViewById(R.id.imageViewAddPhoto);
        camera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageViewAddPhoto:
                selectImage();
                break;
        }
    }

    private void selectImage() {

        final  CharSequence[] items  = {"Take Photo", "Chose from Library", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(ItemInformation.this);
        builder.setTitle("Add photo");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {

                boolean result = Utility.ChecPermissions(ItemInformation.this);

                if(items[item].equals("Take Photo")){
                    userChoosenTask = "Take photo";
                    if (result)
                        cameraIntent();
                }else if (items[item].equals("Chose from Library")){
                    userChoosenTask = "Chose from Library";
                    if(result)
                        galleryIntent();
                }
                else if(items[item].equals("Cancel")){
                    dialogInterface.dismiss();
                }
            }
        });


        builder.show();
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent = intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select file"), SELECT_FILE);

    }

    private void cameraIntent() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }
}