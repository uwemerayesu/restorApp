package com.example.loginfoam;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    String titles[] = {"Capati","Cake","Pizza","Chinese bread","American bread"};
    int images[] = {R.drawable.i2,R.drawable.i3,R.drawable.dish,R.drawable.location,R.drawable.icon};
    ListView lst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lst=findViewById(R.id.listview);

        Myadapter adp=new Myadapter(this,titles,images);
        lst.setAdapter(adp);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                }
                if(position==1){
                    startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                }
                if(position==2){
                    startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                }
               /* if(position==3){
                    startActivity(new Intent(getApplicationContext(),Chnbread.class));
                }
                if(position==4){
                    startActivity(new Intent(getApplicationContext(),Amrbread.class));
                }*/

            }
        });
    }


    class Myadapter extends ArrayAdapter<String> {
        Context context;
        String titls[];
        int imgs[];

        Myadapter(Context c,String titl[],int img[]){
            super(c,R.layout.list,R.id.textview1,titl);
            this.context=c;
            this.titls=titl;
            this.imgs=img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getContext().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View list=layoutInflater.inflate(R.layout.list,parent,false);

            ImageView images=list.findViewById(R.id.imageview);
            TextView mytitle=list.findViewById(R.id.textview1);

            images.setImageResource(imgs[position]);
            mytitle.setText(titls[position]);
            return list;
        }
    }

}
