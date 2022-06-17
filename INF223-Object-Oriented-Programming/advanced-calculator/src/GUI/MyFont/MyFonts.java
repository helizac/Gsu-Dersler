package GUI.MyFont;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class MyFonts {

    public Font arial, calibri, consolas, google_sans, times_new_roman;

    {
        try {
            arial = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Fonts/Arial.ttf"))).deriveFont(20F);
        }
        catch (FontFormatException | IOException e){
            e.printStackTrace();
        }
        try {
            calibri = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Fonts/Calibri.ttf"))).deriveFont(20F);
        }
        catch (FontFormatException | IOException e){
            e.printStackTrace();
        }
        try {
            consolas = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Fonts/Consolas.ttf"))).deriveFont(20F);
        }
        catch (FontFormatException | IOException e){
            e.printStackTrace();
        }
        try {
            google_sans = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Fonts/Google Sans.ttf"))).deriveFont(20F);
        }
        catch (FontFormatException | IOException e){
            e.printStackTrace();
        }
        try {
            times_new_roman = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Fonts/Times New Roman.ttf"))).deriveFont(20F);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}