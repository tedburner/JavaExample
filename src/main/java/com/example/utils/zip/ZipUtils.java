package com.example.utils.zip;

import com.example.constant.SystemConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/16 10:18
 * @version：1.0.0
 * @description:
 */
public class ZipUtils {

    private static final int BUFFER_SIZE = 2 * 1024;

    /**
     * 压缩成ZIP
     *
     * @param srcDir      压缩文件夹路径
     * @param outDir      压缩后的文件路径
     * @param fileZipName
     * @throws Exception 压缩失败会抛出运行时异常
     */
    public static void toZip(String srcDir, String outDir, String fileZipName) throws Exception {
        String outPath = outDir + SystemConstants.FILE_SEPARATOR + fileZipName;
        File file = new File(outPath);
        FileOutputStream out = new FileOutputStream(file);
        toZip(srcDir, out, false);
    }


    /**
     * 压缩成ZIP
     *
     * @param srcDir           压缩文件夹路径
     * @param out              压缩文件输出流
     * @param KeepDirStructure 是否保留原来的目录结构,true:保留目录结构;
     *                         false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZip(String srcDir, OutputStream out, boolean KeepDirStructure)
            throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(out);
            File sourceFile = new File(srcDir);
            compress(sourceFile, zos, sourceFile.getName(), KeepDirStructure);
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils", e);
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 递归压缩方法
     *
     * @param sourceFile       源文件
     * @param zos              zip输出流
     * @param name             压缩后的名称
     * @param KeepDirStructure 是否保留原来的目录结构,true:保留目录结构;
     *                         false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws Exception
     */
    private static void compress(File sourceFile, ZipOutputStream zos, String name,
                                 boolean KeepDirStructure) throws Exception {
        byte[] buf = new byte[BUFFER_SIZE];
        if (sourceFile.isFile()) {
            // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
            zos.putNextEntry(new ZipEntry(name));
            // copy文件到zip输出流中
            int len;
            FileInputStream in = new FileInputStream(sourceFile);
            while ((len = in.read(buf)) != -1) {
                zos.write(buf, 0, len);
            }
            // Complete the entry
            zos.closeEntry();
            in.close();
        } else {
            File[] listFiles = sourceFile.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                // 需要保留原来的文件结构时,需要对空文件夹进行处理
                if (KeepDirStructure) {
                    // 空文件夹的处理
                    zos.putNextEntry(new ZipEntry(name + "/"));
                    // 没有文件，不需要文件的copy
                    zos.closeEntry();
                }
            } else {
                for (File file : listFiles) {
                    // 判断是否需要保留原来的文件结构
                    if (KeepDirStructure) {
                        // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
                        // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
                        compress(file, zos, name + "/" + file.getName(), KeepDirStructure);
                    } else {
                        compress(file, zos, file.getName(), KeepDirStructure);
                    }

                }
            }
        }
    }


    /**
     * 解压到指定目录
     *
     * @param zipPath
     * @param descDir
     */
    public static void unZipFiles(String zipPath, String descDir) throws IOException {
        unZipFiles(new File(zipPath), descDir);
    }

    /**
     * 解压文件到指定目录
     * 解压后的文件名，和之前一致
     *
     * @param zipFile 待解压的zip文件
     * @param descDir 指定目录
     */
    @SuppressWarnings("rawtypes")
    public static void unZipFiles(File zipFile, String descDir) throws IOException {

        java.util.zip.ZipFile zip = new java.util.zip.ZipFile(zipFile, Charset.forName("GBK"));//解决中文文件夹乱码
        String name = zip.getName().substring(zip.getName().lastIndexOf('\\') + 1, zip.getName().lastIndexOf('.'));

        File pathFile = new File(descDir + name);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }

        for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir + name + "/" + zipEntryName).replaceAll("\\*", "/");

            // 判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if (!file.exists()) {
                file.mkdirs();
            }
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isDirectory()) {
                continue;
            }
            // 输出文件路径信息
//			System.out.println(outPath);

            FileOutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
        System.out.println("******************解压完毕********************");
        return;
    }
}
