package com.example.file;


import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: lingjun.jlj
 * @date: 2019-03-29 20:01
 * @description: https://blog.csdn.net/eye9093/article/details/77368703
 */
public class WordUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static String srcPath = "/Users/jianglingjun/doc.docx";
    private static String outPath = "/Users/jianglingjun/test.docx";

    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream(srcPath);
        //XWPFDocument xdf = new XWPFDocument(is);//新建一个word文档

        //读取变量
        Map<String, Object> params = new HashMap<>();
        params.put("name", "苏明哲");
        params.put("number", 27);

        //获取到文档
        XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(srcPath));
        //获取整个文本对象
        List<XWPFParagraph> allParagraph = document.getParagraphs();
        //获取整个表格对象
        List<XWPFTable> allTable = document.getTables();

        //获取XWPFRun对象输出整个文本内容
        StringBuffer tempText = new StringBuffer();
        for (XWPFParagraph xwpfParagraph : allParagraph) {
            List<XWPFRun> runList = xwpfParagraph.getRuns();
            for (XWPFRun xwpfRun : runList) {
                tempText.append(xwpfRun.toString());
            }
        }
        System.out.println(tempText.toString());

        //输出表格信息
        getWordTable(document);

    }

    public static void getWordTable(XWPFDocument document) {
        try {
            StringBuffer tableText = new StringBuffer();

            //获取全部表格对象
            List<XWPFTable> allTable = document.getTables();

            for (XWPFTable xwpfTable : allTable) {
                //获取表格行数据
                List<XWPFTableRow> rows = xwpfTable.getRows();
                for (XWPFTableRow xwpfTableRow : rows) {
                    //获取表格单元格数据
                    List<XWPFTableCell> cells = xwpfTableRow.getTableCells();
                    for (XWPFTableCell xwpfTableCell : cells) {
                        List<XWPFParagraph> paragraphs = xwpfTableCell.getParagraphs();
                        for (XWPFParagraph xwpfParagraph : paragraphs) {
                            List<XWPFRun> runs = xwpfParagraph.getRuns();
                            for (int i = 0; i < runs.size(); i++) {
                                XWPFRun run = runs.get(i);
                                tableText.append(run.toString());
                            }
                        }
                    }
                }
            }
            System.out.println(tableText.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Word 替换文字
     *
     * @param document Word数据
     * @param outputUrl 模板保存路径
     */
    public static void replaceText(XWPFDocument document, String outputUrl) {

        try {
            //获取段落文本对象
            List<XWPFParagraph> paragraph = document.getParagraphs();
            //获取首行run对象
            XWPFRun run = paragraph.get(0).getRuns().get(0);
            //设置文本内容
            run.setText("修改了的word");
            //生成新的word
            File file = new File(outputUrl);

            FileOutputStream stream = new FileOutputStream(file);
            document.write(stream);
            stream.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * 替换文档中的参数（word）
     *
     * @param doc
     * @param params
     */
    private void replaceText(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            //this.replaceInPara(para, params);
        }
    }

    /**
     * 替换段落中的参数（word）
     *
     * @param para
     * @param params
     */
    private void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs;
        Matcher matcher;
        if (matcher(para.getParagraphText()).find()) {
            runs = para.getRuns();
            for (int i = 0; i < runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                matcher = matcher(runText);
                if (matcher.find()) {
                    while ((matcher = matcher(runText)).find()) {
                        runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                    }
                    para.removeRun(i);
                    //重新插入run里内容格式可能与原来模板的格式不一致
                    para.insertNewRun(i).setText(runText);
                }
            }
        }
    }

    /**
     * 正则匹配字符串
     *
     * @param str
     * @return
     */
    private Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }


}
