חיפושים

אריה במדבר רגיל
public static int binarySearchRecursive(int search, int[] array, int start, int end){
	int middle = (start + end)/2;
	if(end < start){
		 return -1;
	} 
	if (search < array[middle]){
		return binarySearchRecursive(search, array, start, middle - 1);
	}
	if (search > array[middle]){
		return binarySearchRecursive(search, array, middle + 1, end);
	}
	if (search == array[middle]){
		return middle;
	}
	return -1;
}

אריה במדבר רקורסיבי
public static int binarySearch(int[] a, int start, int end, int target) {
	int middle = (start + end) / 2;
	if(end < start) {
		return -1;
	}
	if(target==a[middle]) {
		return middle;
	} else if(target<a[middle]) {
		return binarySearch(a, start, middle - 1, target);
	} else {
		return binarySearch(a, middle + 1, end, target);
	}
}

מיזוג
public static int[] inToTheArray(int[] a, int[] b)
{
	int i=0;
	int j=0;
	int k=0;
	int[] answer=new int[a.length+b.length];
	
	while (i < a.length && j < b.length)
	{
		if (a[i] < b[j])
		{
			answer[k] = a[i];
			i++;
		}
		else
		{
			answer[k] = b[j];
			j++;
		}
		k++;
	}
	while (i < a.length)
	{
		answer[k] = a[i];
		i++;
		k++;
	}

	while (j < b.length)
	{
		answer[k] = b[j];
		j++;
		k++;
	}
	return answer;
}
	
public static void SortIt(int[] a)
{
	int i, t,j;
	for (j=0; j<a.length-1; j++)
	{
		for (i=0; i<a.length-1-j; i++)
		{
			if(a[i]>a[i+1])
			{
				t= a[i];
				a[i]=a[i+1];
				a[i+1]=t;
			}
			
		}
	}
}
public static void print(int[] shira)
{
	int i;
	for (i=0;i<shira.length; i++)
	 {
		 System.out.print(shira[i]+ " "); 
	 }
	 System.out.println();
}
	
מיון
public static void BubbleSort( int [ ] num )
{
	int j;
	boolean flag = true; // set flag to true to begin first pass
	int temp; //holding variable
	while ( flag )
	{
		flag= false;    //set flag to false awaiting a possible swap
		for( j=0;  j < num.length -1;  j++ )
		{
		   if ( num[ j ] < num[j+1] )   // change to > for ascending sort
		   {
				   temp = num[ j ];                //swap elements
				   num[ j ] = num[ j+1 ];
				   num[ j+1 ] = temp;
				  flag = true;              //shows a swap occurred  
			}
		} 
	} 
}
public static int[] recursiveBubbleSort(int[] list, int n) {
	if (n == 1) {
		return list;
	}
	
	int temp;
	for (int i = 0; i < n-1; i++) {
		if (list[i+1] < list[i]) {
			temp = list[i];
			list[i] = list[i+1];
			list[i+1] = temp;
		}
	}
	return recursiveBubbleSort(list, n-1);
}

פשוטים
public static int[] genArr(int size, int lo, int hi) {
	int[] a = new int[size];
	for (int i = 0; i < size; i++) {
		a[i] = (int) ((Math.random() * hi) + lo);
	}
	return a;
}

public static void sortArr(int[] a) {
	int i, t, j;
	for (j = 0; j < a.length - 1; j++) {
		for (i = 0; i < a.length - 1 - j; i++) {
			if (a[i] > a[i + 1]) {
				t = a[i];
				a[i] = a[i + 1];
				a[i + 1] = t;
			}
		}
	}
}

public static int binArrSearch(int[] a, int num) {
	int p = -1;
	int i;
	int b = 0;
	int e = a.length;
	int m;
	boolean flag = true;
	while (flag) {
		m = (b + e) / 2;

		if (b >= e)
			flag = false;

		if (a[m] == num)
			p = m;

		if (a[m] > num)
			e = m;
		else
			b = m + 1;
	}
	return p;
}

public static Boolean anyPrime(int[] a) {
	int i = 0;
	boolean flag = false;
	while (!flag || i > a.length) {
		int l = 0;
		int counter = 0;

		for (l = a[i]; l >= 1; l--)
			if (a[i] % l == 0)
				counter = counter + 1;

		if (counter == 2) {
			flag = true;
		} else
			i++;

	}
	return flag;
}
