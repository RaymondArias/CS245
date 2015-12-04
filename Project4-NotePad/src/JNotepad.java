//Name: Arias, Raymond
//Project:  4
//Due 12/04/15 
//Course:   CS245-01-f15
//Description:
//              A notepad imitation installed on windows

import java.awt.event.ActionEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
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
public class JNotepad extends javax.swing.JFrame {
    private File mFile;
    private JFileChooser chooser;
    private String searchString;
    private LinkedList <Integer> beginList;
    private int lastIndexViewed;
    private boolean radioBtn;
   

    /**
     * Creates new form JNotePad
     */
    public JNotepad() {
        initComponents();
        ImageIcon img = new ImageIcon("JNotepad.png");
        this.setIconImage(img.getImage());
        chooser = new JFileChooser();
        searchString = "";
        beginList = new LinkedList<>();
        lastIndexViewed = 0;
        radioBtn = false;
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
               if (!saveFileBeforeClose(new ActionEvent(evt.getComponent(), evt.getID(), evt.paramString())))
               {
                   return;
                  
               }
                System.exit(0);
            }
        });
        file.setMnemonic('F');
        New.setMnemonic('N');
        exit.setMnemonic('x');
        edit.setMnemonic('E');
        format.setMnemonic('o');
        font.setMnemonic('F');
        help.setMnemonic('H');
        view.setMnemonic('V');
        viewHelp.setMnemonic('H');
 
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
    public boolean saveFileBeforeClose(ActionEvent evt)
    {
        Object[] options = {"Save", "Dont Save", "Cancel"};
        if(mFile == null && jTextArea.getText().length() > 0)
        {
            
            int n =JOptionPane.showOptionDialog(this, "Do you want to save changes to Untitled", "Notepad", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            //int n = JOptionPane.showConfirmDialog(this, "Notepad", "Do you want to save changes to Untitled", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options[0], options[1]);
            if (n == JOptionPane.OK_OPTION)
            {
                saveAsActionPerformed(evt);
            }
            else if(n == JOptionPane.CANCEL_OPTION)
            {
                return false;
            }
        }   
        
        if(mFile != null)
        {
            String textFile = "";
            try {
                BufferedReader bf = new BufferedReader(new FileReader(mFile));
                String tempStr = bf.readLine();
                while(tempStr != null)
                {
                    textFile += tempStr;
                    tempStr = bf.readLine();
                    
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JNotepad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JNotepad.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!textFile.equals(jTextArea.getText()))
            {
                int n = JOptionPane.showOptionDialog(this, "Do you want to save changes to " +mFile.getName(), "Notepad", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(n ==  JOptionPane.OK_OPTION)
                {
                    saveActionPerformed(evt);
                }
                else if (n == JOptionPane.CANCEL_OPTION)
                {
                    return false;
                }
                
            }
        }
        return true;
        
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
    public JTextArea getTextArea()
    {
        return jTextArea;
    }
    public void selectText(LinkedList <Integer> position, String searchString, int index, boolean upDown)
    {
        if(index > position.size() -1 || index < 0)
        {
            return;
        }
        setLastFindOptions(position, searchString, index, upDown);
        int begin = position.get(index);
        int end = begin + searchString.length();
        jTextArea.select(begin, end);
    }
    public void setLastFindOptions(LinkedList <Integer> position, String searchValue, int index, boolean upDown)
    {
        if(!beginList.equals(position))
        {
            beginList = position;
            
        }
        if(!searchString.equals(searchValue))
        {
            searchString = searchValue;
        }
        if(lastIndexViewed != index)
        {
            lastIndexViewed = index;
        }
        if (radioBtn != upDown)
        {
            radioBtn = upDown;
        }
            
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notepadPopup = new javax.swing.JPopupMenu();
        copyPopup = new javax.swing.JMenuItem();
        pastePopup = new javax.swing.JMenuItem();
        deletePopup = new javax.swing.JMenuItem();
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
        findNext = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        selectAll = new javax.swing.JMenuItem();
        timeDate = new javax.swing.JMenuItem();
        format = new javax.swing.JMenu();
        wordWrap = new javax.swing.JCheckBoxMenuItem();
        font = new javax.swing.JMenuItem();
        view = new javax.swing.JMenu();
        statusBar = new javax.swing.JCheckBoxMenuItem();
        help = new javax.swing.JMenu();
        viewHelp = new javax.swing.JMenuItem();
        sep = new javax.swing.JPopupMenu.Separator();
        about = new javax.swing.JMenuItem();

        notepadPopup.setComponentPopupMenu(notepadPopup);
        notepadPopup.setName(""); // NOI18N

        copyPopup.setText("Copy");
        copyPopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyPopupActionPerformed(evt);
            }
        });
        notepadPopup.add(copyPopup);

        pastePopup.setText("Paste");
        pastePopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastePopupActionPerformed(evt);
            }
        });
        notepadPopup.add(pastePopup);

        deletePopup.setText("Delete");
        deletePopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePopupActionPerformed(evt);
            }
        });
        notepadPopup.add(deletePopup);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Untitled - JNotepad");
        setAutoRequestFocus(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jTextArea.setRows(5);
        jTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextAreaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextAreaMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea);

        file.setText("File");

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
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        file.add(exit);

        jMenuBar1.add(file);

        edit.setText("Edit");

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
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });
        edit.add(find);

        findNext.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        findNext.setText("Find Next");
        findNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findNextActionPerformed(evt);
            }
        });
        edit.add(findNext);

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
        timeDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeDateActionPerformed(evt);
            }
        });
        edit.add(timeDate);

        jMenuBar1.add(edit);

        format.setText("Format");

        wordWrap.setText("Word Wrap");
        wordWrap.setToolTipText("");
        wordWrap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordWrapActionPerformed(evt);
            }
        });
        format.add(wordWrap);

        font.setText("Font...");
        font.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontActionPerformed(evt);
            }
        });
        format.add(font);

        jMenuBar1.add(format);

        view.setText("View");

        statusBar.setText("Status Bar");
        statusBar.setToolTipText("");
        view.add(statusBar);

        jMenuBar1.add(view);

        help.setText("Help");

        viewHelp.setText("View Help");
        help.add(viewHelp);
        help.add(sep);

        about.setText("About JNotepad");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
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
        if(!saveFileBeforeClose(evt))
        {
            return;
        }
        
        chooser.setFileFilter(new TxtFileFilter());
        int result = chooser.showOpenDialog(null);
        String fileText = "";
        mFile = null;
        if (result ==  JFileChooser.APPROVE_OPTION)
            mFile = chooser.getSelectedFile();
        if (mFile == null)
        {
            return;
        }
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
            Logger.getLogger(JNotepad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JNotepad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setTitle(getFileName(mFile.getName()) + " - JNotePad");
        
        jTextArea.setText(fileText);
        
        
    
            
    }//GEN-LAST:event_openActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        
        if(!saveFileBeforeClose(evt))
        {
            return;
        }
        jTextArea.setText("");
        this.setTitle("Untitled - JNotepad");
        mFile = null;
    }//GEN-LAST:event_NewActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        
        if(jTextArea.getText().length() == 0)
        {
            return;
        }
        if(mFile == null)
        {
            
            saveAsActionPerformed(evt);
            //Display save as prompt
            if(mFile == null)
                return;
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(mFile));
            writer.write(jTextArea.getText());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(JNotepad.class.getName()).log(Level.SEVERE, null, ex);
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
        if(mFile == null)
            return;
        if(!mFile.exists())
        {
            try {
                mFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(JNotepad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {    
            BufferedWriter writer = new BufferedWriter(new FileWriter(mFile));
            writer.write(jTextArea.getText());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(JNotepad.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(getFileName(mFile.getName()) + " - JNotePad");
        
    }//GEN-LAST:event_saveAsActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        
        if(!saveFileBeforeClose(evt))
            return;
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
        
        jTextArea.setText(jTextArea.getText().replace(jTextArea.getSelectedText(), ""));
    }//GEN-LAST:event_deleteActionPerformed

    private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllActionPerformed
        
        jTextArea.selectAll();
    }//GEN-LAST:event_selectAllActionPerformed

    private void timeDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeDateActionPerformed
       DateFormat df = new SimpleDateFormat("hh:mm a MM/dd/yy");
       Date date = new Date();
       jTextArea.setText(jTextArea.getText() + df.format(date));
       
        
    }//GEN-LAST:event_timeDateActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        
        Find findDialog = new Find(this, false, this);
        findDialog.setVisible(true);
        
        
        
    }//GEN-LAST:event_findActionPerformed

    private void findNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findNextActionPerformed
        
        if(radioBtn)
        {
            if(lastIndexViewed + 1 > beginList.size() - 1)
            {
                JOptionPane.showMessageDialog(this, "Cannot find: '" + searchString+ "'");
                return;
            }
            lastIndexViewed++;
            int begin = beginList.get(lastIndexViewed);
            jTextArea.select(begin, begin + searchString.length());
                        
        }
        else
        {
            if(lastIndexViewed - 1 < 0)
            {
                JOptionPane.showMessageDialog(this, "Cannot find: '" + searchString+ "'");
                return;
            }
            lastIndexViewed--;
            int begin = beginList.get(lastIndexViewed);
            jTextArea.select(begin, begin + searchString.length());
        }
            
    }//GEN-LAST:event_findNextActionPerformed

    private void wordWrapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordWrapActionPerformed
        
        if (wordWrap.isSelected())
        {
            jTextArea.setLineWrap(true);
        }
        else
        {
            jTextArea.setLineWrap(false);
        }
    }//GEN-LAST:event_wordWrapActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        
        About abt = new About(this, true);
        abt.setVisible(true);
    }//GEN-LAST:event_aboutActionPerformed

    private void fontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontActionPerformed
        
        JFontChooser fontChooser = new JFontChooser(this, true, this);
        fontChooser.setVisible(true);
    }//GEN-LAST:event_fontActionPerformed

    private void copyPopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyPopupActionPerformed
        
        jTextArea.copy();
    }//GEN-LAST:event_copyPopupActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
        if(evt.isPopupTrigger())
        {
            notepadPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        
         if(evt.isPopupTrigger())
        {
            notepadPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_formMouseReleased

    private void jTextAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaMousePressed
        
        if(evt.isPopupTrigger())
        {
            notepadPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTextAreaMousePressed

    private void jTextAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaMouseReleased
        
        if(evt.isPopupTrigger())
        {
            notepadPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTextAreaMouseReleased

    private void pastePopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastePopupActionPerformed
        
        jTextArea.paste();
    }//GEN-LAST:event_pastePopupActionPerformed

    private void deletePopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePopupActionPerformed
        
        jTextArea.setText(jTextArea.getText().replace(jTextArea.getSelectedText(), ""));
    }//GEN-LAST:event_deletePopupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JNotepad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem copyPopup;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenuItem delete;
    private javax.swing.JMenuItem deletePopup;
    private javax.swing.JMenu edit;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem find;
    private javax.swing.JMenuItem findNext;
    private javax.swing.JMenuItem font;
    private javax.swing.JMenu format;
    private javax.swing.JMenu help;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JPopupMenu notepadPopup;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem paste;
    private javax.swing.JMenuItem pastePopup;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem saveAs;
    private javax.swing.JMenuItem selectAll;
    private javax.swing.JPopupMenu.Separator sep;
    private javax.swing.JCheckBoxMenuItem statusBar;
    private javax.swing.JMenuItem timeDate;
    private javax.swing.JMenu view;
    private javax.swing.JMenuItem viewHelp;
    private javax.swing.JCheckBoxMenuItem wordWrap;
    // End of variables declaration//GEN-END:variables

}
