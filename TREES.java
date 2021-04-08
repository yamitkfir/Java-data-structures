TREE NODE

// הפעולה מגרילה מספר בין 1-100. אם זוגי מחזירה T אחרת מחזירה F
public static boolean turn()
{
	int x=(int)((Math.random()*100)+1);
	if(x%2==0)
		return true;
	else
		return false;
}

//מקבלת שני פרמטרים: מצביע לשורש עץ, ומצביע לחוליה להוספה) הפעולה מטיילת כלפי מטה בעץ עד מציאת צומת "חסרת בן" ו"תופרת" את החוליה להוספה בתור הבן החסר (ימין או שמאל בהתאמה)
public static void InsertToTree(BinNode<Integer> T,BinNode<Integer> newChild)
{
	if(turn()) //להכניס לשמאל
	{
		if(T.getLeft()==null)
			T.setLeft(newChild);
		else
		{
			T=T.getLeft();
			InsertToTree(T,newChild);
		}
	}
	else //להכניס לימין
	{
		if(T.getRight()==null)
			T.setRight(newChild);
		else
		{
			T=T.getRight();
			InsertToTree(T,newChild);
		}
	}
}

//המקבלת שלושה ערכים: Size, Low, High. הפעולה מחזירה מצביע לשורש העץ.הפעולה תבנה עץ בעל Size צמתים (בלולאה) כך שערכו של כל צומת יוגרל בטווח בין Low-High ומיקומה של החוליה בעץ (למעט הראשונה) יהיה תוך זימון הפעולה InsertToTree. 
public static BinNode<Integer> genTree(int size,int low,int high)
{
	if(size>0){
		//ראשון
		BinNode<Integer> T=new BinNode<Integer>((int)(Math.random()*high)+low);
		while(size!=1)
		{
			BinNode<Integer> Ttemp=T;
			BinNode<Integer> temp=new BinNode<Integer>((int)(Math.random()*high)+low);
			InsertToTree(Ttemp,temp);
			size--;
		}
		return T;
	}
	else
		return null;
}

//מדפיסה את תכולת העץ בסריקה "תחילית" PreOrder
public static void PreOrder(BinNode<Integer> T)
{
	if(T!=null)
	{
		System.out.print(T.getValue());
		PreOrder(T.getLeft());//טיול שמאל
		PreOrder(T.getRight());//טיול ימין
	}
}

//מדפיסה את תכולת העץ בסריקה "תוכית" InOrder
public static void InOrder(BinNode<Integer> T)
{
	if(T!=null)
	{
		InOrder(T.getLeft());//טיול שמאל
		System.out.print(T.getValue());
		InOrder(T.getRight());//טיול ימין
	}
}

//מדפיסה את תכולת העץ בסריקה "סופית" PostOrder
public static void PostOrder(BinNode<Integer> T)
{
	if(T!=null)
	{
		PostOrder(T.getLeft());//טיול שמאל
		PostOrder(T.getRight());//טיול ימין
		System.out.print(T.getValue());
	}
}
//מקבלת מצביע לשורש עץ ומחזירה את מספר העלים בעץ
public static int CountLeaves(BinNode<Integer> T)
{
	if (T == null)
		return 0;
	if (T.getLeft() == null && T.getRight() == null)
		return 1;
	else
		return (CountLeaves(T.getLeft()) + CountLeaves(T.getRight()));
}

//פעולה CountNodes המקבלת עץ t1 ומחזירה את מספר הצמתים בעץ
public static int CountNodes (BinNode<Integer> T)
{
	if (T == null)
		return 0;
	if (T.getLeft() == null && T.getRight() == null)
		return 1;
	else
		if(T.getLeft()==null)
			return (1+CountNodes (T.getLeft()));
		if(T.getRight()==null)
			return (1+CountNodes (T.getRight()));
		else
			return (1+CountNodes (T.getLeft()) + CountNodes (T.getRight()));
}

//פעולה IsFound המקבלת עץ t1 ומספר n ומחזירה T אם המספר נמצא בעץ אחרת מחזירה שקר 
public static boolean IsFound(BinNode<Integer> T,int N)
{		
		 if (T == null)
			 return false;
		 if (N == T.getValue())
			 return true;          
		 if(IsFound(T.getLeft(),N)==true || IsFound(T.getRight(),N)==true)
			return true;
		 else 
			 return false;
}

//פעולה CountN המקבלת עץ t1 ומספר n ומחזירה את מספר הפעמים שהמספר n מופיע בעץ
public static int CountN(BinNode<Integer> T,int N)
{
	if(T!=null)
	{
		if(T.getValue()==N)
			return (1 + CountN(T.getLeft(),N) + CountN(T.getRight(),N));
		else
			return (CountN(T.getLeft(),N) + CountN(T.getRight(),N));
	}
	else
		return 0;
}

//פעולה SumTree המקבלת עץ t1 ומחזירה את סכום הערכים בעץ
public static int SumTree(BinNode<Integer> T,int N)
{
	if(T!=null)
	{
		
		return (T.getValue() + SumTree(T.getLeft(),N) + SumTree(T.getRight(),N));
		
	}
	else
		return 0;
}

//פעולה isIncluded המקבלת עץ t1 ועץ t2 ומחזירה T אם כל הערכים ב t1 מופיעים גם ב t2, אחרת שקר
public static boolean isIncluded(BinNode<Integer> t1,BinNode<Integer> t2){
	if(t1==null)
		return true;
	if(IsFound(t2,t1.getValue())&&isIncluded(t1.getLeft(),t2) && isIncluded(t1.getRight(),t2))
		return true;
	else
		return false;
	}
//פעולה בשם isEqual המקבלת עץ t1 ועץ t2 ומחזירה T אם העצים מכילים ערכים זהים בדיוק
public static boolean isEqual(BinNode<Integer> t1,BinNode<Integer> t2){
	return (isIncluded(t1,t2)&&isIncluded(t2,t1));
}
//כתבי פעולה בשם Height המקבלת עץ t1 ומחזירה את גובהו של העץ
public static int Height(BinNode<Integer> t)
{
	if(t==null)
		return -1;
	if(Height(t.getLeft())>Height(t.getRight()))
		return 1+Height(t.getLeft());
	return 1+Height(t.getRight());
}

//מחזירה האם העץ הוא מאוזן בעזרת הסתמכות על הבדיקה CHECK
public static boolean isBalanced(BinNode<Integer> T) {
	if (T == null)
		return true;
	if (check(T) == -1)
		return false;
	return true;
}

//בדיקה האם הרמות שוות 
public static int check(BinNode<Integer> T) {
	if (T == null)
		return 0;
	int left = check(T.getLeft());
	int right = check(T.getRight());

	if (left == -1 || right == -1)
		return -1;

	if (Math.abs(left - right) > 1) {
		return -1;
	}

	return Math.max(left, right) + 1;

}

public static void PreOrder(BinNode<Integer> T)
{
	if(T!=null)
	{
		System.out.print(T.getValue());
		PreOrder(T.getLeft());
		PreOrder(T.getRight());
	}
}
public static void InOrder(BinNode<Integer> T)
{
	if(T!=null)
	{
		InOrder(T.getLeft());
		System.out.print(T.getValue());
		InOrder(T.getRight());
	}
}
public static void PostOrder(BinNode<Integer> T)
{
	if(T!=null)
	{
		PostOrder(T.getLeft());
		PostOrder(T.getRight());
		System.out.print(T.getValue());
	}
}

public static int CountLeaves(BinNode<Integer> T)
{
	if (T == null)
		return 0;
	if (T.getLeft() == null && T.getRight() == null)
		return 1;
	else
		return (CountLeaves(T.getLeft()) + CountLeaves(T.getRight()));
}