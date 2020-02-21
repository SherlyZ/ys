package archivoapp1;
import java.io.*;
import java.util.Scanner;

class Fileapp{
    String filename;
    String filetextin;
    public Fileapp(String name, String texta){
        this.filename=name;
        this.filetextin=texta;
    }
    void create_file(){
        //Creat un fitxer amb el nom que has teclat
        try{
            File fichero = new File(this.filename);
            if(fichero.createNewFile()){
                System.out.println("File created: "+fichero.getName());
            }else{
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            System.out.println("Error:");
            e.printStackTrace();
        }
    }
    
    void write_in_file(){
        //Leer lineas de texto por teclado y escribirlas en un fichero de texto.
        try{
            FileWriter writeIn = new FileWriter(this.filename,true);
            writeIn.write(this.filetextin);
            writeIn.close();
            System.out.println("Successfully wrote to the file.");
        }catch(IOException e){
            System.out.println("Error:");
            e.printStackTrace();
        }
    }
    
    void showLine_in_file(){
        //Leer lineas de texto por teclado y escribirlas en un fichero de texto.
        try{
            BufferedReader showIn = new BufferedReader(new FileReader(this.filename));
            String sLine;
            System.out.println("The text in the file(line by line):");
            while((sLine = showIn.readLine()) != null ){
                System.out.println(sLine);
            }            
        }catch(IOException e){
            System.out.println("Error:");
            e.printStackTrace();
        }
    }
    
    void showChar_in_file(){
        //Leer lineas de texto por teclado y escribirlas en un fichero de texto.
        try{
            BufferedReader showIn = new BufferedReader(new FileReader(this.filename));
            int num;
            char sChar;
            System.out.println("The text in the file(Character by character ):");
            while((num = showIn.read()) != -1 ){
                sChar = (char)num;
                System.out.println(sChar);
            }            
        }catch(IOException e){
            System.out.println("Error:");
            e.printStackTrace();
        }
    }

}


public class ArchivoApp1 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Escribe el nom del fitxer
        System.out.println("Write a nom for file: ");
        String extension = sc.nextLine();
        // Escribe el text del fitxer
        System.out.println("Write a text: ");
        String textinici = sc.nextLine();
        
        
        Fileapp newfile=new Fileapp(extension,textinici);
        newfile.create_file();
        newfile.write_in_file();
        newfile.showLine_in_file();
        newfile.showChar_in_file();
    }
    
}
