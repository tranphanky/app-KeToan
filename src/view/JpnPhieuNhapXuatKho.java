/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.HangHoaDAO;
import dao.TaiKhoanKeToanDAO;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import dao.KhachHangDAO;
import dao.KhoDAO;
import model.Kho;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import controller.IntegerCellEditor;
import controller.WordReplaceFiled;
import controller.OpenFileWord;
import controller.BoundsPopupMenuListener;
import dao.HDBHDAO;
import dao.PhieuNhapKhoDAO;
import dao.PhieuXuatKhoDAO;
import dao.TBHDBHDAO;
import model.PhieuNhapKho;
import dao.TBPNKDAO;
import dao.TBPXKDAO;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.HDBH;
import model.PhieuXuatKho;
import model.TBHDBH;
import model.TBPNK;
import model.TBPXK;


/**
 *
 * @author PC
 */
public class JpnPhieuNhapXuatKho extends javax.swing.JPanel {

    /**
     * Creates new form JpnPhieuThuChiTM
     */
    public JpnPhieuNhapXuatKho() {
        initComponents();

        btnXuatFilePNK.setVisible(false);
        btnXuatFilePXK.setVisible(false);
        tbPNK.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return new JLabel("" + (row + 1));
            }
        });
        tbPXK.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return new JLabel("" + (row + 1));
            }
        });
        tbHDBH.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return new JLabel("" + (row + 1));
            }
        });
        tbNLK.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return new JLabel("" + (row + 1));
            }
        });
        
        
        // khởi tạo tăng kích thước cho dropdown 
        BoundsPopupMenuListener listener = new BoundsPopupMenuListener(true, true, 300, false);

        DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value,
                        index, isSelected, cellHasFocus);

                // nếu c là JLabel và value là String
                if (c instanceof JLabel && value instanceof String) {
                    String stringValue = (String) value;
                    // cắt đoạn văn bản hiển thị ngắn lại
                    ((JLabel) c).setText(stringValue.length() > 25
                            ? stringValue.substring(0, 25) + "..."
                            : stringValue);
                    // thêm tooltips cho mỗi mục
                    ((JLabel) c).setToolTipText(stringValue);
                }

                return c;
            }
        };

        jCBBTKCo.setRenderer(renderer);
        jCBBTKNo.setRenderer(renderer);
        jCBBTKNoXK.setRenderer(renderer);
        jCBBTKCoXK.setRenderer(renderer);
        jCBBTKNoHDBH.setRenderer(renderer);
        jCBBTKCoHDBH.setRenderer(renderer);
        jCBBTKNoNLK.setRenderer(renderer);
        jCBBTKCoNLK.setRenderer(renderer);

        //Set Jcombobox TKNo, TKCo
        ArrayList<String> listTK = TaiKhoanKeToanDAO.getInstance().getName();
        for (String tk : listTK) {
            jCBBTKCo.addItem(tk);
            jCBBTKNo.addItem(tk);
            jCBBTKNoXK.addItem(tk);
            jCBBTKCoXK.addItem(tk);
            jCBBTKNoHDBH.addItem(tk);
            jCBBTKCoHDBH.addItem(tk);
            jCBBTKNoNLK.addItem(tk);
            jCBBTKCoNLK.addItem(tk);
        }

        // set value Jcombobox MaKH
        ArrayList<KhachHang> listKH = KhachHangDAO.getInstance().selectAll();
        for (KhachHang khachHang : listKH) {
            String maKH = khachHang.getMaKH();
            jCBBKH.addItem(maKH);
            jCBBKHPXK.addItem(maKH);
            jCBBKHHDBH.addItem(maKH);
            jCBBKHLNK.addItem(maKH);
        }
        //set value Jcombobox MaKho
        ArrayList<Kho> listKho = KhoDAO.getInstance().selectAll();
        for (Kho kh : listKho) {
            String maKho = kh.getMaSoKho();
            jCBBKho.addItem(maKho);
            jCBBMaKhoPXK.addItem(maKho);
            jCBBMKHDBH.addItem(maKho);

        }
        
        
        ArrayList<String> listCho = new ArrayList<>();
        listCho.add("01 Cho KD chịu GTGT");
        listCho.add("02 Cho KD không chịu GTGT");
        listCho.add("03 Cho KD chịu và không chịu GTGT");
        listCho.add("04 Cho dự án đầu tư tài sản cố định");
        for (String cho : listCho) {
            jCBBChoPNK.addItem(cho);
            jCBBChoNLK.addItem(cho);
        }
        jCBBChoPNK.addPopupMenuListener(listener);
        jCBBChoNLK.addPopupMenuListener(listener);
        
        ArrayList<String> listTheo = new ArrayList<>();
        listTheo.add("G Hóa đơn GTGT");
        listTheo.add("T Hóa đơn trực tiếp");
        listTheo.add("M Mua theo bảng kê");
        listTheo.add("N Nhập khẩu");
        for (String theo : listTheo) {
            jCBBTheoPNK.addItem(theo);
            jCBBTheoNLK.addItem(theo);
        }
        jCBBTheoPNK.addPopupMenuListener(listener);
        jCBBTheoNLK.addPopupMenuListener(listener);
        // set value JCombobox MaHH
        //tbPNK.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JComboBox(new String[]{"Item 1", "Item 2", "Item 3"})));
        //tbPNK.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JComboBox(new String[]{"Item 1", "Item 2", "Item 3"})));
        ArrayList<String> listMaHH = HangHoaDAO.getInstance().getMaHH();
        String[] arrayMaHH = listMaHH.toArray(new String[0]);
        //tbPNK.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JComboBox(arrayMaHH)));
        tbPXK.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JComboBox(arrayMaHH)));

        //set constraint input = number
        tbPNK.getColumnModel().getColumn(4).setCellEditor(new IntegerCellEditor(new JTextField()));
        tbPNK.getColumnModel().getColumn(5).setCellEditor(new IntegerCellEditor(new JTextField()));
        tbPNK.getColumnModel().getColumn(6).setCellEditor(new IntegerCellEditor(new JTextField()));

        tbPXK.getColumnModel().getColumn(4).setCellEditor(new IntegerCellEditor(new JTextField()));
        tbPXK.getColumnModel().getColumn(5).setCellEditor(new IntegerCellEditor(new JTextField()));
        tbPXK.getColumnModel().getColumn(6).setCellEditor(new IntegerCellEditor(new JTextField()));

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
        jPanel11 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtNguoiNhanPXK = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTomTatPXK = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPXK = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jCBBKHPXK = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        sumPXK = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtCTGPXK = new javax.swing.JTextField();
        btnXuatFilePXK = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        thangNK8 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jCBBTKNoXK = new javax.swing.JComboBox<>();
        jCBBTKCoXK = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtMonthPXK = new javax.swing.JTextField();
        txtYearPXK = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaPhieuXuat = new javax.swing.JTextField();
        txtngayChungTuPXK = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jCBBMaKhoPXK = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtNguoiMuaHDBH = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtNoiDungHDBH = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbHDBH = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jCBBKHHDBH = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jCBBNHHDBH = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jCBBMKHDBH = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtCongHDBH = new javax.swing.JTextField();
        txtGTGTHDBH = new javax.swing.JTextField();
        txtCongTHHDBH = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        thangNK9 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jCBBTKNoHDBH = new javax.swing.JComboBox<>();
        jCBBTKCoHDBH = new javax.swing.JComboBox<>();
        jPanel19 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtMaHDBH = new javax.swing.JTextField();
        txtNgayChungTuHDBH = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txNguoiNhan2 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtDiaChi4 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jComboBox18 = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jCBBKHLNK = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jComboBox22 = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtDiaChi5 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtDiaChi6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNLK = new javax.swing.JTable();
        jLabel53 = new javax.swing.JLabel();
        jComboBox27 = new javax.swing.JComboBox<>();
        jComboBox28 = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jComboBox29 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jCBBTKNoNLK = new javax.swing.JComboBox<>();
        jCBBTKCoNLK = new javax.swing.JComboBox<>();
        jPanel25 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jCBBTheoNLK = new javax.swing.JComboBox<>();
        jCBBChoNLK = new javax.swing.JComboBox<>();
        txtngayChungTu1 = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        thangNK4 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jCBBTKNo = new javax.swing.JComboBox<>();
        jCBBTKCo = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTenNguoiGiaoPNK = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTomTatPNK = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPNK = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnNhapPNK = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        sumPNK = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCBBKH = new javax.swing.JComboBox<>();
        jCBBKho = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        thueGTGTPNK = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtkemtheoCTG = new javax.swing.JTextField();
        btnXuatFilePNK = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaPNK = new javax.swing.JTextField();
        jCBBTheoPNK = new javax.swing.JComboBox<>();
        jCBBChoPNK = new javax.swing.JComboBox<>();
        txtngayChungTu = new com.toedter.calendar.JDateChooser();
        jPanel17 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtMonthPNK = new javax.swing.JTextField();
        txtYearPNK = new javax.swing.JTextField();

        jPanel11.setBackground(new java.awt.Color(153, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 0, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PHIẾU XUẤT KHO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(28, 28, 28))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Người nhận hàng");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Lý do xuất (tóm tắt)");

        txtTomTatPXK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTomTatPXKActionPerformed(evt);
            }
        });

        tbPXK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbPXK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbPXK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên hàng hóa", "Mã số", "Đơn vị tính", "Số lượng yêu cầu", "Số lượng thực nhập", "Đơn giá", "Thành tiền"
            }
        ));
        tbPXK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPXKMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbPXK);

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 255));
        jButton7.setText("Thêm dòng");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Khách hàng");

        jCBBKHPXK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButton13.setBackground(new java.awt.Color(51, 51, 255));
        jButton13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Lập phiếu");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(51, 51, 255));
        jButton14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Sổ nhật ký");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 0, 0));
        jButton15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Kết thúc");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        sumPXK.setEditable(false);
        sumPXK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sumPXK.setForeground(new java.awt.Color(255, 51, 51));
        sumPXK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sumPXK.setText("0");
        sumPXK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumPXKActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel56.setText("Cộng");

        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel59.setText("Kèm theo chứng từ gốc");

        txtCTGPXK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCTGPXK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCTGPXK.setText("0");
        txtCTGPXK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCTGPXKActionPerformed(evt);
            }
        });

        btnXuatFilePXK.setBackground(new java.awt.Color(51, 51, 255));
        btnXuatFilePXK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXuatFilePXK.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFilePXK.setText("Xuất File");
        btnXuatFilePXK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFilePXKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton7)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNguoiNhanPXK, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(txtTomTatPXK, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel18)))
                                .addGap(18, 18, 18)
                                .addComponent(jCBBKHPXK, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jButton13)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnXuatFilePXK)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addComponent(jButton14)
                                                .addGap(492, 492, 492))
                                            .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCTGPXK, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addGap(18, 18, 18)
                                .addComponent(sumPXK, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(514, 514, 514))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtNguoiNhanPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTomTatPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jCBBKHPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jLabel59)
                    .addComponent(txtCTGPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sumPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(49, 49, 49)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton14)
                    .addComponent(jButton13)
                    .addComponent(btnXuatFilePXK))
                .addGap(49, 49, 49))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("TK Có  :");

        thangNK8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thangNK8thangNKActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("TK Nợ  :");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thangNK8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBBTKNoXK, 0, 141, Short.MAX_VALUE)
                            .addComponent(jCBBTKCoXK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jCBBTKNoXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jCBBTKCoXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(thangNK8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 102, 0));
        jLabel26.setText("Ghi sổ nhật ký");

        txtMonthPXK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMonthPXKMouseClicked(evt);
            }
        });
        txtMonthPXK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonthPXKActionPerformed(evt);
            }
        });

        txtYearPXK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYearPXKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMonthPXK, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtYearPXK, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonthPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYearPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("Số:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setText("Ngày C. Từ");

        txtMaPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhieuXuatActionPerformed(evt);
            }
        });

        txtngayChungTuPXK.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(67, 67, 67)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngayChungTuPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhieuXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngayChungTuPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Mã số kho");

        jCBBMaKhoPXK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jCBBMaKhoPXK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBMaKhoPXKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBBMaKhoPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jCBBMaKhoPXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phiếu xuất kho", jPanel11);

        jPanel13.setBackground(new java.awt.Color(153, 255, 255));

        jPanel7.setBackground(new java.awt.Color(0, 0, 255));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("HÓA ĐƠN BÁN HÀNG");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(28, 28, 28))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Người mua");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Nội dung");

        txtNoiDungHDBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoiDungHDBHActionPerformed(evt);
            }
        });

        tbHDBH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbHDBH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbHDBH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Số lượng", "Đơn giá", "Số tiền", "Mã HH", "Tên Hàng hóa", "USD"
            }
        ));
        jScrollPane4.setViewportView(tbHDBH);

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 255));
        jButton8.setText("Thêm dòng");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Khách hàng");

        jCBBKHHDBH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel33.setText("Ngân hàng");

        jCBBNHHDBH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jCBBNHHDBH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NH01" }));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel34.setText("Nhận ở kho");

        jCBBMKHDBH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel35.setText("Cộng tiền hàng");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel36.setText("Tổng cộng tiền thanh toán");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel37.setText("Thuế GTGT");

        txtCongHDBH.setEditable(false);
        txtCongHDBH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtGTGTHDBH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtGTGTHDBH.setForeground(new java.awt.Color(255, 51, 51));
        txtGTGTHDBH.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtCongTHHDBH.setEditable(false);
        txtCongTHHDBH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCongTHHDBH.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField18.setEditable(false);
        jTextField18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField19.setEditable(false);
        jTextField19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButton10.setBackground(new java.awt.Color(51, 51, 255));
        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Nhập phiếu");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(51, 51, 255));
        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Sổ nhật ký");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 0, 0));
        jButton12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Kết thúc");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel20)
                                .addComponent(jLabel19))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addComponent(txtNoiDungHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21)
                                    .addGap(18, 18, 18)
                                    .addComponent(jCBBKHHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addComponent(txtNguoiMuaHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel34)
                                        .addComponent(jLabel33))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBBNHHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCBBMKHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(56, 56, 56))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                        .addComponent(jButton10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton11)
                                        .addGap(492, 492, 492))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton12)))
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel36)
                                            .addComponent(jLabel37)
                                            .addComponent(jLabel35))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(txtCongHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(txtCongTHHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(txtGTGTHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGap(31, 31, 31)))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtNguoiMuaHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jCBBMKHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jCBBNHHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtNoiDungHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jCBBKHHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtCongTHHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtGTGTHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtCongHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton11)
                    .addComponent(jButton10))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("TK Có  :");

        thangNK9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thangNK9thangNKActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("TK Nợ  :");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(thangNK9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBBTKNoHDBH, 0, 141, Short.MAX_VALUE)
                            .addComponent(jCBBTKCoHDBH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jCBBTKNoHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jCBBTKCoHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(thangNK9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 102, 0));
        jLabel30.setText("Ghi sổ nhật ký");

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 255));
        jLabel22.setText("Số:");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 255));
        jLabel31.setText("Ngày C. Từ");

        txtMaHDBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDBHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(67, 67, 67)))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(txtMaHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(txtNgayChungTuHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHDBH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayChungTuHDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(76, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1349, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 989, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Hóa đơn bán hàng", jPanel2);

        jPanel21.setBackground(new java.awt.Color(153, 255, 255));

        jPanel22.setBackground(new java.awt.Color(0, 0, 255));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("NHẬP LIỆU KHÁC");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(28, 28, 28))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel38.setText("Họ tên / Đơn vị");

        txNguoiNhan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNguoiNhan2ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel39.setText("Địa chỉ");

        txtDiaChi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChi4ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 0, 255));
        jButton9.setText("Thêm dòng");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel40.setText("Hàng hóa");

        jComboBox18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel41.setText("Khách hàng");

        jCBBKHLNK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jCBBKHLNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBKHLNKActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel42.setText("Ngân hàng");

        jComboBox22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox22.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel43.setText("Cộng tiền hàng");

        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel44.setText("Tổng cộng tiền thanh toán");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel45.setText("Thuế GTGT");

        jTextField20.setEditable(false);
        jTextField20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextField21.setEditable(false);
        jTextField21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField22.setEditable(false);
        jTextField22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField23.setEditable(false);
        jTextField23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });

        jTextField24.setEditable(false);
        jTextField24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField25.setEditable(false);
        jTextField25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel51.setText("Nội dung");

        txtDiaChi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChi5ActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel52.setText("Kèm theo");

        txtDiaChi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChi6ActionPerformed(evt);
            }
        });

        tbNLK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "TT", "Số tiền", "USD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbNLK);
        if (tbNLK.getColumnModel().getColumnCount() > 0) {
            tbNLK.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel53.setText("Thuộc chi phí");

        jComboBox27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox27.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox28.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox28.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox28ActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel54.setText("Sản phẩm");

        jLabel55.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel55.setText("Phân xưởng");

        jComboBox29.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox29.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sổ nhật ký");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Kết thúc");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Nhập phiếu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel43))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(661, 661, 661))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtDiaChi6)
                                            .addComponent(txNguoiNhan2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                            .addComponent(txtDiaChi5, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                        .addComponent(jLabel39)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDiaChi4, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox22, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jCBBKHLNK, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel23Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel55)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel23Layout.createSequentialGroup()
                                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel53)
                                                    .addComponent(jLabel54))
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(413, 413, 413)
                        .addComponent(jButton4))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txNguoiNhan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(txtDiaChi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtDiaChi5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtDiaChi6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(jComboBox22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jCBBKHLNK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(200, 200, 200))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 0, 0));
        jLabel46.setText("TK Có  :");

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 0, 0));
        jLabel47.setText("TK Nợ  :");

        jCBBTKCoNLK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBTKCoNLKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBBTKNoNLK, 0, 141, Short.MAX_VALUE)
                    .addComponent(jCBBTKCoNLK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jCBBTKNoNLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jCBBTKCoNLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 102, 0));
        jLabel48.setText("Ghi sổ nhật ký");

        jTextField26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });

        jTextField27.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 255));
        jLabel49.setText("Số:");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 255));
        jLabel50.setText("Ngày C. Từ");

        jTextField29.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });

        jCBBTheoNLK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jCBBChoNLK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtngayChungTu1.setDateFormatString("dd/MM/yyyy");
        txtngayChungTu1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtngayChungTu1.setPreferredSize(new java.awt.Dimension(103, 23));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtngayChungTu1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCBBChoNLK, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBBTheoNLK, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBBChoNLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtngayChungTu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCBBTheoNLK, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(81, Short.MAX_VALUE))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1344, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Nhập liệu khác", jPanel3);

        jPanel10.setBackground(new java.awt.Color(153, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PHIẾU NHẬP KHO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("TK Có  :");

        thangNK4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thangNK4thangNKActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("TK Nợ  :");

        jCBBTKNo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jCBBTKNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBTKNoActionPerformed(evt);
            }
        });

        jCBBTKCo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thangNK4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBBTKNo, 0, 141, Short.MAX_VALUE)
                            .addComponent(jCBBTKCo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jCBBTKNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jCBBTKCo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(thangNK4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tên người giao :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Theo (... tóm tắt) :");

        txtTomTatPNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTomTatPNKActionPerformed(evt);
            }
        });

        tbPNK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbPNK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbPNK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên hàng hóa", "Mã số", "Đơn vị tính", "Số lượng theo chứng từ", "Số lượng thực nhập", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPNK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPNKMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPNK);
        if (tbPNK.getColumnModel().getColumnCount() > 0) {
            tbPNK.getColumnModel().getColumn(0).setMinWidth(50);
            tbPNK.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbPNK.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Kết thúc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnNhapPNK.setBackground(new java.awt.Color(51, 51, 255));
        btnNhapPNK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnNhapPNK.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapPNK.setText("Nhập phiếu");
        btnNhapPNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapPNKActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Cộng");

        sumPNK.setEditable(false);
        sumPNK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sumPNK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sumPNK.setText("0");
        sumPNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumPNKActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 255));
        jButton6.setText("Thêm dòng");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Nhập vô kho");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Khách hàng");

        jCBBKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jCBBKho.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel57.setText("Thuế GTGT");

        thueGTGTPNK.setEditable(false);
        thueGTGTPNK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        thueGTGTPNK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        thueGTGTPNK.setText("0");
        thueGTGTPNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thueGTGTPNKActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel58.setText("Số chứng từ gốc kèm theo");

        txtkemtheoCTG.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtkemtheoCTG.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtkemtheoCTG.setText("0");
        txtkemtheoCTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkemtheoCTGActionPerformed(evt);
            }
        });

        btnXuatFilePNK.setBackground(new java.awt.Color(51, 51, 255));
        btnXuatFilePNK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXuatFilePNK.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFilePNK.setText("Xuất File");
        btnXuatFilePNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFilePNKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(txtTomTatPNK, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(txtTenNguoiGiaoPNK, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5))))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCBBKH, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBBKho, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnNhapPNK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXuatFilePNK)
                                .addGap(788, 788, 788)
                                .addComponent(jButton1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(1005, 1005, 1005)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thueGTGTPNK, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sumPNK, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtkemtheoCTG, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(515, 515, 515))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenNguoiGiaoPNK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTomTatPNK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCBBKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jCBBKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel58)
                        .addComponent(txtkemtheoCTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6))
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel57)
                        .addComponent(thueGTGTPNK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(sumPNK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhapPNK)
                    .addComponent(jButton1)
                    .addComponent(btnXuatFilePNK))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Số:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("Ngày C. Từ");

        txtMaPNK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtMaPNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPNKActionPerformed(evt);
            }
        });

        jCBBTheoPNK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jCBBTheoPNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBTheoPNKActionPerformed(evt);
            }
        });

        jCBBChoPNK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jCBBChoPNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBChoPNKActionPerformed(evt);
            }
        });

        txtngayChungTu.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtngayChungTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaPNK))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBBTheoPNK, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBBChoPNK, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPNK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBBChoPNK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBBTheoPNK)
                    .addComponent(txtngayChungTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 102, 0));
        jLabel27.setText("Ghi sổ nhật ký");

        txtMonthPNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonthPNKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMonthPNK, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtYearPNK, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonthPNK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYearPNK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(83, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phiếu nhập kho", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void thangNK8thangNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thangNK8thangNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thangNK8thangNKActionPerformed

    private void txtMonthPXKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthPXKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonthPXKActionPerformed

    private void txtMaPhieuXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuXuatActionPerformed

    private void txtTomTatPXKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTomTatPXKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTomTatPXKActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbPXK.getModel();
        model.addRow(new Object[]{"", "", "", "", "", "", ""});
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtNoiDungHDBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoiDungHDBHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoiDungHDBHActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbHDBH.getModel();
        model.addRow(new Object[]{"", "", "", "", "", "", ""});
    }//GEN-LAST:event_jButton8ActionPerformed

    private void thangNK9thangNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thangNK9thangNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thangNK9thangNKActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void txtMaHDBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDBHActionPerformed


    }//GEN-LAST:event_txtMaHDBHActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void txtDiaChi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChi4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbNLK.getModel();
        model.addRow(new Object[]{"", "", ""});
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jCBBKHLNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBKHLNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBBKHLNKActionPerformed

    private void txNguoiNhan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNguoiNhan2ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txNguoiNhan2ActionPerformed

    private void txtDiaChi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChi5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChi5ActionPerformed

    private void txtDiaChi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChi6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChi6ActionPerformed

    private void jComboBox28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox28ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(this, "Xác nhận lập phiếu", "Xác nhận", JOptionPane.YES_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            String TKNo = "";
            String TKCo = "";
            String maHDBH = "";
            String nguoiMua = "";
            String noiDung = "";
            String kho = "";
            String maNH = "";
            String maKH = "";
            double thueGTGT = 0;
            java.sql.Date sqlNgayChungTu = null;
            Date currentDate = new Date();

            if (txtNgayChungTuHDBH.getDate() == null) {
                txtNgayChungTuHDBH.setDate(currentDate);
            }

            if (jCBBTKNoHDBH.getSelectedItem().toString().isEmpty() || jCBBTKCoHDBH.getSelectedItem().toString().isEmpty()
                    || txtMaHDBH.getText().isEmpty() || txtNgayChungTuHDBH.getDate().toString().isEmpty() || txtNguoiMuaHDBH.getText().isEmpty()
                    || jCBBKHHDBH.getSelectedItem().toString().isEmpty() || jCBBMKHDBH.getSelectedItem().toString().isEmpty() || jCBBNHHDBH.getSelectedItem().toString().isEmpty()
                    || txtGTGTHDBH.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            } else {
                TKNo = (String) jCBBTKNoHDBH.getSelectedItem();
                TKCo = (String) jCBBTKCoHDBH.getSelectedItem();
                maHDBH = txtMaHDBH.getText();
                nguoiMua = txtNguoiMuaHDBH.getText();
                noiDung = txtNoiDungHDBH.getText();
                kho = (String) jCBBMKHDBH.getSelectedItem();
                maKH = (String) jCBBKHHDBH.getSelectedItem();
                maNH = (String) jCBBNHHDBH.getSelectedItem();
                thueGTGT = Double.parseDouble(txtGTGTHDBH.getText());
                sqlNgayChungTu = new java.sql.Date(txtNgayChungTuHDBH.getDate().getTime());
            }

            HDBH hd = new HDBH(maHDBH, sqlNgayChungTu, TKNo, TKCo, nguoiMua, noiDung, kho, maNH, maKH, 0, 0, 0);
            int themHDBH = HDBHDAO.getInstance().insert(hd);
            if (themHDBH == 1) {
                int IndexSTT = tbHDBH.getColumn("STT").getModelIndex();
                int IndexSL = tbHDBH.getColumn("Số lượng").getModelIndex();
                int IndexDG = tbHDBH.getColumn("Đơn giá").getModelIndex();
                int IndexST = tbHDBH.getColumn("Số tiền").getModelIndex();
                int IndexMHH = tbHDBH.getColumn("Mã HH").getModelIndex();
                int IndexTHH = tbHDBH.getColumn("Tên Hàng hóa").getModelIndex();
                int IndexUSD = tbHDBH.getColumn("USD").getModelIndex();

                int congTienHang = 0;

                for (int rowIndex = 0; rowIndex < tbHDBH.getRowCount(); rowIndex++) {

                    Object obsoLuong = tbHDBH.getValueAt(rowIndex, IndexSL);
                    Object obdonGia = tbHDBH.getValueAt(rowIndex, IndexDG);
                    Object obsoTien = tbHDBH.getValueAt(rowIndex, IndexST);
                    Object obmaHH = tbHDBH.getValueAt(rowIndex, IndexMHH);
                    Object obTHH = tbHDBH.getValueAt(rowIndex, IndexTHH);
                    Object obusd = tbHDBH.getValueAt(rowIndex, IndexUSD);

                    int soLuong = 0;
                    int donGia = 0;
                    int soTien = 0;
                    String maHH = "";
                    String tenHH = "";
                    int usd = 0;
                    try {
                        if (obsoLuong != "") {
                            soLuong = Integer.parseInt((String) obsoLuong);
                        }
                        if (obdonGia != "") {
                            donGia = Integer.parseInt((String) obdonGia);
                        }
                        if (obsoTien != "") {
                            soTien = Integer.parseInt((String) obsoTien);
                        }
                        if (obmaHH != "") {
                            maHH = (String) obmaHH.toString();
                        }
                        if (obTHH != "") {
                            tenHH = (String) obTHH.toString();
                        }
                        if (obusd != "") {
                            usd = Integer.parseInt((String) obusd);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra thông tin trong bảng");
                        System.out.print(e);
                        HDBHDAO.getInstance().delete(hd);
                        return;
                    }

                    congTienHang = congTienHang + soTien;

                    TBHDBH tb = new TBHDBH(soLuong, donGia, soTien, maHH, tenHH, usd, maHDBH);
                    int themBangHDBH = TBHDBHDAO.getInstance().insert(tb);
                    if (themBangHDBH == 0) {
                        JOptionPane.showMessageDialog(this, "Xảy ra lỗi khi thêm, vui lòng kiểm tra lại thông tin nhập trong bảng đã chính xác chưa.");
                        HDBHDAO.getInstance().delete(hd);
                        return;

                    }
                }
                txtCongTHHDBH.setText(String.valueOf(congTienHang));
                double sum = congTienHang * thueGTGT + congTienHang;
                txtCongHDBH.setText(String.valueOf(sum));
                HDBHDAO.getInstance().updateSum(congTienHang, thueGTGT, sum, maHDBH);

            } else if (themHDBH == 2) {
                JOptionPane.showMessageDialog(this, "Trùng lập mã phiếu xuất kho, vui lòng nhập mã khác");
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Xảy ra lỗi khi lập phiếu, vui lòng kiểm tra lại thông tin");
                return;
            }
            JOptionPane.showMessageDialog(this, "Lập phiếu thành công");
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        int confirmed = JOptionPane.showConfirmDialog(this, "Xác nhận lập phiếu", "Xác nhận", JOptionPane.YES_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            String TKNo = "";
            String TKCo = "";
            String maPhieuXuat = "";
            String tenNguoiNhan = "";
            String tomTat = "";
            String kho = "";
            String maKH = "";
            String chungTuGoc = "";
            java.sql.Date sqlNgayChungTu = null;
            Date currentDate = new Date();

            if (txtngayChungTuPXK.getDate() == null) {
                txtngayChungTuPXK.setDate(currentDate);
            }

            if (jCBBTKNoXK.getSelectedItem().toString().isEmpty() || jCBBTKCoXK.getSelectedItem().toString().isEmpty()
                    || txtMaPhieuXuat.getText().isEmpty() || txtngayChungTuPXK.getDate().toString().isEmpty()
                    || txtNguoiNhanPXK.getText().isEmpty() || jCBBMaKhoPXK.getSelectedItem().toString().isEmpty() || txtCTGPXK.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            } else {
                TKNo = (String) jCBBTKNo.getSelectedItem();
                TKCo = (String) jCBBTKCo.getSelectedItem();
                maPhieuXuat = txtMaPhieuXuat.getText();
                tenNguoiNhan = txtNguoiNhanPXK.getText();
                tomTat = txtTomTatPXK.getText();
                kho = (String) jCBBMaKhoPXK.getSelectedItem();
                maKH = (String) jCBBKHPXK.getSelectedItem();
                chungTuGoc = txtCTGPXK.getText();
                sqlNgayChungTu = new java.sql.Date(txtngayChungTuPXK.getDate().getTime());
            }

            PhieuXuatKho pxk = new PhieuXuatKho(maPhieuXuat, sqlNgayChungTu, TKNo, TKCo, tenNguoiNhan, tomTat, kho, maKH, 0, chungTuGoc);
            int themPhieu = PhieuXuatKhoDAO.getInstance().insert(pxk);
            if (themPhieu == 1) {

                int IndexTHH = tbPXK.getColumn("Tên hàng hóa").getModelIndex();
                int IndexMS = tbPXK.getColumn("Mã số").getModelIndex();
                int IndexDVT = tbPXK.getColumn("Đơn vị tính").getModelIndex();
                int IndexSLYC = tbPXK.getColumn("Số lượng yêu cầu").getModelIndex();
                int IndexSLTN = tbPXK.getColumn("Số lượng thực nhập").getModelIndex();
                int IndexDG = tbPXK.getColumn("Đơn giá").getModelIndex();
                int IndexTT = tbPXK.getColumn("Thành tiền").getModelIndex();

                double sum = 0;

                for (int rowIndex = 0; rowIndex < tbPXK.getRowCount(); rowIndex++) {

                    Object obTHH = tbPXK.getValueAt(rowIndex, IndexTHH);
                    Object obMS = tbPXK.getValueAt(rowIndex, IndexMS);
                    Object obDVT = tbPXK.getValueAt(rowIndex, IndexDVT);
                    Object obSLYC = tbPXK.getValueAt(rowIndex, IndexSLYC);
                    Object obSLTN = tbPXK.getValueAt(rowIndex, IndexSLTN);
                    Object obDG = tbPXK.getValueAt(rowIndex, IndexDG);
                    Object obTT = tbPXK.getValueAt(rowIndex, IndexTT);

                    String tenHH = "";
                    String maSo = "";
                    String dvt = "";
                    int slyc = 0;
                    int sltn = 0;
                    int donGia = 0;
                    int thanhTien = 0;

                    int usd = 0;
                    if (obTHH != "") {
                        tenHH = (String) obTHH.toString();
                    }
                    if (obMS != "") {
                        maSo = (String) obMS.toString();
                    }
                    if (obDVT != "") {
                        dvt = (String) obDVT.toString();
                    }
                    if (obDG != "") {
                        donGia = Integer.parseInt((String) obDG);
                    }
                    if (obSLYC != "") {
                        slyc = Integer.parseInt((String) obSLYC);
                        thanhTien = slyc * donGia;
                    }
                    if (obSLTN != "") {
                        sltn = Integer.parseInt((String) obSLTN);
                        thanhTien = sltn * donGia;
                    }

                    sum = sum + thanhTien;
                    TBPXK tb = new TBPXK(tenHH, maSo, dvt, slyc, sltn, donGia, thanhTien, maPhieuXuat);
                    int themBangPXK = TBPXKDAO.getInstance().insert(tb);
                    if (themBangPXK == 0) {
                        JOptionPane.showMessageDialog(this, "Xảy ra lỗi khi thêm, vui lòng kiểm tra lại thông tin nhập trong bảng đã chính xác chưa.");
                        PhieuXuatKhoDAO.getInstance().delete(pxk);
                        return;

                    }
                }
                sumPXK.setText(String.valueOf(sum));
                PhieuXuatKhoDAO.getInstance().updateSum(sum, maPhieuXuat);

            } else if (themPhieu == 2) {
                JOptionPane.showMessageDialog(this, "Trùng lập mã phiếu xuất kho, vui lòng nhập mã khác");
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Xảy ra lỗi khi lập phiếu, vui lòng kiểm tra lại thông tin");
                return;
            }
            JOptionPane.showMessageDialog(this, "Lập phiếu thành công");
            btnXuatFilePXK.setVisible(true);
        }


    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jCBBTKCoNLKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBTKCoNLKActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jCBBTKCoNLKActionPerformed

    private void txtMonthPNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthPNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonthPNKActionPerformed

    private void txtMaPNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPNKActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbPNK.getModel();
        model.addRow(new Object[]{"", "", "", "", "", "", ""});
    }//GEN-LAST:event_jButton6ActionPerformed

    private void sumPNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumPNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sumPNKActionPerformed

    private void btnNhapPNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapPNKActionPerformed

        int confirmed = JOptionPane.showConfirmDialog(this, "Xác nhận lập phiếu", "Xác nhận", JOptionPane.YES_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            String TKNo = "";
            String TKCo = "";
            String maPhieuNhap = "";
            String tenNguoiGiao = "";
            String tomTat = "";
            String kho = "";
            String maKH = "";
            String kemtheoCTG = "";
            double thueGTGT = 0;
            String chiuThue="";
            String hinhThuc="";
            java.sql.Date sqlNgayChungTu = null;
            Date currentDate = new Date();

            if (txtngayChungTu.getDate() == null) {
                txtngayChungTu.setDate(currentDate);
            }

            if (jCBBTKNo.getSelectedItem().toString().isEmpty()
                    || jCBBTKCo.getSelectedItem().toString().isEmpty() || txtMaPNK.getText().isEmpty()
                    || txtngayChungTu.getDate().toString().isEmpty() || txtTenNguoiGiaoPNK.getText().isEmpty()
                    || jCBBKho.getSelectedItem().toString().isEmpty() || thueGTGTPNK.getText().isEmpty() || 
                    jCBBTheoPNK.getSelectedItem().toString().isEmpty() || jCBBChoPNK.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            } else {
                TKNo = (String) jCBBTKNo.getSelectedItem();
                TKCo = (String) jCBBTKCo.getSelectedItem();
                maPhieuNhap = txtMaPNK.getText();
                tenNguoiGiao = txtTenNguoiGiaoPNK.getText();
                tomTat = txtTomTatPNK.getText();
                kho = (String) jCBBKho.getSelectedItem();
                maKH = (String) jCBBKH.getSelectedItem();
                kemtheoCTG = txtkemtheoCTG.getText();
                thueGTGT = Float.parseFloat(thueGTGTPNK.getText());
                sqlNgayChungTu = new java.sql.Date(txtngayChungTu.getDate().getTime());
                chiuThue = (String) jCBBChoPNK.getSelectedItem();
                hinhThuc = (String) jCBBTheoPNK.getSelectedItem();
                
            }

            PhieuNhapKho pnk = new PhieuNhapKho(maPhieuNhap, sqlNgayChungTu, TKNo, TKCo, tenNguoiGiao, tomTat, kho, maKH, 0, 0, kemtheoCTG,hinhThuc,chiuThue);
            int themPhieu = PhieuNhapKhoDAO.getInstance().insert(pnk);
            if (themPhieu == 1) {
                int IndexSTT = tbPNK.getColumn("STT").getModelIndex();
                int IndexTHH = tbPNK.getColumn("Tên hàng hóa").getModelIndex();
                int IndexMS = tbPNK.getColumn("Mã số").getModelIndex();
                int IndexDVT = tbPNK.getColumn("Đơn vị tính").getModelIndex();
                int IndexSLTCT = tbPNK.getColumn("Số lượng theo chứng từ").getModelIndex();
                int IndexSLTN = tbPNK.getColumn("Số lượng thực nhập").getModelIndex();
                int IndexDG = tbPNK.getColumn("Đơn giá").getModelIndex();
                int IndexTT = tbPNK.getColumn("Thành tiền").getModelIndex();

                double sum = 0;

                for (int rowIndex = 0; rowIndex < tbPNK.getRowCount(); rowIndex++) {

                    Object obTHH = tbPNK.getValueAt(rowIndex, IndexTHH);
                    Object obMS = tbPNK.getValueAt(rowIndex, IndexMS);
                    Object obDVT = tbPNK.getValueAt(rowIndex, IndexDVT);
                    Object obSLTCT = tbPNK.getValueAt(rowIndex, IndexSLTCT);
                    Object obSLTN = tbPNK.getValueAt(rowIndex, IndexSLTN);
                    Object obDG = tbPNK.getValueAt(rowIndex, IndexDG);
                    Object obTT = tbPNK.getValueAt(rowIndex, IndexTT);

                    String tenHH = "";
                    String maSo = "";
                    String dvt = "";
                    int sltct = 0;
                    int sltn = 0;
                    int donGia = 0;
                    int thanhTien = 0;

                    int usd = 0;
                    if (obTHH != "") {
                        tenHH = (String) obTHH.toString();
                    }
                    if (obMS != "") {
                        maSo = (String) obMS.toString();
                    }
                    if (obDVT != "") {
                        dvt = (String) obDVT.toString();
                    }
                    if (obDG != "") {
                        donGia = Integer.parseInt((String) obDG);
                    }
                    if (obSLTCT != "") {
                        sltct = Integer.parseInt((String) obSLTCT);
                        thanhTien = sltct * donGia;
                    }
                    if (obSLTN != "") {
                        sltn = Integer.parseInt((String) obSLTN);
                        thanhTien = sltn * donGia;
                    }

                    sum = sum + thanhTien;
                    TBPNK tb = new TBPNK(tenHH, maSo, dvt, sltct, sltn, donGia, thanhTien, maPhieuNhap);
                    int themBangPNK = TBPNKDAO.getInstance().insert(tb);
                    if (themBangPNK == 0) {
                        JOptionPane.showMessageDialog(this, "Xảy ra lỗi khi thêm, vui lòng kiểm tra lại thông tin nhập trong bảng đã chính xác chưa.");
                        PhieuNhapKhoDAO.getInstance().delete(pnk);
                        return;

                    }
                }

                sum = sum + sum * thueGTGT;
                System.out.println(sum);
                PhieuNhapKhoDAO.getInstance().updateSum(sum, maPhieuNhap);

            } else if (themPhieu == 2) {
                JOptionPane.showMessageDialog(this, "Trùng lập mã phiếu nhập vui lòng nhập mã phiếu khác");
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Lập phiếu thất bại, vui lòng xem kĩ lại thông tin");
                return;
            }
            JOptionPane.showMessageDialog(this, "Lập phiếu thành công");
        }
        btnXuatFilePNK.setVisible(true);

    }//GEN-LAST:event_btnNhapPNKActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTomTatPNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTomTatPNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTomTatPNKActionPerformed

    private void jCBBTKNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBTKNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBBTKNoActionPerformed

    private void thangNK4thangNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thangNK4thangNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thangNK4thangNKActionPerformed

    private void sumPXKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumPXKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sumPXKActionPerformed

    private void thueGTGTPNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thueGTGTPNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thueGTGTPNKActionPerformed

    private void jCBBMaKhoPXKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBMaKhoPXKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBBMaKhoPXKActionPerformed

    private void txtMonthPXKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMonthPXKMouseClicked
        // TODO add your handling code here:
        java.sql.Date sqlNgayChungTu = null;
        Date currentDate = new Date();

        if (txtngayChungTuPXK.getDate() == null) {
            txtngayChungTuPXK.setDate(currentDate);
        }
        sqlNgayChungTu = new java.sql.Date(txtngayChungTuPXK.getDate().getTime());
        LocalDate localDate = sqlNgayChungTu.toLocalDate();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        txtMonthPXK.setText(month + "");
        txtYearPXK.setText(year + "");
    }//GEN-LAST:event_txtMonthPXKMouseClicked

    private void txtYearPXKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearPXKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearPXKActionPerformed

    private void txtkemtheoCTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkemtheoCTGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkemtheoCTGActionPerformed

    private void tbPNKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPNKMouseClicked
        // TODO add your handling code here:
        double ThueGTGT = 0;

        int IndexSTT = tbPNK.getColumn("STT").getModelIndex();
        int IndexTHH = tbPNK.getColumn("Tên hàng hóa").getModelIndex();
        int IndexMS = tbPNK.getColumn("Mã số").getModelIndex();
        int IndexDVT = tbPNK.getColumn("Đơn vị tính").getModelIndex();
        int IndexSLTCT = tbPNK.getColumn("Số lượng theo chứng từ").getModelIndex();
        int IndexSLTN = tbPNK.getColumn("Số lượng thực nhập").getModelIndex();
        int IndexDG = tbPNK.getColumn("Đơn giá").getModelIndex();
        int IndexTT = tbPNK.getColumn("Thành tiền").getModelIndex();

        if (thueGTGTPNK.getText().isEmpty()) {
            ThueGTGT = Integer.parseInt(thueGTGTPNK.getText());
        }

        double sum = 0;

        for (int rowIndex = 0; rowIndex < tbPNK.getRowCount(); rowIndex++) {

            Object obTHH = tbPNK.getValueAt(rowIndex, IndexTHH);
            Object obMS = tbPNK.getValueAt(rowIndex, IndexMS);
            Object obDVT = tbPNK.getValueAt(rowIndex, IndexDVT);
            Object obSLTCT = tbPNK.getValueAt(rowIndex, IndexSLTCT);
            Object obSLTN = tbPNK.getValueAt(rowIndex, IndexSLTN);
            Object obDG = tbPNK.getValueAt(rowIndex, IndexDG);
            Object obTT = tbPNK.getValueAt(rowIndex, IndexTT);

            String tenHH = "";
            String maSo = "";
            String dvt = "";
            int sltct = 0;
            int sltn = 0;
            int donGia = 0;
            int thanhTien = 0;

            int usd = 0;
            if (obTHH != null && obTHH != "") {
                tenHH = (String) obTHH.toString();
            }
            if (obMS != null && obMS != "") {
                maSo = (String) obMS.toString();
            }
            if (obDVT != null && obDVT != "") {
                dvt = (String) obDVT.toString();
            }
            if (obDG != null && obDG != "") {
                donGia = Integer.parseInt((String) obDG);
            }
            if (obSLTCT != null && obSLTCT != "") {
                sltct = Integer.parseInt((String) obSLTCT);
                thanhTien = sltct * donGia;
            }
            if (obSLTN != null && obSLTN != "") {
                sltn = Integer.parseInt((String) obSLTN);
                thanhTien = sltn * donGia;
            }
            tbPNK.setValueAt(thanhTien, rowIndex, 7);
            sum = thanhTien + sum;

        }
        sum = sum + sum * ThueGTGT;
        sumPNK.setText(sum + "");

    }//GEN-LAST:event_tbPNKMouseClicked

    private void btnXuatFilePNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFilePNKActionPerformed
        String maPNK = "";
        if (txtMaPNK.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng check lại mã phiếu nhập kho");
        } else {
            maPNK = txtMaPNK.getText();
            PhieuNhapKho p = PhieuNhapKhoDAO.getInstance().selectById(maPNK);
            //System.out.println(p);
            ArrayList<TBPNK> listTB = TBPNKDAO.getInstance().selectAllNoMaPNK(maPNK);
            try {
                int kq = WordReplaceFiled.setValueTablePNK(p, listTB, "PNK_" + p.getMaPNK());
                if (kq == 0) {
                    JOptionPane.showMessageDialog(this, "Lỗi xuất file, vui lòng kiểm tra lại thông tin");
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Xuất file thành công");
                    int confirmed = JOptionPane.showConfirmDialog(this, "Đã xuất file, có muốn mở file ngay bây giờ?", "Mở", JOptionPane.YES_OPTION);
                    if (confirmed == JOptionPane.YES_OPTION) {
                        OpenFileWord.open(p.getMaPNK());
                    } else {
                        return;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(WordReplaceFiled.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnXuatFilePNKActionPerformed

    private void tbPXKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPXKMouseClicked
        int IndexSTT = tbPXK.getColumn("STT").getModelIndex();
        int IndexTHH = tbPXK.getColumn("Tên hàng hóa").getModelIndex();
        int IndexMS = tbPXK.getColumn("Mã số").getModelIndex();
        int IndexDVT = tbPXK.getColumn("Đơn vị tính").getModelIndex();
        int IndexSLYC = tbPXK.getColumn("Số lượng yêu cầu").getModelIndex();
        int IndexSLTN = tbPXK.getColumn("Số lượng thực nhập").getModelIndex();
        int IndexDG = tbPXK.getColumn("Đơn giá").getModelIndex();
        int IndexTT = tbPXK.getColumn("Thành tiền").getModelIndex();

        double sum = 0;
        for (int rowIndex = 0; rowIndex < tbPNK.getRowCount(); rowIndex++) {

            Object obTHH = tbPXK.getValueAt(rowIndex, IndexTHH);
            Object obMS = tbPXK.getValueAt(rowIndex, IndexMS);
            Object obDVT = tbPXK.getValueAt(rowIndex, IndexDVT);
            Object obSLYC = tbPXK.getValueAt(rowIndex, IndexSLYC);
            Object obSLTN = tbPXK.getValueAt(rowIndex, IndexSLTN);
            Object obDG = tbPXK.getValueAt(rowIndex, IndexDG);
            Object obTT = tbPXK.getValueAt(rowIndex, IndexTT);

            String tenHH = "";
            String maSo = "";
            String dvt = "";
            int slyc = 0;
            int sltn = 0;
            int donGia = 0;
            int thanhTien = 0;

            int usd = 0;
            if (obTHH != "") {
                tenHH = (String) obTHH.toString();
            }
            if (obMS != "") {
                maSo = (String) obMS.toString();
            }
            if (obDVT != "") {
                dvt = (String) obDVT.toString();
            }
            if (obDG != "") {
                donGia = Integer.parseInt((String) obDG);
            }
            if (obSLYC != "") {
                slyc = Integer.parseInt((String) obSLYC);
                thanhTien = slyc * donGia;
            }
            if (obSLTN != "") {
                sltn = Integer.parseInt((String) obSLTN);
                thanhTien = sltn * donGia;
            }

            sum = sum + thanhTien;
            tbPXK.setValueAt(thanhTien, rowIndex, 7);
        }
        sumPXK.setText(sum + "");
    }//GEN-LAST:event_tbPXKMouseClicked

    private void txtCTGPXKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCTGPXKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCTGPXKActionPerformed

    private void btnXuatFilePXKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFilePXKActionPerformed
        String maPXK = "";
        if (txtMaPhieuXuat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng check lại mã phiếu xuất kho");
        } else {
            maPXK = txtMaPhieuXuat.getText();
            PhieuXuatKho p = PhieuXuatKhoDAO.getInstance().selectById(maPXK);
            //System.out.println(p);
            ArrayList<TBPXK> listTB = TBPXKDAO.getInstance().selectAllNoMaPXK(maPXK);
            try {
                int kq = WordReplaceFiled.setValueTablePXK(p, listTB, "PXK_" + p.getMaPXK());
                if (kq == 0) {
                    JOptionPane.showMessageDialog(this, "Lỗi xuất file, vui lòng kiểm tra lại thông tin");
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Xuất file thành công");
                    int confirmed = JOptionPane.showConfirmDialog(this, "Đã xuất file, có muốn mở file ngay bây giờ?", "Mở", JOptionPane.YES_OPTION);
                    if (confirmed == JOptionPane.YES_OPTION) {
                        OpenFileWord.openPXK(p.getMaPXK());
                    } else {
                        return;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(WordReplaceFiled.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXuatFilePXKActionPerformed

    private void jCBBChoPNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBChoPNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBBChoPNKActionPerformed

    private void jCBBTheoPNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBTheoPNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBBTheoPNKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapPNK;
    private javax.swing.JButton btnXuatFilePNK;
    private javax.swing.JButton btnXuatFilePXK;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jCBBChoNLK;
    private javax.swing.JComboBox<String> jCBBChoPNK;
    private javax.swing.JComboBox<String> jCBBKH;
    private javax.swing.JComboBox<String> jCBBKHHDBH;
    private javax.swing.JComboBox<String> jCBBKHLNK;
    private javax.swing.JComboBox<String> jCBBKHPXK;
    private javax.swing.JComboBox<String> jCBBKho;
    private javax.swing.JComboBox<String> jCBBMKHDBH;
    private javax.swing.JComboBox<String> jCBBMaKhoPXK;
    private javax.swing.JComboBox<String> jCBBNHHDBH;
    private javax.swing.JComboBox<String> jCBBTKCo;
    private javax.swing.JComboBox<String> jCBBTKCoHDBH;
    private javax.swing.JComboBox<String> jCBBTKCoNLK;
    private javax.swing.JComboBox<String> jCBBTKCoXK;
    private javax.swing.JComboBox<String> jCBBTKNo;
    private javax.swing.JComboBox<String> jCBBTKNoHDBH;
    private javax.swing.JComboBox<String> jCBBTKNoNLK;
    private javax.swing.JComboBox<String> jCBBTKNoXK;
    private javax.swing.JComboBox<String> jCBBTheoNLK;
    private javax.swing.JComboBox<String> jCBBTheoPNK;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox22;
    private javax.swing.JComboBox<String> jComboBox27;
    private javax.swing.JComboBox<String> jComboBox28;
    private javax.swing.JComboBox<String> jComboBox29;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField sumPNK;
    private javax.swing.JTextField sumPXK;
    private javax.swing.JTable tbHDBH;
    private javax.swing.JTable tbNLK;
    private javax.swing.JTable tbPNK;
    private javax.swing.JTable tbPXK;
    private javax.swing.JTextField thangNK4;
    private javax.swing.JTextField thangNK8;
    private javax.swing.JTextField thangNK9;
    private javax.swing.JTextField thueGTGTPNK;
    private javax.swing.JTextField txNguoiNhan2;
    private javax.swing.JTextField txtCTGPXK;
    private javax.swing.JTextField txtCongHDBH;
    private javax.swing.JTextField txtCongTHHDBH;
    private javax.swing.JTextField txtDiaChi4;
    private javax.swing.JTextField txtDiaChi5;
    private javax.swing.JTextField txtDiaChi6;
    private javax.swing.JTextField txtGTGTHDBH;
    private javax.swing.JTextField txtMaHDBH;
    private javax.swing.JTextField txtMaPNK;
    private javax.swing.JTextField txtMaPhieuXuat;
    private javax.swing.JTextField txtMonthPNK;
    private javax.swing.JTextField txtMonthPXK;
    private com.toedter.calendar.JDateChooser txtNgayChungTuHDBH;
    private javax.swing.JTextField txtNguoiMuaHDBH;
    private javax.swing.JTextField txtNguoiNhanPXK;
    private javax.swing.JTextField txtNoiDungHDBH;
    private javax.swing.JTextField txtTenNguoiGiaoPNK;
    private javax.swing.JTextField txtTomTatPNK;
    private javax.swing.JTextField txtTomTatPXK;
    private javax.swing.JTextField txtYearPNK;
    private javax.swing.JTextField txtYearPXK;
    private javax.swing.JTextField txtkemtheoCTG;
    private com.toedter.calendar.JDateChooser txtngayChungTu;
    private com.toedter.calendar.JDateChooser txtngayChungTu1;
    private com.toedter.calendar.JDateChooser txtngayChungTuPXK;
    // End of variables declaration//GEN-END:variables
}
