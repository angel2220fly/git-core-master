package ie.tudublin;

import processing.core.PApplet;

public class stars {

    PApplet ui;
    float len, lon;

    public stars(PApplet ui, float len, float lon) {

        this.ui = ui;
        this.len = len;
        this.lon = lon;
    }

    public void drawStars() {
        ui.fill(0, 0, 160);
        ui.rect(120, 10, 20, 200);
        ui.fill(128, 0, 0);
        ui.rect(160, 10, 20, 200);
        ui.fill(192, 192, 192);
        ui.rect(200, 10, 20, 200);

        ui.fill(0, 0, 0);
        ui.rect(120, 230, 20, 200);
        ui.fill(255, 0, 0);
        ui.rect(160, 230, 20, 200);
        ui.fill(128, 192, 255);
        ui.rect(200, 230, 20, 200);

        ui.fill(128, 0, 0);
        ui.rect(120, 460, 20, 200);
        ui.fill(255, 255, 255);
        ui.rect(160, 460, 20, 200);
        ui.fill(0, 255, 0);
        ui.rect(200, 460, 20, 200);

        ui.fill(0, 0, 0);
        ui.rect(120, 690, 20, 200);
        ui.fill(255, 255, 255);
        ui.rect(160, 690, 20, 200);
        ui.fill(255, 128, 0);
        ui.rect(200, 690, 20, 200);

    }
}