/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.company.mentrappy;

/**
 *
 * @author ProBook
 */
import java.util.*;
import Email.GmailSender;
import info.Saveinfo;
public class MentRappy 
{
    public static void main(String[] args) 
    {
        String usercontrol = "1";
        while(usercontrol.equals("1"))
        {
            Scanner scanner = new Scanner(System.in);
            String siteName = "MentRappy";
            System.out.println(String.format("%20s", siteName));
            System.out.println("Welcome To The Mental Therapy Platform");
            System.out.println("Enter\n 1: About Us\n 2: Contact Us\n 3: Login\n 4: Register");
            String input = scanner.next();
            while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4"))
            {
                System.out.println("Invalid Input");
                System.out.println("Enter\n 1: About Us\n 2: Contact Us\n 3: Login\n 4: Register");
                input = scanner.next();
            }
            if (input.equals("1"))
            {
                aboutUs();
            }
            else if (input.equals("2"))
            {
                contactUs();
            }
            else if (input.equals("3"))
            {
                login();
            }
            else if (input.equals("4"))
            {
                register();
            }
        }
        
    }
    public static void user()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: \n 1: Go Back to Home\n 2: Exit");
        String usercontrol = scanner.next();
    }
    public static boolean checkName(String name)
    {
        boolean alphacheck;
        boolean check = true;
        if (name.trim().isEmpty())
        {
            check = true;
        }
        else
        {
            name = name.trim();
            name = name.replace(" ", "");
            alphacheck = name.matches("[a-zA-Z]+");
            if(alphacheck)
            {
                check = false;
            }
        }
        return check;
    }
    public static void outputName(String name)
    {
        Scanner scanner = new Scanner(System.in);
        while(checkName(name))
        {
            if (name.trim().isEmpty())
            {
                System.out.println("Input does not Empty");
                System.out.println("Enter Your Name: ");
                name = scanner.next();
            }
            else
            {
                System.out.println("Enter Your Name (name does not consist Digits and Special Charactors) : ");
                name = scanner.next();
            }
        }
    }
    public static boolean checkEmail(String email)
    {
        boolean check = true;
        if (!email.trim().isEmpty() && email.contains("@") && email.endsWith(".com") && !email.contains(" "))
        {
            check = false;
        }
        return check;
    }
    public static void outputEmail(String email)
    {
        while(checkEmail(email))
        {
            Scanner scanner = new Scanner(System.in);
            if (email.isEmpty())
            {
                System.out.println("Input does not Empty");
                System.out.println("Enter Your E-mail: ");
                email = scanner.next();
            }
            else
            {
                System.out.println("Invalid E-mail");
                System.out.println("Enter A Correct E-mail: ");
                email = scanner.next();
            }
        }
    }
    public static boolean registeruserCheck(String text, String location)
    {
        Saveinfo saveinfo = new Saveinfo();
        boolean check = true;
        ArrayList<String> emaillist = new ArrayList<String>();
        emaillist = saveinfo.readinfo(emaillist,location);
        if (emaillist.contains(text))
        {
            check = true;
        }
        else
        {
            check = false;
        }
        return check;
    }
    public static boolean loginpass(String email, String password, String emaillocation, String passlocation)
    {
        boolean check = true;
        Saveinfo saveinfo = new Saveinfo();
        ArrayList<String> emaillist = new ArrayList<String>();
        ArrayList<String> passlist = new ArrayList<String>();
        emaillist = saveinfo.readinfo(emaillist,emaillocation);
        passlist = saveinfo.readinfo(passlist,passlocation);
        int emailindex = emaillist.indexOf(email);
        int passindex = passlist.indexOf(password);
        if (emailindex==passindex)
        {
            check = false;
        }  
        return check;
    }
    public static boolean checkSubject(String subject)
    {
        boolean check = true;
        if (!subject.trim().isEmpty())
        {
            check = false;
        }
        return check;
    }
    public static void checkPass(String pass)
    {
        boolean check = true;
        do
        {
            if (pass.length() < 8) 
            {
                System.out.println("Password must be at least 8 characters long.");
            } 
            else 
            {
                int numericCount = 0;
                for (int i = 0; i < pass.length(); i++) 
                {
                    if (Character.isDigit(pass.charAt(i))) 
                    {
                        numericCount++;
                    }
                }
                if (numericCount < 2) 
                {
                    System.out.println("Password must contain at least 2 numeric values.");
                } 
                else 
                {
                    check = false;
                }
            }
        }while (check && pass.trim().isEmpty());       
    }
    public static void aboutUs()
    {
        System.out.println("We are a team of licensed therapists offering mental therapy services for individuals,\n couples, families, and groups. Our therapy services cover areas such as anxiety, depression,\n trauma, grief, relationship issues, and more. We use evidence-based therapies like CBT, DBT,\n and ACT to address the mind, body, and spirit. Our goal is to empower our clients to take\n charge of their mental health and develop coping skills to manage life's challenges. We\n provide a non-judgmental and compassionate environment where you can feel heard,\n understood, and supported. Contact us to schedule an appointment.");
        user();
    }
    public static void contactUs()
    {
        Scanner scanner = new Scanner(System.in);
        GmailSender gmailsender = new GmailSender();
        String name,email,subject,text;
        System.out.println("Enter Your Name: ");
        name = scanner.nextLine();
        outputName(name);
        System.out.println("Enter Your E-mail: ");
        email = scanner.nextLine().toLowerCase();
        outputEmail(email);
        System.out.println("Enter Your Subject: ");
        subject = scanner.nextLine();
        while(checkSubject(subject))
        {
            System.out.println("Input does not Empty");
            System.out.println("Enter Your Subject: ");
            subject = scanner.next();
        }
        System.out.println("Enter Your Message: ");
        text = scanner.nextLine();
        while(checkSubject(text))
        {
            System.out.println("Input does not Empty");
            System.out.println("Enter Your Message: ");
            text = scanner.nextLine(); 
        }
        text = name+"\n"+email+"\n"+text;
        String to = System.getenv().getOrDefault("MENTRAPPY_SUPPORT_RECIPIENT", "");
        String from = System.getenv().getOrDefault("MENTRAPPY_GMAIL_USERNAME", "");
        boolean send = gmailsender.sendEmail(to, from, subject, text);
        if (send)
        {
            System.out.println("E-mail is Sent Successfully");
        }
        else
        {
            System.out.println("There is some Error Please Try Again After Some Time");
        }
        System.out.println("Thank you for contacting us, We respond you in a while");
        user();
    }
    public static void register()
    {
        Scanner scanner = new Scanner(System.in);
        String type;
        do
        {
        System.out.println("Choose your Account Type: \n 1: As A Patient\n 2: As A Doctor");
        type = scanner.next();
        }while(!type.equals("1") && !type.equals("2"));
        if (type.equals("1"))
        {
            patientRegister();
        }
        else
        {
            doctorRegister();
        }
    }
    public static void patientRegister()
    {
        Saveinfo saveinfo = new Saveinfo();
        ArrayList<String> namelist = new ArrayList<String>();
        ArrayList<String> emaillist = new ArrayList<String>();
        ArrayList<String> passlist = new ArrayList<String>();
        ArrayList<String> idlist = new ArrayList<String>();
        namelist = saveinfo.readinfo(namelist,"D://study/Project/Data/Patient/name.txt");
        emaillist = saveinfo.readinfo(emaillist,"D://study/Project/Data/Patient/email.txt");
        passlist = saveinfo.readinfo(passlist,"D://study/Project/Data/Patient/password.txt");
        idlist = saveinfo.readinfo(idlist,"D://study/Project/Data/Patient/id.txt");
        Scanner scanner = new Scanner(System.in);
        String name, email, pass1, pass2, idNumber, from, codestr, usercode;
        int code;
        String countlocation = "D://study/Project/Data/Patient/count.txt";
        String countstr = Saveinfo.readinfo(countlocation);
        int countint = Integer.parseInt(countstr);
        System.out.println("Enter Your Name: ");
        name = scanner.nextLine();
        outputName(name);
        System.out.println("Enter Your E-mail: ");
        email = scanner.nextLine().toLowerCase();
        outputEmail(email);
        while(registeruserCheck(email,"D://study/Project/Data/Patient/email.txt"))
        {
            System.out.println("This E-mail is Already Register");
            System.out.println("Enter Another E-mail: ");
            email = scanner.nextLine().toLowerCase();
            outputEmail(email);
        }
        System.out.println("Enter Your Password: ");
        pass1 = scanner.nextLine();
        checkPass(pass1);
        System.out.println("Enter Your Password Again: ");
        pass2 = scanner.nextLine();
        while (!pass1.equals(pass2))
        {
            System.out.println("Both Password are not Match");
            System.out.println("First time, Enter Your Password : ");
            pass1 = scanner.nextLine();
            checkPass(pass1);
            System.out.println("Second time, Enter Your Password Again: ");
            pass2 = scanner.nextLine();
        }
        int idcode = 1000+countint;
        idNumber = "MR-PA-"+idcode;
        Random random = new Random();
        code = random.nextInt(9000)+1000;
        codestr = String.valueOf(code);
        from = System.getenv().getOrDefault("MENTRAPPY_GMAIL_USERNAME", "");
        GmailSender gmailsender = new GmailSender();
        gmailsender.sendEmail(email, from, codestr);
        System.out.println("Send A Verification Code To Your Email Id, Enter the Code: ");
        usercode = scanner.next();
        while (!codestr.equals(usercode))
        {
            System.out.println("Wrong Code, Please enter the Correct Code: ");
            usercode = scanner.next();
        }
        System.out.println("Successfully, You Registered Your Account");
        namelist.add(name);
        String namelocation = "D://study/Project/Data/Patient/name.txt";
        saveinfo.info(namelist,namelocation);
        emaillist.add(email);
        String emaillocation = "D://study/Project/Data/Patient/email.txt";
        saveinfo.info(emaillist,emaillocation);
        passlist.add(pass1);
        String passwordlocation = "D://study/Project/Data/Patient/password.txt";
        saveinfo.info(passlist,passwordlocation);
        idlist.add(idNumber);
        String idlocation = "D://study/Project/Data/Patient/id.txt";
        saveinfo.info(idlist,idlocation);
        countint++;
        String count = String.valueOf(countint);
        boolean savecount = saveinfo.info(count, "D://study/Project/Data/Patient/count.txt");
        user();
    }
    public static void doctorRegister()
    {
        Saveinfo saveinfo = new Saveinfo();
        ArrayList<String> namelist = new ArrayList<String>();
        ArrayList<String> emaillist = new ArrayList<String>();
        ArrayList<String> passlist = new ArrayList<String>();
        ArrayList<String> idlist = new ArrayList<String>();
        namelist = saveinfo.readinfo(namelist,"D://study/Project/Data/Doctor/name.txt");
        emaillist = saveinfo.readinfo(emaillist,"D://study/Project/Data/Doctor/email.txt");
        passlist = saveinfo.readinfo(passlist,"D://study/Project/Data/Doctor/password.txt");
        idlist = saveinfo.readinfo(idlist,"D://study/Project/Data/Doctor/id.txt");
        Scanner scanner = new Scanner(System.in);
        String name, email, pass1, pass2, idNumber, from, codestr, usercode;
        int code;
        String countlocation = "D://study/Project/Data/Doctor/count.txt";
        String countstr = Saveinfo.readinfo(countlocation);
        int countint = Integer.parseInt(countstr);
        System.out.println("Enter Your Name: ");
        name = scanner.nextLine();
        outputName(name);
        System.out.println("Enter Your E-mail: ");
        email = scanner.nextLine().toLowerCase();
        outputEmail(email);
        while(registeruserCheck(email,"D://study/Project/Data/Doctor/email.txt"))
        {
            System.out.println("This E-mail is Already Register");
            System.out.println("Enter Another E-mail: ");
            email = scanner.nextLine().toLowerCase();
            outputEmail(email);
        }
        System.out.println("Enter Your Password: ");
        pass1 = scanner.nextLine();
        checkPass(pass1);
        System.out.println("Enter Your Password Again: ");
        pass2 = scanner.nextLine();
        while (!pass1.equals(pass2))
        {
            System.out.println("Both Password are not Match");
            System.out.println("First time, Enter Your Password : ");
            pass1 = scanner.nextLine();
            checkPass(pass1);
            System.out.println("Second time, Enter Your Password Again: ");
            pass2 = scanner.nextLine();
        }
        int idcode = 1000+countint;
        idNumber = "MR-DA-"+idcode;
        Random random = new Random();
        code = random.nextInt(9000)+1000;
        codestr = String.valueOf(code);
        from = System.getenv().getOrDefault("MENTRAPPY_GMAIL_USERNAME", "");
        GmailSender gmailsender = new GmailSender();
        gmailsender.sendEmail(email, from, codestr);
        System.out.println("Send A Verification Code To Your Email Id, Enter the Code: ");
        usercode = scanner.next();
        while (!codestr.equals(usercode))
        {
            System.out.println("Wrong Code, Please enter the Correct Code: ");
            usercode = scanner.next();
        }
        System.out.println("Successfully, You Registered Your Account");
        namelist.add(name);
        String namelocation = "D://study/Project/Data/Doctor/name.txt";
        saveinfo.info(namelist,namelocation);
        emaillist.add(email);
        String emaillocation = "D://study/Project/Data/Doctor/email.txt";
        saveinfo.info(emaillist,emaillocation);
        passlist.add(pass1);
        String passwordlocation = "D://study/Project/Data/Doctor/password.txt";
        saveinfo.info(passlist,passwordlocation);
        idlist.add(idNumber);
        String idlocation = "D://study/Project/Data/Patient/id.txt";
        saveinfo.info(idlist,idlocation);
        countint++;
        String count = String.valueOf(countint);
        boolean savecount = saveinfo.info(count, "D://study/Project/Data/Doctor/count.txt");
        user();
    }
    public static void login()
    {
     Scanner scanner = new Scanner(System.in);
        String type;
        do
        {
        System.out.println("Choose your Account Type: \n 1: As A Patient\n 2: As A Doctor");
        type = scanner.next();
        }while(!type.equals("1") && !type.equals("2"));
        if (type.equals("1"))
        {
            patientLogin();
        }
        else
        {
            doctorLogin();
        }   
    }
    public static void patientLogin()
    {
        String email, pass, input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Login E-mail: ");
        email = scanner.nextLine().toLowerCase();
        while (!registeruserCheck(email,"D://study/Project/Data/Patient/email.txt"))
        {
            System.out.println("You are not a Register Member, first Register Yourself\n Enter:\n 1: go to Register Page\n 2: Try Again");
            input = scanner.next();
            while (!input.equals("1") && !input.equals("2"))
            {
            System.out.println("Invalid Input");
            System.out.println("You are not a Register Member, first Register Yourself\n Enter:\n 1: go to Register Page\n 2: Try Again");
            input = scanner.next();
            }
            if (input.equals("1"))
            {
                patientRegister();
                patientLogin();
            }
            else
            {
            System.out.println("Enter Your E-mail Again: ");
            email = scanner.nextLine().toLowerCase();
            }
        }
        System.out.println("Enter Your Password: ");
        pass = scanner.nextLine();
        int count = 1;
        while(loginpass(email,pass,"D://study/Project/Data/Patient/email.txt","D://study/Project/Data/Patient/password.txt"))
        {
            System.out.println("Password is Incorrect");
            System.out.println("Enter Your Password Again: ");
            pass = scanner.nextLine();
            count++;
            if(count==3)
            {
                String from = System.getenv().getOrDefault("MENTRAPPY_GMAIL_USERNAME", ""); 
                GmailSender gmailsender = new GmailSender();
                gmailsender.sendEmail(email, from, "Alert!!","Someone is Trying to Login Your Account\n if its you then okay otherwise, Change your password");
            }
        }
        System.out.println("Successfully Login in to Your Account");
    }
    public static void doctorLogin()
    {
        String email, pass, input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Login E-mail: ");
        email = scanner.nextLine().toLowerCase();
        while (!registeruserCheck(email,"D://study/Project/Data/Doctor/email.txt"))
        {
            System.out.println("You are not a Register Member, first Register Yourself\n Enter:\n 1: go to Register Page\n 2: Try Again");
            input = scanner.next();
            while (!input.equals("1") && !input.equals("2"))
            {
            System.out.println("Invalid Input");
            System.out.println("You are not a Register Member, first Register Yourself\n Enter:\n 1: go to Register Page\n 2: Try Again");
            input = scanner.next();
            }
            if (input.equals("1"))
            {
                doctorRegister();
                doctorLogin();
            }
            else
            {
            System.out.println("Enter Your E-mail Again: ");
            email = scanner.nextLine().toLowerCase();
            }
        }
        System.out.println("Enter Your Password: ");
        pass = scanner.nextLine();
        int count = 1;
        while(loginpass(email,pass,"D://study/Project/Data/Doctor/email.txt","D://study/Project/Data/Patient/password.txt"))
        {
            System.out.println("Password is Incorrect");
            System.out.println("Enter Your Password Again: ");
            pass = scanner.nextLine();
            count++;
            if(count==3)
            {
                String from = System.getenv().getOrDefault("MENTRAPPY_GMAIL_USERNAME", ""); 
                GmailSender gmailsender = new GmailSender();
                gmailsender.sendEmail(email, from, "Alert!!","Someone is Trying to Login Your Account\n if its you then okay otherwise, Change your password");
            }
        }
        System.out.println("Successfully Login in to Your Account");
    
    }
    
}
