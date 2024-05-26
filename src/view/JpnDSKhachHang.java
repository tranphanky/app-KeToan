/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.util.ArrayList;
import model.KhachHang;
import dao.KhachHangDAO;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author PC
 */
public class JpnDSKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form JpnPhieuThuChiTM
     */
    public JpnDSKhachHang() {
        initComponents();

        loadTable();
        
        

        tbDSKH.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Kiểm tra để không gọi sự kiện hai lần
               
                if (!event.getValueIsAdjusting()) {
                    // Kiểm tra có dòng nào được chọn chưa
                    if (tbDSKH.getSelectedRow() != -1) {
                        // Đổi dữ liệu từ dòng được chọn và đưa lên các textfield
                        txtTenKH.setText(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 1).toString());
                        txtDiaChi.setText(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 2).toString());
                        txtMST.setText(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 3).toString());
                        txtMaKH.setText(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 4).toString());
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMST = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDSKH = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnthemKH = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jPanel10.setBackground(new java.awt.Color(153, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DANH SÁCH KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tên khách hàng");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Địa chỉ");

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Mã số thuế");

        txtMST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMSTActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Mã số");

        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        tbDSKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên khách hàng", "Địa chỉ", "Mã số thuế", "Mã số"
            }
        ));
        jScrollPane2.setViewportView(tbDSKH);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xóa khách hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnthemKH.setBackground(new java.awt.Color(51, 51, 255));
        btnthemKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnthemKH.setForeground(new java.awt.Color(255, 255, 255));
        btnthemKH.setText("Thêm khách hàng");
        btnthemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemKHActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("Cập nhật khách hàng");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMST, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnthemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnthemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtMST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Xem, điều chỉnh danh sách khách hàng", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemKHActionPerformed

        int confirmed = JOptionPane.showConfirmDialog(this, "Chắc chắn thêm khách hàng?", "Xác nhận", JOptionPane.YES_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            String maKH = "";
            String tenKH = "";
            String diaChi = "";
            String maSoThue = "";
            if (txtMaKH.getText().isEmpty() || txtTenKH.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtMST.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Thêm thất bại, vui lòng nhập đầy đủ thông tin");
                return;
            } else {
                maKH = txtMaKH.getText();
                tenKH = txtTenKH.getText();
                diaChi = txtDiaChi.getText();
                maSoThue = txtMST.getText();
                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, maSoThue);
                int themKH = KhachHangDAO.getInstance().insert(kh);
                if (themKH == 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại, vui lòng kiểm tra lại thông tin");
                } else if (themKH == 2) {
                    JOptionPane.showMessageDialog(this, "Mã số khách hàng đã tồn tại, vui lòng nhập mã khác");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    loadTable();
                }
            }

        }


    }//GEN-LAST:event_btnthemKHActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(this, "Có chắc chắn muốn xóa khách hàng?", "Xác nhận", JOptionPane.YES_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            String maKH = "";
            String tenKH = "";
            String diaChi = "";
            String maSoThue = "";
            if (txtMaKH.getText().isEmpty() || txtTenKH.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtMST.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại, vui lòng nhập đầy đủ thông tin");
                return;
            } else {
                maKH = txtMaKH.getText();
                tenKH = txtTenKH.getText();
                diaChi = txtDiaChi.getText();
                maSoThue = txtMST.getText();
                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, maSoThue);
                int xoaKH = KhachHangDAO.getInstance().delete(kh);
                if (xoaKH == 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại, vui lòng kiểm tra lại thông tin");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    loadTable();
                }
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void txtMSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMSTActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(this, "Chắc chắn muốn cập nhật lại thông tin khách hàng?", "Xác nhận", JOptionPane.YES_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            if (tbDSKH.getSelectedRow() != -1) {
                String maSo = tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 4).toString();
                System.out.println(maSo);
                String maKH = "";
                String tenKH = "";
                String diaChi = "";
                String maSoThue = "";
                if (txtMaKH.getText().isEmpty() || txtTenKH.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtMST.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại, vui lòng nhập đầy đủ thông tin");
                    return;
                } else {
                    maKH = txtMaKH.getText();
                    tenKH = txtTenKH.getText();
                    diaChi = txtDiaChi.getText();
                    maSoThue = txtMST.getText();
                    KhachHang kh = new KhachHang(maKH, tenKH, diaChi, maSoThue);
                    int updateKH = KhachHangDAO.getInstance().updateKH(kh,maSo);
                    if (updateKH == 0) {
                        JOptionPane.showMessageDialog(this, "Cập nhật thất bại, vui lòng kiểm tra lại thông tin!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                        loadTable();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để hiển thị thông tin!");
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void loadTable() {
        ArrayList<KhachHang> listKH = KhachHangDAO.getInstance().selectAll();

        DefaultTableModel model = (DefaultTableModel) tbDSKH.getModel();
        model.setRowCount(0);

        Object rowData[] = new Object[5];
        int i = 1;
        for (KhachHang kh : listKH) {
            rowData[0] = i++;
            rowData[1] = kh.getTenKH();
            rowData[2] = kh.getDiaChi();
            rowData[3] = kh.getMaSoThue();
            rowData[4] = kh.getMaKH();

            model.addRow(rowData);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnthemKH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbDSKH;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMST;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
