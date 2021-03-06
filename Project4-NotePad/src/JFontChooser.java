
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raria_000
 */
public class JFontChooser extends javax.swing.JDialog {

    /**
     * Creates new form JFontChooser
     */
    private String []fonts;
    private final String[] style = {"Plain", "Bold", "Italics"};
    private final int[] styleNum = {Font.PLAIN, Font.BOLD, Font.ITALIC};
    private JNotepad parentFrame;
   
    public JFontChooser(java.awt.Frame parent, boolean modal, JNotepad parentFrame) {
        super(parent, modal);
        this.parentFrame = parentFrame;
        initComponents();
        fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        DefaultListModel<String> fontName = new DefaultListModel();
        DefaultListModel<String> styleList = new DefaultListModel();
        DefaultListModel<Integer> size = new DefaultListModel();
        for(int i = 0; i < fonts.length; i++)
        {
            fontName.addElement(fonts[i]);
        }
        for(int i = 0; i < style.length; i++)
        {
            styleList.addElement(style[i]);
        }
        for(int i = 8; i < 73; i += 2)
        {
            size.addElement(i);
        }
        
        fontList.setModel(fontName);
        lookList.setModel(styleList);
        sizeList.setModel(size);
        
        fontList.setSelectedIndex(0);
        lookList.setSelectedIndex(0);
        sizeList.setSelectedIndex(0);
        sampleLabel.setFont(getFontData());
        
        
        
      
        
    }
    public Font getFontData()
    {
        if (fontList.getSelectedValue() == null || lookList.getSelectedValue() == null|| sizeList.getSelectedValue() == null)
        {
            fontText.setText(fonts[0]);
            fontStyleTf.setText(style[0]);
            sizeTF.setText("12");
            
            return new Font(fonts[0], Font.PLAIN, 12);
        }
        String fontName = (String)fontList.getSelectedValue();
        String fontStyle = (String)lookList.getSelectedValue();
        int fontValue = Font.PLAIN;
        int fontSize = (int)sizeList.getSelectedValue();
        if(fontStyle.equals(style[0]))
        {
            fontValue = Font.PLAIN;
        }
        else if(fontStyle.equals(style[1]))
        {
            fontValue = Font.BOLD;
        }
        else if(fontStyle.equals(style[2]))
        {
            fontValue = Font.ITALIC;
        }
        fontText.setText(fontName);
        fontStyleTf.setText(fontStyle);
        sizeTF.setText(""+fontSize);
        return new Font(fontName, fontValue, fontSize);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fontText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fontList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lookList = new javax.swing.JList();
        fontStyleTf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sizeTF = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        sizeList = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        sampleLabel = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        cancel = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Font");

        fontText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fontTextFocusGained(evt);
            }
        });
        fontText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontTextActionPerformed(evt);
            }
        });

        jLabel1.setText("Font:");

        fontList.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                fontListCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        fontList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                fontListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(fontList);

        lookList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lookListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lookList);

        fontStyleTf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                fontStyleTfCaretUpdate(evt);
            }
        });
        fontStyleTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontStyleTfActionPerformed(evt);
            }
        });

        jLabel2.setText("Font Style:");

        jLabel3.setText("Size:");

        sizeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeTFActionPerformed(evt);
            }
        });

        sizeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                sizeListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(sizeList);

        jLabel4.setText("Sample:");

        sampleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sampleLabel.setText("AaBbCcDdEe");

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fontText)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sampleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(84, 84, 84)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(fontStyleTf, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sizeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sizeTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fontText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fontStyleTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sampleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok)
                    .addComponent(cancel))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fontTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontTextActionPerformed
        
        String searchString = fontText.getText();
        ListModel tempList = fontList.getModel();
        int index = 0;
        
        for(int i = 0; i < tempList.getSize(); i++)
        {
            String font = (String)tempList.getElementAt(i);
            
            if(font.toUpperCase().startsWith(searchString.toUpperCase()))
            {
                index = i;
                break;
            }
        }
        fontList.setSelectedIndex(index);
       
    }//GEN-LAST:event_fontTextActionPerformed

    private void fontListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_fontListValueChanged
        sampleLabel.setFont(getFontData());
    }//GEN-LAST:event_fontListValueChanged

    private void lookListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lookListValueChanged
        
        sampleLabel.setFont(getFontData());
        
    }//GEN-LAST:event_lookListValueChanged

    private void sizeListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_sizeListValueChanged
        
        sampleLabel.setFont(getFontData());
    }//GEN-LAST:event_sizeListValueChanged

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        
        parentFrame.getTextArea().setFont(sampleLabel.getFont());
        this.setVisible(false);
    }//GEN-LAST:event_okActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void fontTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fontTextFocusGained
        
        //fontText.setText("");
    }//GEN-LAST:event_fontTextFocusGained

    private void fontListCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_fontListCaretPositionChanged
       
        
    }//GEN-LAST:event_fontListCaretPositionChanged

    private void fontStyleTfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fontStyleTfCaretUpdate
        
        
    }//GEN-LAST:event_fontStyleTfCaretUpdate

    private void fontStyleTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontStyleTfActionPerformed
        
         
        String searchString = fontStyleTf.getText();
        ListModel tempList = lookList.getModel();
        int index = 0;
        
        for(int i = 0; i < tempList.getSize(); i++)
        {
            String font = (String)tempList.getElementAt(i);
            
            if(font.toUpperCase().startsWith(searchString.toUpperCase()))
            {
                index = i;
                break;
            }
        }
        lookList.setSelectedIndex(index);
    }//GEN-LAST:event_fontStyleTfActionPerformed

    private void sizeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeTFActionPerformed
        
         
        String searchString = sizeTF.getText();
        ListModel tempList = sizeList.getModel();
        int index = 0;
        
        for(int i = 0; i < tempList.getSize(); i++)
        {
            int font = (int)tempList.getElementAt(i);
            
            if(font == Integer.parseInt(searchString))
            {
                index = i;
                break;
            }
        }
        sizeList.setSelectedIndex(index);
    }//GEN-LAST:event_sizeTFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFontChooser dialog = new JFontChooser(new javax.swing.JFrame(), true, new JNotepad());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton cancel;
    private javax.swing.JList fontList;
    private javax.swing.JTextField fontStyleTf;
    private javax.swing.JTextField fontText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList lookList;
    private javax.swing.JButton ok;
    private javax.swing.JLabel sampleLabel;
    private javax.swing.JList sizeList;
    private javax.swing.JTextField sizeTF;
    // End of variables declaration//GEN-END:variables
}
