/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import Bean.cliente;
import javax.swing.DefaultListModel;


    public class ClienteListModel extends DefaultListModel<cliente> {
    @Override
    public void fireContentsChanged(Object source, int index0, int index1) {
        super.fireContentsChanged(source, index0, index1);
    }
}

