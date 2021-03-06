package com.example.ricardo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import uk.co.senab.photoview.PhotoViewAttacher;


public class dsppredicacion extends AppCompatActivity {
    ImageView predicacion;
    Button direcciones;
    PhotoViewAttacher photoViewAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsppredicacion);
        predicacion = findViewById(R.id.img);
        direcciones = findViewById(R.id.direcciones2);
        photoViewAttacher = new PhotoViewAttacher(predicacion);
        Picasso.with(this)
                .load("http://creadlechile.cl/dsppredicacion.jpeg")
                .error(R.mipmap.predimantencion)
                .fit()

                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .centerInside()
                .into(predicacion);

        direcciones.setOnClickListener(new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {

                                               Intent dire = new Intent(dsppredicacion.this, Direcciones.class );
                                               startActivity(dire);
                                           }
                                       }
        );



    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_predicacion, menu);
        return super.onCreateOptionsMenu(menu);
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.anterior:
                Intent intent = new Intent(dsppredicacion.this, Predicacion.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_anim, R.anim.right_anim_out);

                return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
