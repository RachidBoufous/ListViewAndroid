package ma.deveek.tp3_3_remake;

import android.app.Application;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;

import java.util.ArrayList;

public class my_app extends Application {

    private ArrayList<Product> p_list;

    public ArrayList<Product> getP_list() {
        return p_list;
    }

    public void onCreate(){
        super.onCreate();
        p_list = init_data();
    }

    public ArrayList<Product> init_data(){
        Resources res = getResources();

        ArrayList<Product> temp_list = new ArrayList<>();

        String[] intitules = res.getStringArray(R.array.intitules);
        String[] prices = res.getStringArray(R.array.price);
        TypedArray img = res.obtainTypedArray(R.array.imgs);

        for(int i = 0;i<intitules.length;i++){
            Product p = new Product(intitules[i],Float.parseFloat(prices[i]),img.getResourceId(i,0));
            temp_list.add(p);
        }
        return temp_list;
    }
}
