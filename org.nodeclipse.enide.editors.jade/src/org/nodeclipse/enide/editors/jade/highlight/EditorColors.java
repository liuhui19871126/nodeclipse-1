package org.nodeclipse.enide.editors.jade.highlight;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.nodeclipse.enide.editors.jade.Activator;

/**
 * Converts RGB to Color, reuses the existing Color instances. A singleton.
 */
public class EditorColors {

    private static final Map<Integer, Color> intToColor = new HashMap<Integer, Color>();

    public static Color getColor(RGB rgb) {
        Integer colorInt = rgbToInteger(rgb);
        Color color = intToColor.get(colorInt);
        if (color == null) {
            color = new Color(Display.getDefault(), rgb);
            intToColor.put(colorInt, color);
        }
        return color;
    }

    public static Color getColor(String preference) {
    	return getColor(PreferenceConverter.getColor(Activator.getDefault().getPreferenceStore(), preference));
    }
    
    private static Integer rgbToInteger(RGB rgb) {
        return ((rgb.red & 0xFF) << 16) + ((rgb.green & 0xFF) << 8) + (rgb.blue & 0xFF);
    }
}
