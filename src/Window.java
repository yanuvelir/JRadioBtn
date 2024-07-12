import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame{

    private JTextField txtText;
    private Font fntPlain, fntBold, fntItalic, fntBoldItalic;
    private JRadioButton rdbPlain, rdbBold, rdbItalic, rdbBoldItalic;
    private ButtonGroup btnGrpFonts;

    public Window(String header){
        super(header);
        this.setLayout(new FlowLayout());
        txtText = new JTextField("To change the font - please select radio button", 30);
        this.add(txtText);

        fntPlain = new Font("TimesRoman", Font.PLAIN, 14);
        fntBold = new Font("TimesRoman", Font.BOLD, 14);
        fntItalic = new Font("TimesRoman", Font.ITALIC, 14);
        fntBoldItalic = new Font("TimesRoman", Font.BOLD + Font.ITALIC, 14);

        rdbPlain = new JRadioButton("Regular", true);
        add(rdbPlain);
        rdbBold = new JRadioButton("Bold", false);
        add(rdbBold);
        rdbItalic = new JRadioButton("Italic", false);
        add(rdbItalic);
        rdbBoldItalic = new JRadioButton("BoldItalic");
        add(rdbBoldItalic);

        btnGrpFonts = new ButtonGroup();
        btnGrpFonts.add(rdbPlain);
        btnGrpFonts.add(rdbBold);
        btnGrpFonts.add(rdbItalic);
        btnGrpFonts.add(rdbBoldItalic);

        rdbPlain.addItemListener(new RdbEventHandlerClass(fntPlain));
        rdbBold.addItemListener(new RdbEventHandlerClass(fntBold));
        rdbItalic.addItemListener(new RdbEventHandlerClass(fntItalic));
        rdbBoldItalic.addItemListener(new RdbEventHandlerClass(fntBoldItalic));
    }

    private class RdbEventHandlerClass implements ItemListener {
        private Font fnt;
        public RdbEventHandlerClass(Font f){
            fnt = f;
        }
        public void itemStateChanged(ItemEvent e){
            txtText.setFont(fnt);
        }

    }

}

