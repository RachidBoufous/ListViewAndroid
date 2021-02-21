package ma.deveek.tp3_custom_array_adapter;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import ma.deveek.tp3_3_remake.Product;
import ma.deveek.tp3_3_remake.R;

public class ProductView extends RelativeLayout {
    private ImageView ivImage;
    private TextView tvintitule;
    private TextView tvprix;

    public  ProductView(Context context) {
        super(context);
    }

    public static ProductView create(ViewGroup parent){
        LayoutInflater i = LayoutInflater.from(parent.getContext());
        ProductView itemview = (ProductView) i.inflate(R.layout.mylist,parent,false);
        itemview.findViews();
        return  itemview;
    }


    private void findViews(){
        ivImage = (ImageView) findViewById(R.id.item_product_image);
        tvintitule = (TextView) findViewById(R.id.item_product_intitule);
        tvprix = (TextView) findViewById(R.id.item_product_prix);
    }

    public void display(final Product product){
        ivImage.setImageResource(product.getImage());
        tvintitule.setText(product.getIntitule());
        tvprix.setText(product.getPrice() + " USD");
    }

    public ProductView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public ProductView(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
    }
}
