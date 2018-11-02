package com.example.dre.individualprojectlussarv2.Model;



import java.util.ArrayList;

public class LoginBackend {



    private static ArrayList<String> mUsers = new ArrayList<String>(10);
    private static ArrayList<String> mPasswords = new ArrayList<String>(10);
    private static ArrayList<String> mFirstName = new ArrayList<String>(10);
    private static ArrayList<String> mLastName = new ArrayList<String>(10);
    private static ArrayList<String> mDOB = new ArrayList<String>(10);
    private static ArrayList<String> mEmail = new ArrayList<String> (10);


    public boolean validateLogin(String u, String p){

        if(u.equals(""))
        {
            return false;
        }

        if(p.equals(""))
        {
            return false;
        }

        if(mUsers.contains(u)) {
            int user_location = mUsers.indexOf(u);
            if (p.equals(mPasswords.get(user_location)))
            {
                return true;
            }

        }

        return false;
    }


    public boolean addUser(String u, String p){

        if(p.equals(""))
        {
            return false;
        }

        if(p.length() < 6)
        {
            return false;
        }

        if(mUsers.contains(u)){
            return false;
        }
        else
        {
            mUsers.add(u);
            mPasswords.add(p);
            return true;
        }
    }

    public boolean validNonBlank(String  u, String p, String fn, String ln, String em, String uDOB)
    {
        if(u.equals(""))
        {
            return false;
        }

        if(p.equals(""))
        {
            return false;
        }

        if(fn.equals(""))
        {
            return false;
        }

        if(ln.equals(""))
        {
            return false;
        }

        if(em.equals(""))
        {
            return false;
        }

        if(uDOB.equals(""))
        {
            return false;
        }

        return true;
    }

    public boolean validNames(String n){

        if(n.length() < 4)
        {
            return false;
        }

        if(n.length() > 30)
        {
            return false;
        }

        return true;
    }

    public boolean validEmail(String em)
    {
        if(em.length() < 6)
        {
            return  false;
        }

        if(em.length() > 70)
        {
            return false;
        }

        if(!em.contains("@"))
        {
            return false;
        }

        if(!em.contains("."))
        {
            return false;
        }

        return true;
    }


    // need to check this with a valid password
    // need to check this with a valid password
    // need to check this with a valid password

    public boolean validUnPass(String u, String p)
    {
        if(u.length() < 4)
        {
            return false;
        }

        if(p.length() < 4)
        {
            return false;
        }

        if(u.length() > 20)
        {
            return false;
        }

        if(p.length() > 20)
        {
            return false;
        }

        if(p.equals(p.toLowerCase())){
            return false;
        }


        return true;
    }

    public boolean addAccount(String u, String p, String fn, String ln, String em, String dob)
    {
        if(validNonBlank(u,p,fn,ln,dob,em))
        {
            if(validUnPass(u, p) && validNames(fn) && validNames(ln) && validEmail(em)) { //) && addUser(u, p)

                //ToDo add shared preference or sql storage for usernames
                //ToDo develop a user class to hold login info
                if (addUser(u, p))// adds to both Users and mPassword
                {
                    mFirstName.add(fn); // add user works something in validation is broken
                    mLastName.add(ln);
                    mDOB.add(dob);
                    mEmail.add(em);
                    return true;
                }
            }
        }

        return false;
    }

}

