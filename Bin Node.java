public static BinNode<Integer> RemoveInBinNode(BinNode<Integer> first, BinNode<Integer> remove)
{
	if(first==null)
		return first;
	if(first==remove)
	{
		first=first.getRight();
		first.setLeft(null);
		return first;
	}
	else
	{
		BinNode<Integer> f=first;
		while(f!=null)
		{
			if(f==remove)
			{
				BinNode<Integer> left=f.getLeft();
				BinNode<Integer> right=f.getRight();
				left.setRight(f.getRight());
				if(right!=null)
					right.setLeft(f.getLeft());
				return first;
			}
			f=f.getRight();
		}
	}
	return first;
	
}

public static BinNode<Integer> findMinInBinNode(BinNode<Integer> first)
{
	BinNode<Integer> f=first; //שומרת ראשון
	if(first==null||first.getRight()==null) //מצב בו יש אחד או אין בכלל חוליות
		return first;
	else
	{
		BinNode<Integer> minNode=f;
		while(f!=null)
		{

			if(minNode.getValue()>f.getValue()) //משווה בין המינימום למקום הנוכחי
				minNode=f;
			f=f.getRight();
		}
		return minNode; //מחזיר את המינימום
	}
}

public static BinNode<Integer> SortBinNode(BinNode<Integer> first)
{
	if(first==null||first.getRight()==null) //למקרה שיש רק אחד או אין בכלל חוליות ברשימה
		return first;
	else
	{
		BinNode<Integer> f=first; //שמירה על הראשון
		BinNode<Integer> minF=findMin(f);
		//אם זה האיבר הראשון אין טעם להעביר אותו ולכן עושים את הבידקה
		if(f!=minF){
			f=remove(f,minF);
			minF.setLeft(null);
			minF.setRight(f);
			f.setLeft(minF);
		}
		else
			f=f.getRight();

		while(f.getRight()!=null) //בודק את כל שאר המערך
		{

			BinNode<Integer> min=findMin(f);
			if(f!=min){
				f=remove(f,findMin(f));
				min.setLeft(f.getLeft());
				min.setRight(f);
				f.getLeft().setRight(min);
				f.setLeft(min);
			}
			else
				f=f.getRight();
		}
		return minF;
	}
}

public static BinNode<Integer> genBinList (int size)
{
	if(size==0)
		return null;
	BinNode<Integer> f=new BinNode<Integer>(((int)((Math.random()*999)+100)));
	f.setLeft(null);
	BinNode<Integer> first=f;
	for(int i=0; i<size; i++){
		BinNode<Integer> n=new BinNode<Integer>(first,((int)((Math.random()*999)+100)),null);
		first.setRight(n); // השמת המצביע על השמאלי
		first=n;
	}
return f;
}

public static int BinNodeLen(BinNode<Integer> first)
{
	int counter=0;
	BinNode<Integer> f=first;
	while(f.getRight()!=null)
	{
		counter++;
		f=f.getRight();
	}
	return counter;
}

public static int findMinOrMax(BinNode<Integer> first, boolean MinOrMax)
{
	BinNode<Integer> f=first;
	if(first==null)
		return -1;
	if(MinOrMax==true)
	{
		int minNode=f.getValue();
		while(f.getRight()!=null)
		{
			if(minNode>f.getValue())
				minNode=f.getValue();
			f=f.getRight();
		}
		return minNode;
	}
	else
	{
		int maxNode=f.getValue();
		while(f.getRight()!=null)
		{
			if(maxNode<f.getValue())
				maxNode=f.getValue();
			f=f.getRight();
		}
		return maxNode;
		
	}
}

//returns a pointer to the node with the asked value. if doesnt exist, null.
public static BinNode<Integer> getNode(BinNode<Integer> first, int min)
{
	BinNode<Integer> f=first;
	if(f==null)
	{
		return null;
	}
	else
		{
			while(f.getRight()!=null)
			{
				if(min==f.getValue())
					return f;
				f=f.getRight();
			}
		}
	return null;
}

//REMOVE A NODE FROM BINNODE
public static BinNode<Integer> Remove(BinNode<Integer> first, BinNode<Integer> remove)
{
	if(first==null)
	{
		return first;
	}
	if(first==remove)
	{
		first=first.getRight();
		first.setLeft(null);
		return first;
	}
	else
	{
		BinNode<Integer> f=first;
		while(f.getRight()!=null)
		{
			if(f==remove)
			{
				BinNode<Integer> left=f.getLeft();
				BinNode<Integer> right=f.getRight();
				left.setRight(f.getRight());
				right.setLeft(f.getLeft());
				return first;
			}
			else
				f=f.getRight();
		}
	}
	return first;
	
}

public static void BinNodeToRing(BinNode<Integer> first)
{
	BinNode<Integer> f=first;
	if(first!=null)
	{
		while(f.hasRight()){
			f=f.getRight();
		}
		first.setLeft(f);
		f.setRight(first);
	
	}

}
