package ma.deveek.tp3_3_remake;

public class Product {

    private String intitule;
    private float price;
    private int image;

    public Product(String _intitule, float _price, int _img){
        this.intitule = _intitule;
        this.price = _price;
        this.image = _img;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getIntitule() {
        return intitule;
    }

    public float getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public String toString(){
        return "title: " + intitule + " price: " + price;
    }
}
