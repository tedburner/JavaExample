package com.example.utils.file;

import com.alibaba.excel.EasyExcel;
import com.example.utils.file.param.DemoData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/2 10:29
 * @description: 使用阿里 easy excel 导出表格数据
 */
public class EasyExcelUtils {

    public static void main(String[] args) {

    }

    public static void simpleWrite() {
        List<DemoData> data = new ArrayList<>();
        String fileName = "文件路径" + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(data);

    }
}
