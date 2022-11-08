import java.util.*;


 class Url {

    private String url;
    private int count;
    private int shortUrl;
    
    Url(String url,int count, int shortUrl)
    {
        this.url = url;
        this.count = count;
        this.shortUrl = shortUrl;
    }

    public void setCount(){   
        this.count += 1;
    }
    public String getUrl() {
        return url;
    }
    public int getCount() {
        return count;
    }
    public int getShortUrl() {
        return shortUrl;
    }
    
    public void display()
    {
        System.out.println(url + " " + count + " " + shortUrl); 
        System.out.println();
    }

}

public class javaAssignment
{
    static int shortURLtoID(String shortURL)
    {
        int id = 0;
     
        for (int i = 0; i < shortURL.length(); i++)
        {
            if ('a' <= shortURL.charAt(i) &&
                       shortURL.charAt(i) <= 'z')
            id = id * 62 + shortURL.charAt(i) - 'a';
            if ('A' <= shortURL.charAt(i) &&
                       shortURL.charAt(i) <= 'Z')
            id = id * 62 + shortURL.charAt(i) - 'A' + 26;
            if ('0' <= shortURL.charAt(i) &&
                       shortURL.charAt(i) <= '9')
            id = id * 62 + shortURL.charAt(i) - '0' + 52;
        }
        return id;
    }
    
	public static void main(String[] args) {
	    
		System.out.println("URL DATABASE ");
		
		Scanner sc = new Scanner(System.in);
		
		String command = "";
		
        ArrayList<Url> database = new ArrayList<Url>();
        Vector<Url> v = new Vector<Url>();

        
		while(true){
		    		command = sc.nextLine();
		    		String[] arrOfStr = command.split(" ", 2);
                    if(arrOfStr[0].equals("exit")){
                        break;
                    }
		    		else if(arrOfStr[0].equals("storeurl")){
                        Boolean flag = false;
                        for (int i=0;i<database.size();i++){
                            if(database.get(i).getUrl().equals(arrOfStr[1])){
                                flag = true;
                                System.out.println("URL is already in DataBase ");
                            }
                        }
                        if(!flag){
                            v.add(new Url(arrOfStr[1], 0, shortURLtoID(arrOfStr[1])));
                        database.add(v.get(v.size()-1));
                        }
                    }

                    else if(arrOfStr[0].equals("get")){
                        for (int i=0;i<database.size();i++){
                         if(database.get(i).getUrl().equals(arrOfStr[1])){
                            database.get(i).setCount();
                            System.out.println(database.get(i).getShortUrl());
                         }
                        }
                     }

                     else if(arrOfStr[0].equals("count")){
                        for (int i=0;i<database.size();i++){
                         if(database.get(i).getUrl().equals(arrOfStr[1])){
                            System.out.println(database.get(i).getCount());
                         }
                        }
                     }
                    
                	else if(arrOfStr[0].equals("list")){
                       for (int i=0;i<database.size();i++){
                        database.get(i).display();
                       }
                    }
                    
		}
	}
}
