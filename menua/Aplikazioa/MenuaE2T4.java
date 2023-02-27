import java.io.File;
import java.util.Scanner;

public class MenuaE2T4 
{
   public static void main(String[] args) 
   {
	   Scanner sc=new Scanner (System.in);
	   boolean cerrar = login(sc);
	   if(!cerrar) 
       {
	      menu(sc);
	    } 
         else 
            {
	            System.out.println("Has intentado loginearte demasiadas veces, intentalo de nuevo mas tarde");
	         }
	 }
	
   public static void menu(Scanner sc) 
   {
	   int i=0;	
	   boolean itxi = false;
	   while(!itxi) 
      {
         System.out.println("--------------------------");
	      System.out.println(" OPCIONES: ");
	      System.out.println("	1- Erabiltzailea gehitu");
	      System.out.println("	2- XML-a sortu");
	      System.out.println("	3- Datu-baseak eguneratu");
	      System.out.println("	4- Datuak erakutsi");
	      System.out.println("	5- Irten");
         System.out.println("--------------------------");
	      i = sc.nextInt();
	      switch(i) 
         {
	         case 1:
	         break;
	         case 2:
	         break;
	         case 3:
	         menu_DatuBase(sc);
	         break;
	         case 4:
	         break;
	         case 5:
	         itxi = SaioaItxi(sc);
	         break;
	         default: 
	         System.out.println("Esa opcion no existe, pruebe con una existente");
	      }
	   }   
	     System.out.println("cerrando sesion");
	}
	
	public static void menu_DatuBase(Scanner sc) 
   {
	   int i;
	   boolean salir = false;
	   while(!salir) 
      {
         System.out.println("--------------------------");
	      System.out.println(" OPCIONES: ");
	      System.out.println("	1- Eremua gehitu");
	      System.out.println("	2- Taula eguneratu");
         System.out.println("	3- Datuak erakutsi");
	      System.out.println("	4- Atzera joan");
         System.out.println("--------------------------");
	      i = sc.nextInt();
	      switch(i) 
         {
	         case 1:
	         break;
	         case 2:
	         break;
            case 3:
	         break;
	         case 4:
	         salir = true;
	         break;
	         default: 
	         System.out.println("Esa opcion no existe, pruebe con una existente");
	      }
	   }
	}
	
	public static boolean SaioaItxi(Scanner sc) 
   {
	   boolean logout=false;
	   int i;
      System.out.println("--------------------------");
	   System.out.println(" Saioa ixi?");
	   System.out.println("	1- Bai");
	   System.out.println("	2- Ez");
      System.out.println("--------------------------");
	   i = sc.nextInt();
	   if(i==1) 
      {
	      logout = true;
	   }
         else
         {
	         if(i==2) 
            {
	            logout = false;
	         }
               else 
               {
	               System.out.println("Ez da ulertu zer egin nahi duzun");
	            }
	       }
	       return logout;
	}
	
	public static boolean login(Scanner sc) 
   {
	   String username,password;
	   boolean correcto = false, error = false;
	   int kontar=0;
	   while(!correcto && kontar!=4) 
      {
	      System.out.print("Username: ");
	      username = sc.next();
	      String [] datos = ComprobadorUsuario(username);
	      if(datos != null) 
         {
	         System.out.print("Password: ");
	         password = sc.next();
	         if(password.equals(datos[1])) 
            {
	            correcto = true;
	         }
               else 
               {
	               System.out.println("Contraseña incorrecta");
	               kontar++;
	            }
	       }
            else 
            {
	            System.out.println("No existe el usuario");
	            kontar++;
	         }
	      }
	if(kontar==4) 
   {
	   error = true;
	}
      else 
      {
	      System.out.println("Sesion iniciada");
         System.out.println("---------------");
	   }	
	   return error;
	  }
	
	public static String [] ComprobadorUsuario(String name) 
   {
	   File f = null;
	   Scanner sc = null;
	   String [] c = null;
	   try 
      {
	      f = new File("Erabiltzaileak.txt");
	      sc = new Scanner(f);
	   }
         catch(Exception e) 
         {
	         System.out.println("Error");
	      }
	   while(sc.hasNext()) 
      {
	      c = sc.nextLine().split(";");
	      if (c[0].equals(name)) 
         {
	         return c;
	      }
            else 
         {
	         c = null;
	      }
	   }
	sc.close();
	return c;
	}
}