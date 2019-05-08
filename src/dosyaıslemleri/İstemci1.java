package dosyaıslemleri;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class İstemci1 {
        File f = new File("C:\\Users\\Hasan\\Desktop\\Dosya\\sunucu1.txt");
        
        DataInputStream input = null;
        Scanner scn = null;
        PrintStream output = null;
        
        public void calis(){
        try{                   //file or input stream
            input = new DataInputStream(new FileInputStream("C:\\Users\\Hasan\\Desktop\\Dosya\\sunucu2.txt"));
            scn = new Scanner(System.in);//output stream
            output = new PrintStream(f);
        }catch(IOException ex){
            System.out.println("dosyaıslemleri.İstemci1.main()");
        }
        }
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String gelenmesaj=null;
        
            while(true){
                try {
                    gelenmesaj = input.readLine();
                } catch (IOException ex) {
                    System.out.println("dosyaıslemleri.İstemsadfasdci1.main()");
                }
                if(gelenmesaj != null){
                    System.out.println("Gelen Mesaj:"+gelenmesaj);
                }
            }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
            while(true){
                String gidenMesaj= null;
                gidenMesaj = scn.nextLine();
                output.println(gidenMesaj);
                output.flush();
                System.out.println("Giden Mesaj:"+gidenMesaj);
                
                 if(gidenMesaj == "1"){
                     scn.close();
                    try {
                        output.close(); 
                        input.close();
                    } catch (IOException ex) {
                        Logger.getLogger(İstemci1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
            }
            
            }
            
        });
        
        public static void main(String[] args) {
            İstemci1 i = new İstemci1();
            i.calis();
            i.t1.start();
            i.t2.start();
            
            
        }

}
