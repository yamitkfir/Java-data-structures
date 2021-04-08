// המקבלת ערכי Size, Low, High ויוצרת רשימה של Nodes של Integer ומחזירה את החוליה שבראש הרשימה
public static Node<Integer> listGen(int lo, int high, int size)
{
	if(size==0)
		return null;
	Node<Integer> first=null;
	for(int i=0; i<size; i++){
		Node<Integer> n=new Node<Integer>(((int)((Math.random()*(high-lo))+lo)),first);
		first=n;
	}
	return first;
}

// פעולה המקבלת רשימה של חוליות ומחזירה את גודל הרשימה
public static int countSize(Node<Integer> first)
{
	if(first==null)
		return 0;
	else
		return(1+countSize(first.getNext()));
}

// פעולה בשם StrList המקבלת חוליה ומחזירה מחרוזת של כל השרשרת
public static String STRList(Node<Integer> first)
{
	String s="";
	while (first.hasNext())
	{
		s= s+ first.getValue()+ " ";
		first=first.getNext();
	}
	s=s+first.getValue();
	return s;
}

// פעולה בשם GetIt המקבלת רשימת חוליות וערך, ומחזירה מצביע לחוליה שה Value שלה שווה לערך
public static Node<Integer> getIt (Node<Integer> first, int num)
{
	Node<Integer> c=null;
	while(first!=null)
	{
		if(first.getValue()==num)
			c=first;
		first=first.getNext();	
	}
	return c;
}

// פעולה כמו (4) ומחזירה T/F אם הערך נמצא ברשימה או לא
public static boolean isFound(Node<Integer> first, int num)
{
	boolean b=false;
	while(first!=null)
	{
		if(first.getValue()==num)
			b=true;
		first=first.getNext();
	}
	return b;
}

// מכניסה את החוליה after אחרי pt
public static void InsertAfter (Node<Integer> after, Node<Integer> pt)
{
	if(pt.hasNext())

		after.setNext(pt.getNext());
		pt.setNext(after);
	}
	else
	{
		after.setNext(null);
		pt.setNext(after);	
	}
}

//פעולה שמקבלת שלוש חוליות first שמייצגת את החוליה הראשונה ומכניסה את החוליה bef לפני החוליה pt
public static Node<Integer> insertBefore( Node<Integer> first ,Node<Integer> bef, Node< Integer > pt){
	Node<Integer> f=first;
	if(f==pt)
	{
		bef.setNext(first);
		first=bef;
		return first;
	}
	else{
	while(f.hasNext())
	{
		if(f.getNext()==pt)
		{
		   bef.setNext(f.getNext());
		   f.setNext(bef);
		   f=pt;
		}
		else
			f = f.getNext();
	}
	return first;
}


//פעולה שמקבלת את החוליה הראשונה first ומצביע לחוליה pt בתוך השרשרת חוליות, הפעולה מוציאה את החוליה ש pt מצביע אליו מהרשימה ומחזירה את החוליה הראשונה ברשימה המעודכנת.
public static Node<Integer> remove(Node<Integer> first, Node<Integer> pt)
{ 	
	if(first==null||!first.hasNext())
		return first;
	if(first==pt)
	{
		first=first.getNext();
		return first;
	}
	Node<Integer> f=first;

	while(f!=null)
	{
	   if(f.getNext()==pt)
		   f.setNext(pt.getNext());
	   f = f.getNext();
	}
	return first;
}
//מקבלת את ראש הרשימה ומחזירה מצביע לחוליה עם הערך הנמוך ביותר ברשימה
public static Node<Integer> findMin(Node<Integer> first)
{
	Node<Integer> f=first;
	Node<Integer> min=f;
	if(!first.hasNext())
		return first;
	while(f!=null){
		if(min.getValue()>f.getValue())
			min=f;
	    f= f.getNext();
	}
	return (min);
}
//מקבלת את ראש הרשימה, הפעולה ממיינת את הרשימה ומחזירה את ראש הרשימה
public static  Node<Integer> sortLis(Node<Integer> first)
{
	if(first==null||!first.hasNext())
		return first;
	else
	{
		Node<Integer> f=first;
		Node<Integer> minf=findMin(f);
		f=remove(f,findMin(f.getNext()));
		f=insertBefore(f, minf, f);
		while(f.getNext().hasNext())
		{
			Node<Integer> min=findMin(f.getNext());
			f=remove(f,findMin(f.getNext()));
			f=insertBefore(f, min , f.getNext());
			f=f.getNext();
		}
		return minf;
	}
}

//מקבלת 2 מצביעים לשתי רשימות ממויינות וממזגת את שתי הרשימות לרשימה אחת ממויינת. הפעולה מחזירה את ראש הרשימה החדשה
public static Node<Integer> mergeLits(Node<Integer> first1,Node<Integer> first2)
{
	Node<Integer> f1=first1;
	Node<Integer> f2=first2;
	Node<Integer> mergeLitsf=null;
	if(first1==null)
		return first2;
	if(first2==null)
		return first1;
	if (first1.getValue() <first2.getValue() )
	{
		mergeLitsf=f1;
		f1=f1.getNext();
	}
	else
	{
		mergeLitsf=first2;
		f2=f2.getNext();		
	}
	System.out.print(mergeLitsf.getValue()+" ");
	Node<Integer> first3=mergeLitsf;
	while (f1!=null && f2!=null)
	{
		if (f1.getValue() <f2.getValue() )
		{
			mergeLitsf.setNext(f1);
			mergeLitsf=mergeLitsf.getNext();
			f1=f1.getNext();
		}
		else
		{
			mergeLitsf.setNext(f2);
			mergeLitsf=mergeLitsf.getNext();
			f2=f2.getNext();
		}
	}
	while (f1!=null)
	{
	   mergeLitsf.setNext(f1);
	   mergeLitsf=mergeLitsf.getNext();
	   f1=f1.getNext();
	}
	while (f2!=null)
	{
		mergeLitsf.setNext(f1);
		mergeLitsf=mergeLitsf.getNext();
		f2=f2.getNext();
	}
	return first3;
}


