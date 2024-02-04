package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;

public class UI extends PApplet {

    ArrayList<Product> products = new ArrayList<Product>();

    MovingCircle mc;
    stars star;

    boolean[] keys = new boolean[1024];

    public void keyPressed() {
        keys[keyCode] = true;
    }

    public void keyReleased() {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c) {
        return keys[c] || keys[Character.toUpperCase(c)];
    }

    public void separate(int value) {
        int hundreds = (value / 100);
        int tens = (value - (hundreds * 100)) / 10;
        int ones = value - ((hundreds * 100) + (tens * 10));
        print(hundreds + ",");
        print(tens + ",");
        println(ones);
    }

    public void settings() {
        size(500, 1000);

        size(500, 1000);

        separate(381);
        separate(1);
        separate(92);
    }

    public void setup() {

        mc = new MovingCircle(this, width / 2, height * .75f, 50);
        radar = new Radar(this, 1, width / 2, height / 2, 100);
        star = new stars(this, 0, 0);

    }

    Radar radar;

    void loadProducts() {
        Table table = loadTable("fly.csv", "header");
        for (TableRow tr : table.rows()) {
            Product p = new Product(tr);
            products.add(p);
        }
    }

    public void mouseClicked() {
        int which = -1;

        // The best way!!
        if ((mouseX > border && mouseX < border + buttonWidth)) {
            if ((mouseY - border) % (buttonHeight + gap) < buttonHeight) {
                which = (int) ((mouseY - border) / (buttonHeight + gap));
            }
        }

        // This also works
        /*
         * if (mouseX > border && mouseX < border + buttonWidth) { for(int i = 0 ; i <
         * products.size() ; i ++) { float y = border + (i * (buttonHeight + gap)); if
         * (mouseY > y && mouseY < y + buttonHeight) { which = i; break; } } }
         */
        if (which != -1) {
            System.out.println(products.get(which));
        }
    }

    float border = 20;
    float buttonWidth = 200;
    float buttonHeight = 50;
    float gap = 20;

    void drawProductButtons() {

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            float y = border + (i * (buttonHeight + gap));
            float x = border;
            fill(255, 255, 0);
            stroke(0);
            rect(x, y, buttonWidth, buttonHeight);
            textAlign(CENTER, CENTER);
            fill(0);
            text(p.getName(), x + buttonWidth * 0.5f, y + buttonHeight * 0.5f);
        }
    }

    AudioInput ai;
    FFT fft;
    Minim minim;
    public static final int FRAME_SIZE = 1024;
    public static final int SAMPLE_RATE = 44100;
    public static final int BITS_PER_SAMPLE = 16;

    public void draw() {

        star.drawStars();

    }

}
