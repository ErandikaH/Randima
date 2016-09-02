/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supplierInvoice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class ComboUtil {
    
    private ArrayList<String> ar = new ArrayList<String>();
    JTextField txt;

    public void setSearchableCombo(final JComboBox cmb, boolean mustSort, final String noReultsText) {
        ar = new ArrayList<String>();
        final int s = cmb.getItemCount();
        for (int i = 0; i < s; i++) {
            boolean exists = false;
            for (int j = 0; j < ar.size(); j++) {
                if (ar.get(j).equalsIgnoreCase(cmb.getItemAt(i) + "")) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                ar.add(cmb.getItemAt(i) + "");
            }
        }
        if (mustSort) {
            Collections.sort(ar);
        }

        txt = (JTextField) cmb.getEditor().getEditorComponent();
        removeKeyListeners(txt);
        txt.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent evt) {
                int key = evt.getKeyCode();
                if (!(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_ENTER || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP)) {
                    String s = txt.getText();
                    int caret = txt.getCaretPosition();                
                    cmb.hidePopup();
                    cmb.removeAllItems();
                    
                    for (int i = 0; i < ar.size(); i++) {
                        if (ar.get(i).toUpperCase().startsWith(s.substring(0, caret).toUpperCase())) {
                            cmb.addItem(ar.get(i));
                        }
                    }
                    cmb.showPopup();
                    if (cmb.getItemCount() == 0) {
                        cmb.addItem(noReultsText);
                    }
                    txt.setText(s);
                    txt.setCaretPosition(caret);
                } else if (key == KeyEvent.VK_ESCAPE) {
                    cmb.setSelectedItem(txt.getText());
                    cmb.hidePopup();
                } else if (key == KeyEvent.VK_ENTER && cmb.getSelectedIndex()==-1) {
                    if(cmb.getItemCount()==1 && !cmb.getItemAt(0).equals(noReultsText)){
                        cmb.setSelectedIndex(0) ;
                    }else if(cmb.getItemCount()>1){
                        cmb.setSelectedIndex(0) ;
                    }
                }
            }
        });
    }

    private void removeKeyListeners(JTextField txt){
        try {
            KeyListener[] listeners = txt.getKeyListeners();
            for(KeyListener kl : listeners){
                txt.removeKeyListener(kl);
            }
        } catch (Exception e) {
        }
    }
    
    private ArrayList<String> arName = new ArrayList<String>();
    JTextField txtName;

    public void setSearchableComboName(final JComboBox cmb, boolean mustSort, final String noReultsText) {
        arName = new ArrayList<String>();
        final int s = cmb.getItemCount();
        for (int i = 0; i < s; i++) {
            boolean exists = false;
            for (int j = 0; j < arName.size(); j++) {
                if (arName.get(j).equalsIgnoreCase(cmb.getItemAt(i) + "")) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                arName.add(cmb.getItemAt(i) + "");
            }
        }
        if (mustSort) {
            Collections.sort(arName);
        }

        txtName = (JTextField) cmb.getEditor().getEditorComponent();
        removeKeyListenersName(txtName);
        txtName.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent evt) {
                int key = evt.getKeyCode();
                if (!(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_ENTER || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP)) {
                    String s = txtName.getText();
                    int caret = txtName.getCaretPosition();                
                    cmb.hidePopup();
                    cmb.removeAllItems();
                    
                    for (int i = 0; i < arName.size(); i++) {
                        if (arName.get(i).toUpperCase().startsWith(s.substring(0, caret).toUpperCase())) {
                            cmb.addItem(arName.get(i));
                        }
                    }
                    cmb.showPopup();
                    if (cmb.getItemCount() == 0) {
                        cmb.addItem(noReultsText);
                    }
                    txtName.setText(s);
                    txtName.setCaretPosition(caret);
                } else if (key == KeyEvent.VK_ESCAPE) {
                    cmb.setSelectedItem(txtName.getText());
                    cmb.hidePopup();
                } else if (key == KeyEvent.VK_ENTER && cmb.getSelectedIndex()==-1) {
                    if(cmb.getItemCount()==1 && !cmb.getItemAt(0).equals(noReultsText)){
                        cmb.setSelectedIndex(0) ;
                    }else if(cmb.getItemCount()>1){
                        cmb.setSelectedIndex(0) ;
                    }
                }
            }
        });
    }

    private void removeKeyListenersName(JTextField txt){
        try {
            KeyListener[] listeners = txt.getKeyListeners();
            for(KeyListener kl : listeners){
                txt.removeKeyListener(kl);
            }
        } catch (Exception e) {
        }
    }

    private ArrayList<String> arItem = new ArrayList<String>();
    JTextField txtItem;

    public void setSearchableComboItem(final JComboBox cmb, boolean mustSort, final String noReultsText) {
        arItem = new ArrayList<String>();
        final int s = cmb.getItemCount();
        for (int i = 0; i < s; i++) {
            boolean exists = false;
            for (int j = 0; j < arItem.size(); j++) {
                if (arItem.get(j).equalsIgnoreCase(cmb.getItemAt(i) + "")) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                arItem.add(cmb.getItemAt(i) + "");
            }
        }
        if (mustSort) {
            Collections.sort(arItem);
        }

        txtItem = (JTextField) cmb.getEditor().getEditorComponent();
        removeKeyListenersItem(txtItem);
        txtItem.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent evt) {
                int key = evt.getKeyCode();
                if (!(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_ENTER || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP)) {
                    String s = txtItem.getText();
                    int caret = txtItem.getCaretPosition();                
                    cmb.hidePopup();
                    cmb.removeAllItems();
                    
                    for (int i = 0; i < arItem.size(); i++) {
                        if (arItem.get(i).toUpperCase().startsWith(s.substring(0, caret).toUpperCase())) {
                            cmb.addItem(arItem.get(i));
                        }
                    }
                    cmb.showPopup();
                    if (cmb.getItemCount() == 0) {
                        cmb.addItem(noReultsText);
                    }
                    txtItem.setText(s);
                    txtItem.setCaretPosition(caret);
                } else if (key == KeyEvent.VK_ESCAPE) {
                    cmb.setSelectedItem(txtItem.getText());
                    cmb.hidePopup();
                } else if (key == KeyEvent.VK_ENTER && cmb.getSelectedIndex()==-1) {
                    if(cmb.getItemCount()==1 && !cmb.getItemAt(0).equals(noReultsText)){
                        cmb.setSelectedIndex(0) ;
                    }else if(cmb.getItemCount()>1){
                        cmb.setSelectedIndex(0) ;
                    }
                }
            }
        });
    }

    private void removeKeyListenersItem(JTextField txt){
        try {
            KeyListener[] listeners = txt.getKeyListeners();
            for(KeyListener kl : listeners){
                txt.removeKeyListener(kl);
            }
        } catch (Exception e) {
        }
    }
}
