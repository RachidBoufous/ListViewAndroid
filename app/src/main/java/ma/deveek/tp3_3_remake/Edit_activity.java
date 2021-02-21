package ma.deveek.tp3_3_remake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Edit_activity extends AppCompatActivity implements View.OnClickListener {

    ImageView imv;
    EditText edt1,edt2;
    ImageButton savebtn,cancelbtn;
    ImageButton delete;
    String position;
    Intent in;

    ArrayList<Product> p_l = MainActivity.products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_activity);
        in = getIntent();

        if (in.getIntExtra("idx",-1)>=0){
            setTitle("Modify a product");
            findView();
            load_data();
        }
        else {
            setTitle("adding a product");
            findView();
            delete.setVisibility(View.GONE);

        }


    }

    public void findView(){
        imv = (ImageView) findViewById(R.id.img_id);
        edt1 = (EditText) findViewById(R.id.product_title);
        edt2 = (EditText) findViewById(R.id.product_price);
        savebtn = (ImageButton) findViewById(R.id.save_btn);
        cancelbtn = (ImageButton) findViewById(R.id.cancel_btn);
        delete = (ImageButton) findViewById(R.id.delete);
        delete.setOnClickListener(this);
        savebtn.setOnClickListener(this);
        cancelbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.save_btn){
            in = getIntent();
            if (in.getIntExtra("idx",-1)>=0)
            {
                Product po = p_l.get(in.getIntExtra("idx",-1));

                po.setIntitule(edt1.getText().toString());
                po.setPrice(Float.parseFloat(edt2.getText().toString()));

                Intent in2 = new Intent(this,MainActivity.class);
                in2.putExtra("title",p_l.get(in.getIntExtra("idx",-1)).getIntitule());
                setResult(RESULT_OK,in2);
                finish();
            }
            else{
                String _title = edt1.getText().toString();
                Float _price = Float.parseFloat(edt2.getText().toString());
                Product new_p = new Product(_title,_price,R.drawable.nf);
                p_l.add(new_p);
                Intent in2 = new Intent(this,MainActivity.class);
                setResult(RESULT_OK,in2);
                finish();
            }

        }
        else if (v.getId() == R.id.cancel_btn){

            setResult(RESULT_CANCELED);
            finish();
        }
        else if(v.getId() == R.id.delete){
            in = getIntent();
            Intent in2 = new Intent(this,MainActivity.class);
            in2.putExtra("deleted",p_l.get(in.getIntExtra("idx",-1)).getIntitule());
            p_l.remove(in.getIntExtra("idx",-1));
            setResult(5,in2);
            finish();
        }
    }

    public void load_data(){
        in = getIntent();
        int pos = in.getIntExtra("idx",-1);
        imv.setImageResource(p_l.get(pos).getImage());
        edt1.setText(p_l.get(pos).getIntitule());
        edt2.setText(String.valueOf(p_l.get(pos).getPrice()));
    }
}