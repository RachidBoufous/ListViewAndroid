package ma.deveek.tp3_3_remake;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

import ma.deveek.tp3_custom_array_adapter.ProductView;

public class Custom_adapter extends ArrayAdapter<Product> {

    public Custom_adapter(Context ctx, List<Product> products){
        super(ctx, 0, products);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ProductView productView = (ProductView) convertView;

        if (productView == null) {
            productView = productView.create(parent);
        }
        productView.display(super.getItem(position));
        return productView;
    }
}
