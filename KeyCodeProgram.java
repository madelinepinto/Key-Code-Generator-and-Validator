import java.util.Scanner;
import java.lang.Math;
import java.util.*;

/*******************************************************************************
  * @Author: Madeline Pinto       @Date: May 14 2021
  * 
  * The purpose of this program is to create a software object whose sole purpose
  * is to either generate or valid keycodes for this new game.
  * ****************************************************************************/

class KeyCodeProgram{
  public static void main(String[]arg){
    Scanner userIn = new Scanner(System.in);
    int x;
    do{
    KeyCodeGeneratorMadeline obj1 = new KeyCodeGeneratorMadeline();
    System.out.println("MENU----Select One----\n"+
                       "1. Generate a Key Code:\n"+
                       "2. Verify a Key Code:\n"+
                       "0. Exit Program\n"+
                       "--------------------------");
       while(!userIn.hasNextInt())
       { userIn.next();}  
   x = userIn.nextInt();  
   if(x==0)
   {System.out.println("Good-Bye");}
   else{
   while (x>2||x<0)
  {
   System.out.printf("%d is not an option, please select either 0, 1 or 2\n",x);
   System.out.println("MENU----Select One----\n"+
                       "1. Generate a Key Code:\n"+
                       "2. Verify a Key Code:\n"+
                       "0. Exit Program\n"+
                       "--------------------------");
   while(!userIn.hasNextInt())
       { userIn.next();}  
   x = userIn.nextInt();  
   if(x==0)
   {System.out.println("Good-Bye");}
   }
   if (x==1){
     obj1.generateKeyCode();
   }
   if (x==2){
     obj1.validateKeyCode();  
     
    }
  }
}
    while(x!=0);
  }
}

/*******************************************************************************
  * @Author: Madeline Pinto       @Date: May 14 2021
  * 
  * This class will handle everything regarding creating and validating the keycode.
  * ****************************************************************************/
class KeyCodeGeneratorMadeline{
  private String keyCode;
  KeyCodeGeneratorMadeline(){keyCode=null;}
  //get/set methods
  public void setKeyCode(String keyCode) {this.keyCode= keyCode;}
  public String getKeyCode(){return keyCode;}
/*******************************************************************************
  * @Author: Madeline Pinto       @Date: May 14 2021
  * 
  * This method generates a valid keyCode, following a specific set of rules given.
  * @param: none   @return: void
  * ****************************************************************************/
  public void generateKeyCode(){
    keyCode="";
    System.out.print("KEYCODE GENERATED: ");
  
    String output = "";
    for (int h=0; h<3; h++){
    int[]keyCode = new int[6];
    keyCode[1] = (int)(Math.random()*(10));
    keyCode[0]=9-keyCode[1];
    
    keyCode[3] = (int)(Math.random()*(10));
    keyCode[2]=9-keyCode[3];
    
    keyCode[5] = (int)(Math.random()*(10));
    keyCode[4]=9-keyCode[5];
    
  
    for(int z= 0; z<6; z++){
    output+= keyCode[z];
    }
    output+= "-";
    }
    //
    System.out.println(output.substring(0,output.length()-1));
   
  }
  /*******************************************************************************
  * @Author: Madeline Pinto       @Date: May 14 2021
  * 
  * This method returns true or false depending if an entered keyCode is VALID or INVALID.
  * @param: none   @return: boolean
  * ****************************************************************************/
  public boolean validateKeyCode(){
    Scanner in = new Scanner(System.in);
    String input;
    System.out.println("Please enter KeyCode to be tested:");
    input =  in.nextLine();
    System.out.println(input);
    if(input.length()!=20){
      System.out.println("The KeyCode entered is INVALID");
      return false;
    }    
    int[]code=new int[input.length()];
    try{
      for(int i = 0; i<code.length;i++){
        
        code[i]=((int) input.charAt(i)) - 48;
        if (i==6||i==13){
          if(code[i]==-3){
            continue;}
          else{
            System.out.println("The KeyCode entered is INVALID");
      
    return false;
          }        
        }
      }
        for(int a=0; a<6; a++){
          for (int b = 1; b<7;b+=2, a+=2){
          if(code[a]+code[a+1]!=9){
            System.out.println("The KeyCode entered is INVALID");
      
    return false;
  }
          
          
        }
        }
        for(int a=7; a<13; a++){
          for (int b = 8; b<14;b+=2, a+=2){
          if(code[a]+code[b]!=9){
            System.out.println("The KeyCode entered is INVALID");
      
    return false;
  } 
        }
        }
        for(int a=14; a<20; a++){
          for (int b = 15; b<21;b+=2, a+=2){
          if(code[a]+code[b]!=9){
            System.out.println("The KeyCode entered is INVALID");
      
    return false;
          }else{
            continue;
          }
        }System.out.println("The KeyCode entered is VALID");
            return true;
        }
        
    }
    catch(Exception error){
      System.out.println("The KeyCode entered is INVALID");
      
    return false;
  }
    return true;
  }
}
  