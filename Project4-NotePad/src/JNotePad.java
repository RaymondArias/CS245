import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raria_000
 */
public class JNotePad extends javax.swing.JFrame {
    private File mFile;
    private JFileChooser chooser; 

    /**
     * Creates new form JNotePad
     */
    public JNotePad() {
        initComponents();
        ImageIcon img = new ImageIcon("notepad.png");
        this.setIconImage(img.getImage());
        chooser = new JFileChooser();
    }
    class TxtFileFilter extends FileFilter
    {

        @Override
        public boolean accept(File f) {
            //To change body of generated methods, choose Tools | Templates.
            if(f.getName().endsWith(".txt"))
                return true;
            if(f.isDirectory())
                return true;
            return false;
            
        }

        @Override
        public String getDescription() {
            //To change body of generated methods, choose Tools | Templates.
            return "Text File";
        }
        
    }
    public String getFileName(String temp)
    {
        
        String fileName = "";
        for(int i = 0; i < temp.length(); i++)
        {
            if(temp.charAt(i) == '.')
                break;
            fileName += temp.charAt(i);
        }
        return fileName;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        saveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exit = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        cut = new javax.swing.JMenuItem();
        copy = new javax.swing.JMenuItem();
        paste = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        find = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        selectAll = new javax.swing.JMenuItem();
        timeDate = new javax.swing.JMenuItem();
        format = new javax.swing.JMenu();
        wordWrap = new javax.swing.JMenuItem();
        font = new javax.swing.JMenuItem();
        view = new javax.swing.JMenu();
        statusBar = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        viewHelp = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        about = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Untitled - JNotepad");
        setAutoRequestFocus(false);

        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jTextArea.setRows(5);
        jScrollPane2.setViewportView(jTextArea);

        file.setText("File");
        file.setDisplayedMnemonicIndex(0);

        New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        file.add(New);

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        open.setText("Open...");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        file.add(open);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        file.add(save);

        saveAs.setText("Save As..");
        saveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsActionPerformed(evt);
            }
        });
        file.add(saveAs);
        file.add(jSeparator1);

        jMenuItem1.setText("Page Setup...");
        file.add(jMenuItem1);

        jMenuItem2.setText("Print...");
        file.add(jMenuItem2);
        file.add(jSeparator2);

        exit.setText("Exit");
        exit.setDisplayedMnemonicIndex(1);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        file.add(exit);

        jMenuBar1.add(file);

        edit.setText("Edit");
        edit.setDisplayedMnemonicIndex(0);

        jMenuItem3.setText("Undo");
        edit.add(jMenuItem3);

        cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cut.setText("Cut");
        cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });
        edit.add(cut);

        copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copy.setText("Copy");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
        edit.add(copy);

        paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        paste.setText("Paste");
        paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteActionPerformed(evt);
            }
        });
        edit.add(paste);

        delete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        edit.add(delete);
        edit.add(jSeparator3);

        find.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        find.setText("Find");
        edit.add(find);

        jMenuItem6.setText("Find Next");
        edit.add(jMenuItem6);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Replace...");
        edit.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Go To...");
        edit.add(jMenuItem5);
        edit.add(jSeparator4);

        selectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        selectAll.setText("Select All");
        selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllActionPerformed(evt);
            }
        });
        edit.add(selectAll);

        timeDate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        timeDate.setText("Time/Date");
        edit.add(timeDate);

        jMenuBar1.add(edit);

        format.setText("Format");
        format.setDisplayedMnemonicIndex(1);

        wordWrap.setText("Word Wrap");
        wordWrap.setDisplayedMnemonicIndex(0);
        format.add(wordWrap);

        font.setText("Font");
        font.setDisplayedMnemonicIndex(0);
        format.add(font);

        jMenuBar1.add(format);

        view.setText("View");
        view.setDisplayedMnemonicIndex(0);

        statusBar.setText("Status Bar");
        view.add(statusBar);

        jMenuBar1.add(view);

        help.setText("Help");
        help.setDisplayedMnemonicIndex(0);

        viewHelp.setText("View Help");
        viewHelp.setDisplayedMnemonicIndex(4);
        help.add(viewHelp);
        help.add(jSeparator5);

        about.setText("About JNotepad");
        help.add(about);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        
        chooser.setFileFilter(new TxtFileFilter());
        int result = chooser.showOpenDialog(null);
        String fileText = "";
        mFile = null;
        if (result ==  JFileChooser.APPROVE_OPTION)
            mFile = chooser.getSelectedFile();
        FileReader fileReader;
        
        try {
            fileReader = new FileReader(mFile);
            Scanner input = new Scanner(fileReader);
            while(input.hasNext())
            {
                fileText += input.nextLine();
            }
            fileReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JNotePad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JNotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setTitle(getFileName(mFile.getName()) + " - JNotePad");
        
        jTextArea.setText(fileText);
        
        
    
            
    }//GEN-LAST:event_openActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        
        jTextArea.setText("");
        this.setTitle("Untitled - JNotepad");
        mFile = null;
    }//GEN-LAST:event_NewActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        
        if(mFile == null)
        {
            saveAsActionPerformed(evt);
            //Display save as prompt
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(mFile));
            writer.write(jTextArea.getText());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(JNotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_saveActionPerformed

    private void saveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new TxtFileFilter());
        int result = chooser.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            mFile = chooser.getSelectedFile();
        }
        if(!mFile.exists())
        {
            try {
                mFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(JNotePad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {    
            BufferedWriter writer = new BufferedWriter(new FileWriter(mFile));
            writer.write(jTextArea.getText());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(JNotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(getFileName(mFile.getName()) + " - JNotePad");
        
    }//GEN-LAST:event_saveAsActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutActionPerformed
        
        jTextArea.cut();
    }//GEN-LAST:event_cutActionPerformed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        
        jTextArea.copy();
    }//GEN-LAST:event_copyActionPerformed

    private void pasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteActionPerformed
        
        jTextArea.paste();
        
        
    }//GEN-LAST:event_pasteActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        jTextArea.setText(jTextArea.getText().replace(jTextArea.getSelectedText(), ""));
    }//GEN-LAST:event_deleteActionPerformed

    private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllActionPerformed
        // TODO add your handling code here:
        jTextArea.selectAll();
    }//GEN-LAST:event_selectAllActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JNotePad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem New;
    private javax.swing.JMenu about;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenuItem delete;
    private javax.swing.JMenu edit;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem find;
    private javax.swing.JMenuItem font;
    private javax.swing.JMenu format;
    private javax.swing.JMenu help;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem paste;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem saveAs;
    private javax.swing.JMenuItem selectAll;
    private javax.swing.JMenuItem statusBar;
    private javax.swing.JMenuItem timeDate;
    private javax.swing.JMenu view;
    private javax.swing.JMenuItem viewHelp;
    private javax.swing.JMenuItem wordWrap;
    // End of variables declaration//GEN-END:variables

}