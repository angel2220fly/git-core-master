package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Radar {
    private float radius;
    private PVector pos;
    private float frequency;
    private UI ui;
    private float theta = 0;

    public Radar(UI ui, float frequency, float x, float y, float radius) {
        this.ui = ui;
        this.frequency = frequency;
        pos = new PVector(x, y);
        this.radius = radius;
    }

    public void render() {
        /*
         * ui.pushMatrix(); ui.noFill(); ui.stroke(0, 200, 0); ui.translate(pos.x,
         * pos.y); ui.rotate(theta); ui.ellipse(0, 0, radius * 2, radius * 2);
         * ui.line(0,0,0,-radius); ui.popMatrix();
         */

        ui.noFill();
        ui.ellipse(pos.x, pos.y, radius * 2, radius * 2);
        ui.ellipse(pos.x, pos.y, radius * 3, radius * 3);
        ui.ellipse(pos.x, pos.y, radius * 4, radius * 4);

        ui.fill(255, 224, 124);
        ui.rect(0, 0, 200, 800);
        ui.rect(700, 800, 200, -800);
        ui.rect(0, 0, 800, 100);
        ui.rect(0, 700, 800, 100);

        float x2 = pos.x + (float) Math.sin(theta) * radius * 2;
        float y2 = pos.y - (float) Math.cos(theta) * radius * 2;
        ui.line(pos.x, pos.y, x2, y2);

        // Here I have maked to move ships
        float lenu = ui.random(250, ui.width = 540);
        float lonu = ui.random(250, ui.height = 540);
        ui.fill(255, 0, 255);
        ui.ellipse(lenu, lonu, 50, 50);
        ui.ellipse(lenu, lonu, 50, 50);
        ui.ellipse(lenu, lonu, 50, 50);
        ui.ellipse(lenu, lonu, 50, 50);
        ui.ellipse(lenu, lonu, 50, 50);
        ui.noStroke();

        float lenj = ui.random(250, ui.width = 540);
        float lonj = ui.random(250, ui.height = 540);
        ui.fill(255, 255, 0);
        ui.ellipse(lenj, lonj, 50, 50);
        ui.ellipse(lenj, lonj, 50, 10);
        ui.ellipse(lenj, lonj, 50, 50);
        ui.ellipse(lenj, lonj, 50, 50);
        ui.ellipse(lenj, lonj, 50, 50);
        ui.noStroke();

        float lend = ui.random(250, ui.width = 540);
        float lond = ui.random(250, ui.height = 540);
        ui.fill(123, 123, 212);
        ui.ellipse(lend, lond, 50, 50);
        ui.ellipse(lend, lond, 50, 50);
        ui.ellipse(lend, lond, 50, 50);
        ui.ellipse(lend, lond, 50, 50);
        ui.ellipse(lend, lond, 50, 50);
        ui.noStroke();
    }

    float timeDelta = 1.0f / 60.0f;

    public void update() {
        theta += PApplet.TWO_PI * timeDelta * frequency;
    }

    /**
     * @return the radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the frequency
     */
    public float getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

}