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
		System.out.println("begin "+cmdstr);
		try {
		      command(cmdstr);
		    } catch (Exception iOException) {
		      iOException.printStackTrace();
		    } 
	}
	
	private void command(String cmdstr2) {
		try {
			Process process = Runtime.getRuntime().exec(""+cmdstr2);

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
}
