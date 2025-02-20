package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.videopanel;

public class UI {
    videopanel vp;
    public int hCounter=0;
    public int SMhCounter =0;
    public int vCounter=0;
    public boolean pause = false;
    public boolean SMcursor = false;
    public UI(videopanel vp){
        this.vp = vp;
    }

    public void draw(Graphics2D g2){
        int x = 200;
        int y = 100;
        g2.setColor(Color.decode("#4444f9"));
        g2.fillRect(0, 0, vp.ScreenWidth, vp.ScreenHeight);

        //title
        int marginTitleX = 125;
        int marginTitleY = 75;
        g2.setColor(Color.decode("#131357"));
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,72));
        String text ="FLUID SIMULATION";
        g2.drawString(text, x+marginTitleX, y+marginTitleY);

        int increment = 40;
        //content
        y+=220;
        g2.setFont(g2.getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT,18));
        text = "GRAVITY";
        g2.drawString(text, x, y);
        y+=increment;
        text = "REPULSIVE FORCE";
        g2.drawString(text, x, y);
        y+=increment;
        text = "ELASETISITY";
        g2.drawString(text, x, y);
        y+=increment;
        text = "PARTICLE";
        g2.drawString(text, x, y);
        y+=increment;
        text = "CONTAINER";
        g2.drawString(text, x, y);


        int helper = y;
        //start
        int startX = x+400;
        int startY= helper+100;
        g2.setFont(g2.getFont().deriveFont(Font.ROMAN_BASELINE,32));
        if(pause){
            text="RESUME";
        }else{
            text = "START"; 
        }
        g2.drawString(text, startX, startY);
        
        //main menu cursor
        String cursor= ">";
        if(!SMcursor){
            int marginStartX = 30;
            int marginStartY = 0; 
            g2.setFont(g2.getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT,18));
            y=320;
            x-=20;
            if(hCounter==5){
                g2.setFont(g2.getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT,32));
                g2.drawString(cursor, startX-marginStartX, startY-marginStartY);
            }else{
                g2.drawString(cursor, x, y+hCounter*increment);
            }
        }

        //sidemenu
        g2.setColor(Color.decode("#3333cc"));
        int sideM_X = 700;
        int sideM_Y = 300;
        int sideM_width = 400;
        int sideM_height = 200;
        g2.fillRect(sideM_X, sideM_Y, sideM_width, sideM_height);
            //border
        g2.setColor(Color.decode("#c9c9ff"));
        g2.drawRect(sideM_X, sideM_Y, sideM_width, sideM_height);
            //side menu content
        g2.setFont(g2.getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT,15));
        g2.setColor(Color.WHITE);
        int SMincrement =40;
        x = sideM_X+SMincrement;
        y = sideM_Y+SMincrement;
        String SMtext="";
        switch (hCounter) {
            case 0:
                SMtext="GRAVITY CONSTANT";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="GRAVITY RANGE";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="EARTH GRAVITY";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                break;
            case 1:
                SMtext="REPULSIVE CONSTANT";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="REPULSIVE FORCE RANGE";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                break;
            case 3:
                SMtext="DIAMETER";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="SPEED IN X";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="SPEED IN Y";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="MASS";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                break;
            case 4:
                SMtext="NUMBER OF PARTICLE";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="DISTANCE B/W PARTICLE";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="CONTAINER HEIGHT";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="CONTAINER WIDTH";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                break;
        }

        //SMcursor
        int sideMmargin_X = 20;
        int sideMmargin_Y = 0;
        if(SMcursor){
            switch (hCounter) {
                case 0:
                    g2.drawString(cursor, x, y+SMhCounter*increment);
                    break;
            }
        }
    }
}
