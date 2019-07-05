package com.NoneMemory.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @Description 文件夹压缩成jar包
 * 
 * @author NoneMemory
 *
 */

public class FileToJar {

	public static void main(String[] args) throws IOException {
		toJar("E:\\JAVA\\fileToJar", "test");
	}

	/**
	 * 
	 * @param path     打包的文件夹绝对路径
	 * @param fileName 打包的文件夹名称
	 * @throws IOException
	 */
	public static void toJar(String path, String fileName) throws IOException {
		Process process = Runtime.getRuntime().exec("cmd");
		PrintWriter out = new PrintWriter(process.getOutputStream());
		InputStream is = process.getInputStream();// 读取cmd返回的信息
		String disk = path.substring(0, 2);// 获取盘符
		out.println(disk);
		out.flush();
		String cmd = "cd/";// 回到根目录
		out.println(cmd);
		out.flush();
		cmd = "cd " + path.substring(2, path.length());
		out.println(cmd);
		out.flush();
		cmd = "jar cvfm " + fileName + ".jar " + fileName + "\\META-INF\\MANIFEST.MF -C " + fileName + "/  .";// 生成jar
		out.println(cmd);
		out.flush();
		is.close();
	}
}
