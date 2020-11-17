package com.TF.Util;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class makeHtml {
    /**
     * 读取Excel文件
     * @param filePath 文件路径
     * @throws BiffException
     * @throws IOException
     */
     public static String readExcel(String filePath) throws BiffException, IOException {

        File excelFile = new File(filePath);
        Workbook wb = Workbook.getWorkbook(excelFile);
        Sheet s = wb.getSheet(1); // 只做了一个Sheet的, 如果想全部遍历, 只需要套入循环内即可
        Range[] rs = s.getMergedCells(); // 得到当前Sheet里面合并的单元格个数
        List<Range> listRange = new ArrayList<Range>(); // 换一个方式存储合并的单元格
        List<Range> listRange2 = new ArrayList<Range>(); // 存储用过的合并单元格
        // 赋值
        for (Range r : rs)
            listRange.add(r);
        String string = "<table border=\"1\" cellspacing=\"0\" style=\"text-align: center;\">";
        for (int i = 0; i < s.getRows(); i++) {
            string += "\r\n<tr>";
            Cell[] cs = s.getRow(i);
            for (int j = 0; j < cs.length; j++) {
                Cell c = cs[j];
                boolean b = true; // 表示是否是合并的单元格
                boolean bool = true; // 表示是否已经判断过了
            // 判断是否已经用完了合并的单元格, 为用完则循环判断
                if(listRange2.size() < listRange.size()) {
                // 判断是否已经用过合并的单元格了, 即对bool进行赋值
                    for (Range range : listRange2) {
                        Cell tlCell = range.getTopLeft();
                        Cell blCell = range.getBottomRight();
                        int c1 = c.getColumn(), c2 = tlCell.getColumn(), c3 = blCell
                                .getColumn();
                        int r1 = c.getRow(), r2 = tlCell.getRow(), r3 = blCell
                                .getRow();
                        if (c1 >= c2 && c1 <= c3 && r1 >= r2 && r1 <= r3)
                            bool = false;
                    }
                    if (bool) {
                        for (Range range : listRange) {
                            Cell tlCell = range.getTopLeft();
                            Cell blCell = range.getBottomRight();
                            int c1 = c.getColumn(), c2 = tlCell.getColumn(), c3 = blCell
                                    .getColumn();
                            int r1 = c.getRow(), r2 = tlCell.getRow(), r3 = blCell
                                    .getRow();
                            // 判断是否是合并的单元格
                            if (c1 >= c2 && c1 <= c3 && r1 >= r2 && r1 <= r3) {
                                string += "\t\t<td rowspan=\"" + (r3 - r2 + 1)
                                        + "\" colspan=\"" + (c3 - c2 + 1)
                                        + "\">\t"
                                        + c.getContents().replaceAll("\n", "")
                                        + "\r\n</td>";
                                j += (c3 - c2);
                                b = false;
                                listRange2.add(range);
                            }
                        }
                    }
                }
                if (b && bool) {
                    string += "<td>"
                            + c.getContents().replaceAll("\n", "")
                            + "</td>";
                }
            }
            string += "</tr>";
        }
        string += "\r\n</table>";
        return string;
//        PrintWriter pw = new PrintWriter("D:/坑人凡/test.html");
//        pw.println(string);
//        pw.flush();
//        pw.close();
//        System.out.println(string);
    }

}
