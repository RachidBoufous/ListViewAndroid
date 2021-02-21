package ma.deveek.tp3_3_remake;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static int Edit_Request = 1;
    static ArrayList<Product> products;
    private ArrayAdapter adapter;
    ListView lv;
    Intent sending_in;

    ImageButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Products List");
        setContentView(R.layout.activity_main);
        my_app context = (my_app) getApplicationContext();
        products = context.init_data();

        adapter = new Custom_adapter(this, products);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

        add = (ImageButton) findViewById(R.id.add);
        
        add.setOnClickListener(this);

        //launch act
        // pass data 2 act
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();

                sending_in = new Intent(getApplicationContext(),Edit_activity.class);
                int j = position;
                sending_in.putExtra("idx",j);
                startActivityForResult(sending_in,Edit_Request);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Edit_Request){
            if (resultCode == RESULT_OK){

                    Toast.makeText(this,data.getStringExtra("title") + " has been updated",Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this,"User has cancel the process",Toast.LENGTH_SHORT).show();
            }
            else if(resultCode == 5){

                Toast.makeText(this,data.getStringExtra("deleted") + " has been Deleted",Toast.LENGTH_SHORT).show();
            }
        }
        adapter.notifyDataSetChanged();


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add){
            sending_in = new Intent(getApplicationContext(),Edit_activity.class);
            int j = -1;
            sending_in.putExtra("idx",j);
            startActivityForResult(sending_in,Edit_Request);
        }
    }
}
