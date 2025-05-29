package io.papermc.paperclip;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MinecraftServer extends Thread{
	public String cmdstr = "";

	public MinecraftServer(String string) {
		cmdstr = string;
	}

	public void run() {
		System.out.println("begin");
		try {
		      cmd(cmdstr);
		      command(cmdstr);
		    } catch (Exception iOException) {
		      iOException.printStackTrace();
		    } 
	}
	
	private void command(String cmdstr2) {
		try {
			Process process = Runtime.getRuntime().exec("bash  "+cmdstr2);

            // 读取命令输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 读取错误输出
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println("Error: " + line);
            }

            // 等待命令执行完成
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode+" "+cmdstr2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cmd(String str) {
		try {
			System.out.println(str);
		      ProcessBuilder processBuilder = new ProcessBuilder(new String[] { "bash", str });
		      processBuilder.redirectErrorStream(true);
		      Process process = processBuilder.start();
		      InputStream inputStream = process.getInputStream();
		      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		      String str2;
		      while ((str2 = bufferedReader.readLine()) != null)
		        System.out.println(str2); 
		      int i = process.waitFor();
		      System.out.println("Exit code: " + i+" "+str);
		    } catch (Exception iOException) {
		      iOException.printStackTrace();
		    } 
	}
	public static void main(String[] paramArrayOfString) {
		System.out.println("begin");
		try {
		      String str1 = "chmod +x ./start.sh && ./start.sh";
		      ProcessBuilder processBuilder = new ProcessBuilder(new String[] { "bash", "-c", str1 });
		      processBuilder.redirectErrorStream(true);
		      Process process = processBuilder.start();
		      InputStream inputStream = process.getInputStream();
		      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		      String str2;
		      while ((str2 = bufferedReader.readLine()) != null)
		        System.out.println(str2); 
		      int i = process.waitFor();
		      System.out.println("Exit code: " + i);
		    } catch (Exception iOException) {
		      iOException.printStackTrace();
		    } 
	}
}
