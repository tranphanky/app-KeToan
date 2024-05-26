/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KhoDAO;
import dao.PhieuNhapKhoDAO;
import dao.PhieuXuatKhoDAO;
import dao.TBPNKDAO;
import dao.TBPXKDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Kho;
import model.PhieuNhapKho;
import model.TBPNK;
import model.PhieuXuatKho;
import model.TBPXK;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author PC
 */
public class WordReplaceFiled {

    public static int setValueTablePNK(PhieuNhapKho pnk, ArrayList<TBPNK> listTB, String tenFile) throws FileNotFoundException, IOException {

        int result = 1;
        FileInputStream fis = new FileInputStream(new File("MauPhieu133/PhieuNhapKho.docx"));
        try (XWPFDocument document = new XWPFDocument(fis)) {
            Kho k = KhoDAO.getInstance().selectById(pnk.getMaKho());

            for (XWPFParagraph p : document.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {

                        String text = r.getText(0);
                        if (text != null && text.contains("hoVaTen")) {
                            text = text.replace("hoVaTen", pnk.getTenNguoiGiao());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("kho?")) {
                            text = text.replace("kho?", k.getTenKho());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("diadiem?")) {
                            text = text.replace("diadiem?", k.getDiaDiem());
                            r.setText(text, 0);
                        }
                        long cong = (int) Math.round(pnk.getCong());
                        if (text != null && text.contains("sumString")) {
                            text = text.replace("sumString", ConvertToVNDString.num2String(cong) + " đồng");
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("soChungTu")) {
                            text = text.replace("soChungTu", pnk.getKemtheoCTG());
                            r.setText(text, 0);
                        }
                    }
                }
            }
            XWPFTable tb0 = document.getTables().get(0);
            for (XWPFTableRow row : tb0.getRows()) {
                // Duyệt qua tất cả các ô trong từng hàng
                for (XWPFTableCell cell : row.getTableCells()) {
                    // Duyệt qua tất cả các đoạn văn bản trong mỗi ô
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        // Duyệt qua tất cả các đoạn văn bản
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains("donVi")) {
                                text = text.replace("donVi", "Công TY TNHH TM XD ĐẠT THIÊN");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("boPhan")) {
                                text = text.replace("boPhan", "Nhân viên");
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }

            LocalDate datePNK = pnk.getNgayChungTu().toLocalDate();
            int day = datePNK.getDayOfMonth();
            int month = datePNK.getMonthValue();
            int year = datePNK.getYear();
            XWPFTable tb1 = document.getTables().get(1);
            for (XWPFTableRow row : tb1.getRows()) {
                // Duyệt qua tất cả các ô trong từng hàng
                for (XWPFTableCell cell : row.getTableCells()) {
                    // Duyệt qua tất cả các đoạn văn bản trong mỗi ô
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        // Duyệt qua tất cả các đoạn văn bản
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains("ngayPNK")) {
                                text = text.replace("ngayPNK", day + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("maPNK")) {
                                text = text.replace("maPNK", pnk.getMaPNK());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("thangPNK")) {
                                text = text.replace("thangPNK", month + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("namPNK")) {
                                text = text.replace("namPNK", year + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("namPNK")) {
                                text = text.replace("namPNK", year + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("tkNo")) {
                                text = text.replace("tkNo", pnk.getTkNo());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("tkCo")) {
                                text = text.replace("tkCo", pnk.getTkCo());
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }

            XWPFTable tb2 = document.getTables().get(2);
            listTB = TBPNKDAO.getInstance().selectAllNoMaPNK(pnk.getMaPNK());
            int indexRow = 3;
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            int stt = 1;
            for (TBPNK tbpnk : listTB) {
                XWPFTableRow newRow = tb2.insertNewTableRow(indexRow);

                String tenHH = tbpnk.getTenHangHoa();
                String maSo = tbpnk.getMaSo();
                String donViTinh = tbpnk.getDonViTinh();
                int soLuongTheoChungTu = tbpnk.getSoLuongTheoChungTu();
                int soLuongThucNhap = tbpnk.getSoLuongThucNhap();
                int donGia = tbpnk.getDonGia();
                int thanhTien = tbpnk.getThanhTien();

                String strDG = currencyVN.format(donGia);
                String strTT = currencyVN.format(thanhTien);
                String[] arrayString = new String[]{stt + "", tenHH, maSo, donViTinh, soLuongTheoChungTu + "", soLuongThucNhap + "", strDG, strTT};
                int count = 0;
                for (String cellValue : arrayString) {
                    XWPFTableCell cell = newRow.createCell(); // Tạo cell mới
                    XWPFParagraph paragraph = cell.addParagraph();
                    XWPFRun run = paragraph.createRun();
                    run.setFontFamily("Times New Roman");
                    run.setText(cellValue);
                    count++;
                }
                indexRow++;
                stt++;
            }

            String strSum = currencyVN.format(pnk.getCong());
            for (XWPFTableRow row : tb2.getRows()) {
                // Duyệt qua tất cả các ô trong từng hàng
                for (XWPFTableCell cell : row.getTableCells()) {
                    // Duyệt qua tất cả các đoạn văn bản trong mỗi ô
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        // Duyệt qua tất cả các đoạn văn bản
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains("sum")) {
                                text = text.replace("sum", strSum + "");
                                r.setText(text, 0);
                            }

                        }
                    }
                }
            }

            XWPFTable tb3 = document.getTables().get(3);
            for (XWPFTableRow row : tb3.getRows()) {
                // Duyệt qua tất cả các ô trong từng hàng
                for (XWPFTableCell cell : row.getTableCells()) {
                    // Duyệt qua tất cả các đoạn văn bản trong mỗi ô
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        // Duyệt qua tất cả các đoạn văn bản
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains("ngayPNK")) {
                                text = text.replace("ngayPNK", day + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("thangPNK")) {
                                text = text.replace("thangPNK", month + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("namPNK")) {
                                text = text.replace("namPNK", year + "");
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }

            try (FileOutputStream out = new FileOutputStream(new File("SaveFile\\PhieuNhapKho\\" + tenFile.trim() + ".docx"))) {

                document.write(out);
            } catch (IOException e) {
                e.printStackTrace();
                result = 0;
            }
            // document.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        // fis.close();
        return result;

    }

    public static int setValueTablePXK(PhieuXuatKho pxk, ArrayList<TBPXK> listTB, String tenFile) throws FileNotFoundException, IOException {

        int result = 1;
        FileInputStream fis = new FileInputStream(new File("MauPhieu133/PhieuXuatKho.docx"));
        try (XWPFDocument document = new XWPFDocument(fis)) {
            Kho k = KhoDAO.getInstance().selectById(pxk.getMaSoKho());

            for (XWPFParagraph p : document.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {

                        String text = r.getText(0);
                        if (text != null && text.contains("hoVaTen")) {
                            text = text.replace("hoVaTen", pxk.getTenNguoiNhan());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("tomTat")) {
                            text = text.replace("tomTat", pxk.getTomTat());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("boPhan")) {
                            text = text.replace("boPhan", "Nhân viên");
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("kho?")) {
                            text = text.replace("kho?", k.getTenKho());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("diaDiem?")) {
                            text = text.replace("diaDiem?", k.getDiaDiem());
                            r.setText(text, 0);
                        }
                        long cong = (int) Math.round(pxk.getCong());
                        if (text != null && text.contains("sumString")) {
                            text = text.replace("sumString", ConvertToVNDString.num2String(cong) + " đồng");
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("soChungTu")) {
                            text = text.replace("soChungTu", pxk.getKemtheoCTG());
                            r.setText(text, 0);
                        }
                    }
                }
            }
            XWPFTable tb0 = document.getTables().get(0);
            for (XWPFTableRow row : tb0.getRows()) {
                // Duyệt qua tất cả các ô trong từng hàng
                for (XWPFTableCell cell : row.getTableCells()) {
                    // Duyệt qua tất cả các đoạn văn bản trong mỗi ô
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        // Duyệt qua tất cả các đoạn văn bản
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains("donVi")) {
                                text = text.replace("donVi", "Công TY TNHH TM XD ĐẠT THIÊN");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("boPhan")) {
                                text = text.replace("boPhan", "Nhân viên");
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }

            LocalDate datePXK = pxk.getNgayChungTu().toLocalDate();
            int day = datePXK.getDayOfMonth();
            int month = datePXK.getMonthValue();
            int year = datePXK.getYear();
            XWPFTable tb1 = document.getTables().get(1);
            for (XWPFTableRow row : tb1.getRows()) {
                // Duyệt qua tất cả các ô trong từng hàng
                for (XWPFTableCell cell : row.getTableCells()) {
                    // Duyệt qua tất cả các đoạn văn bản trong mỗi ô
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        // Duyệt qua tất cả các đoạn văn bản
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains("ngayPXK")) {
                                text = text.replace("ngayPXK", day + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("maPXK")) {
                                text = text.replace("maPXK", pxk.getMaPXK());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("thangPXK")) {
                                text = text.replace("thangPXK", month + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("namPXK")) {
                                text = text.replace("namPXK", year + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("namPXK")) {
                                text = text.replace("namPXK", year + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("tkNo")) {
                                text = text.replace("tkNo", pxk.getTkNo());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("tkCo")) {
                                text = text.replace("tkCo", pxk.getTkCo());
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }

            XWPFTable tb2 = document.getTables().get(2);
            listTB = TBPXKDAO.getInstance().selectAllNoMaPXK(pxk.getMaPXK());
            int indexRow = 3;
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            int stt = 1;
            for (TBPXK tbpxk : listTB) {
                XWPFTableRow newRow = tb2.insertNewTableRow(indexRow);

                String tenHH = tbpxk.getTenHangHoa();
                String maSo = tbpxk.getMaSo();
                String donViTinh = tbpxk.getDonViTinh();
                int soLuongYeuCau = tbpxk.getSoLuongYeuCau();
                int soLuongThucNhap = tbpxk.getSoLuongThucNhap();
                int donGia = tbpxk.getDonGia();
                int thanhTien = tbpxk.getThanhTien();

                String strDG = currencyVN.format(donGia);
                String strTT = currencyVN.format(thanhTien);
                String[] arrayString = new String[]{stt + "", tenHH, maSo, donViTinh, soLuongYeuCau + "", soLuongThucNhap + "", strDG, strTT};
                int count = 0;
                for (String cellValue : arrayString) {
                    XWPFTableCell cell = newRow.createCell(); // Tạo cell mới
                    XWPFParagraph paragraph = cell.addParagraph();
                    XWPFRun run = paragraph.createRun();
                    run.setFontFamily("Times New Roman");
                    run.setText(cellValue);
                    count++;
                }
                indexRow++;
                stt++;
            }

            String strSum = currencyVN.format(pxk.getCong());
            for (XWPFTableRow row : tb2.getRows()) {
                // Duyệt qua tất cả các ô trong từng hàng
                for (XWPFTableCell cell : row.getTableCells()) {
                    // Duyệt qua tất cả các đoạn văn bản trong mỗi ô
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        // Duyệt qua tất cả các đoạn văn bản
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains("sum")) {
                                text = text.replace("sum", strSum + "");
                                r.setText(text, 0);
                            }

                        }
                    }
                }
            }

            XWPFTable tb3 = document.getTables().get(3);
            for (XWPFTableRow row : tb3.getRows()) {
                // Duyệt qua tất cả các ô trong từng hàng
                for (XWPFTableCell cell : row.getTableCells()) {
                    // Duyệt qua tất cả các đoạn văn bản trong mỗi ô
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        // Duyệt qua tất cả các đoạn văn bản
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains("ngayPXK")) {
                                text = text.replace("ngayPXK", day + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("thangPXK")) {
                                text = text.replace("thangPXK", month + "");
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("namPXK")) {
                                text = text.replace("namPXK", year + "");
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }

            try (FileOutputStream out = new FileOutputStream(new File("SaveFile\\PhieuXuatKho\\" + tenFile.trim() + ".docx"))) {

                document.write(out);
            } catch (IOException e) {
                e.printStackTrace();
                result = 0;
            }
            // document.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        // fis.close();
        return result;

    }

    public static void main(String[] args) {
        String maPXK = "2";
        PhieuXuatKho p = PhieuXuatKhoDAO.getInstance().selectById(maPXK);
        //System.out.println(p);
        ArrayList<TBPXK> listTB = TBPXKDAO.getInstance().selectAllNoMaPXK(maPXK);
        System.out.println(listTB);
        try {
            int kq = setValueTablePXK(p, listTB, maPXK);
            System.out.println(kq);
        } catch (IOException ex) {
            Logger.getLogger(WordReplaceFiled.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
