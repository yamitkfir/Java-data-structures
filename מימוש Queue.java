//QUEUE- STACK
public class QueArr {

	private int[] a;
	private int b;
	private int e;
	//פעולה בונה מאתחלת
	 public  QueArr() 
	   {
		a = new int [100];
		b = 0;
		e=-1;
	   }
	//פעולה בונה
	 public  QueArr(int[] a,int b,int e) 
	   {
		this.a = a;
		this.b = b;
		this.e=e;
	   }
	 //מקבל ערך ומכניס אותו לתור
	 public void insert(int i) 
	 {

		if(e>=a.length-1)
		{
			int[] c= new int[a.length+100];
			int i1=0;
			while(i1<=a.length-1)
			{
				c[i1]=a[i1];
				i1++;
			}
			a=c;
		}

		a[++e]= i;

	 }
	//מוציא את הראש של התור ומחזיר את הערך שלו
	 public int remove() 
	 {
		 return a[b++];
	 }
	//מחזיר את הראש של התור
	 public int head()
	 {
			return a[b]; 
	 }

	//מחזיר אמת אם התור ריק ולהפך
	 public boolean isEmpty() 
	 {
		 if ( e<b) 
		 {
			 return true;
		 }
		 else
			return false;
	 }
	//פעולה שמחברת את התור ומדפיסה אותו
	 public String toString() 
	 {
		String s;
		 if ( e<b) 
		 {
		   s="[]";
		 }
		 else
		 {
			int i=b;
			s="[";
			while(i<=e)
				{
				s=s+a[i]+", ";
				i++;
				}
			s=s+"]";
		 }
		return s;
		 
	 }
}
