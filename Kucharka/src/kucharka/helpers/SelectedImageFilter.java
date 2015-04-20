package kucharka.helpers;
import java.awt.image.RGBImageFilter;

public class SelectedImageFilter extends RGBImageFilter {
    private final float[] filter;
    public SelectedImageFilter(float[] filter) {
        this.filter = filter;
        canFilterIndexColorModel = true;
    }
    @Override public int filterRGB(int x, int y, int argb) {
        int r = (int)(((argb >> 16) & 0xff) * filter[0]);
        int g = (int)(((argb >>  8) & 0xff) * filter[1]);
        int b = (int)(((argb      ) & 0xff) * filter[2]);
        return (argb & 0xff000000) | (r<<16) | (g<<8) | (b);
    }
}