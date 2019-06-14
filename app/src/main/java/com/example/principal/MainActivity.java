package com.example.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<DataInfo> listdata;
    private ImageView bigimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponets();
    }

    private void loadComponets() {
        ListView list= findViewById(R.id.listview);
        bigimg = findViewById(R.id.bigimage);
        //GridView grid = findViewById(R.id.gridview);
        //Spinner spinner = findViewById(R.id.spinner);

        listdata =new ArrayList<>();
        Integer[] images = new Integer[]{R.drawable.auto, R.drawable.celular,R.drawable.images,R.drawable.ventilador,R.drawable.despertador};
        String [] titles = new String[]{"AUTO","CELULAR","BICICLETA","VENTILADOR","DESPERTADOR"};
        String [] descrip = new String[]{"vendo auto costo 25.000$ cantida 5,disponible","vendo celular samsung costo 150bs","vendo bicicleta costo 300bs cantidad 4, disponible","vendo ventilador, costo 200bs, cantidad 5, disponible","vendo despertador, costo 100bs,cantidad 10 , disponible"};
        //ArrayList<DataInfo> listdata =new ArrayList<>();
        for (int i=0; i < images.length; i++){
            DataInfo info =new DataInfo();
            info.setImg(images[i]);
            info.setTitle(titles[i]);
            info.setDescripcion(descrip[i]);
            listdata.add(info);

        }

        /*ArrayList<String> datoslist = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            datoslist.add("Item" +i);

        }*/
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datoslist);

        MyAdapter adapter = new MyAdapter(this, listdata);

        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        //grid.setAdapter(adapter);
        //spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate =this.getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.auto_menu:{
                Toast.makeText(this,"AUTO",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.ventilador_menu:{
                Toast.makeText(this,"VENTILADOR",Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return true;
        //return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     bigimg.setImageResource(listdata.get(position).getImg());
    }
}
